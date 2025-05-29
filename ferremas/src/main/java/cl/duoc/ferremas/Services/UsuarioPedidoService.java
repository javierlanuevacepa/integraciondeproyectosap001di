package cl.duoc.ferremas.Services;




import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.UsuarioPedido;
import cl.duoc.ferremas.Models.ModelsDTO.UsuarioPDetalleDTO;
import cl.duoc.ferremas.Models.ModelsDTO.UsuarioPedidoDTO;
import cl.duoc.ferremas.Models.UsuarioPDetalle;
import cl.duoc.ferremas.Models.PrecioPHistorial;
import cl.duoc.ferremas.Models.Producto;
import cl.duoc.ferremas.Models.UPedidoDetalleId;
import cl.duoc.ferremas.Models.Usuario;
import cl.duoc.ferremas.Repository.PrecioPHistorialRepository;
import cl.duoc.ferremas.Repository.ProductoRepository;
import cl.duoc.ferremas.Repository.UsuarioPDetalleRepository;
import cl.duoc.ferremas.Repository.UsuarioPedidoRepository;
import cl.duoc.ferremas.Repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioPedidoService {
    
    private final UsuarioPedidoRepository usuarioPedidoRepository;

    private final UsuarioPDetalleRepository usuarioPDetalleRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioPedidoService(UsuarioPedidoRepository usuarioPedidoRepository,UsuarioPDetalleRepository usuarioPDetalleRepository,ProductoRepository productoRepository,UsuarioRepository usuarioRepository){
        this.usuarioPedidoRepository = usuarioPedidoRepository;
        this.usuarioPDetalleRepository = usuarioPDetalleRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }


    public List<UsuarioPedido> listarTodosLosPedidos(){
        return usuarioPedidoRepository.findAll();
    }


    public Optional<UsuarioPedido> encontrarConId(Long idPedido){
        return usuarioPedidoRepository.findById(idPedido);
    }


    public UsuarioPedido registrarPedido(UsuarioPedidoDTO pedidoDTO){
        // Mapear DTO a entidad:
       UsuarioPedido pedido = new UsuarioPedido();
       pedido.setEstadoPedido("PENDIENTE");
       pedido.setFechaRegistro(LocalDate.now());
       pedido.setHoraRegistro(LocalTime.now());
   
       // Buscar el cliente por ID
       Usuario cliente = usuarioRepository.findById(pedidoDTO.getIdCliente())
                             .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
       pedido.setClientePedido(cliente);
   
       // Mapear detalles
       List<UsuarioPDetalle> detalles = new ArrayList<>();
       for (UsuarioPDetalleDTO detalleDTO : pedidoDTO.getDetalles()) {
           UsuarioPDetalle detalle = new UsuarioPDetalle();
           
           detalle.setPedido(pedido); // establecer relación
           detalle.setCantidad(detalleDTO.getCantidad());
           detalle.setPrecioUnitario(detalleDTO.getPrecioUnitario());
           detalle.setFechaRegistro(LocalDate.now());
           detalle.setHoraRegistro(LocalTime.now());
   
           Producto producto = productoRepository.findById(detalleDTO.getIdProducto())
                                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
           detalle.setProducto(producto);
   
           // establecer ID embebido
           UPedidoDetalleId id = new UPedidoDetalleId();
           id.setIdPedido(pedido.getIdPedido()); // si usas persist primero
           id.setIdProducto(producto.getIdProducto());
           detalle.setId(id);
   
           detalles.add(detalle);
       }
   
       pedido.setDetalles(detalles);
       
       return usuarioPedidoRepository.save(pedido); // persistir todo
    }

    //Cambiar el estado del pedido etc
    public UsuarioPedido actualizarPedido(Long idPedido, String nuevoEstado){
        UsuarioPedido pedido = usuarioPedidoRepository.findById(idPedido).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado con id: " + idPedido));

        pedido.setEstadoPedido(nuevoEstado);
        return usuarioPedidoRepository.save(pedido);

    }
    







}
