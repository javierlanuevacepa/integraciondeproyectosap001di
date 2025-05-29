package cl.duoc.ferremas.Controllers;


import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ferremas.Models.Usuario;
import cl.duoc.ferremas.Models.UsuarioPDetalle;
import cl.duoc.ferremas.Models.UsuarioPedido;
import cl.duoc.ferremas.Models.ModelsDTO.UsuarioPedidoDTO;
import cl.duoc.ferremas.Repository.UsuarioPedidoRepository;
import cl.duoc.ferremas.Repository.UsuarioRepository;
import cl.duoc.ferremas.Services.UsuarioPedidoService;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v0/pedido")
public class UsuarioPedidoController {

    private final UsuarioPedidoService usuarioPedidoService;


    public UsuarioPedidoController(UsuarioPedidoService usuarioPedidoService){
        this.usuarioPedidoService = usuarioPedidoService;
    }


    @GetMapping("")
    public List<UsuarioPedido> listarTodosLosPedidos(){
        return usuarioPedidoService.listarTodosLosPedidos();
    }

    @PostMapping("")
    public ResponseEntity<UsuarioPedido> crearPedido(@RequestBody UsuarioPedidoDTO usuarioPedido) {
        
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioPedidoService.registrarPedido(usuarioPedido));
    }



    @PutMapping("/{id}/estado")
    public UsuarioPedido actualizarEstadoPedido( @PathVariable Long id,
        @RequestBody Map<String, String> body) {
        
            String nuevoEstado = body.get("estado");
            return usuarioPedidoService.actualizarPedido(id, nuevoEstado);
    
    }
    
    


}
