package cl.duoc.ferremas.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Categoria;
import cl.duoc.ferremas.Models.Marca;
import cl.duoc.ferremas.Models.PrecioPHistorial;
import cl.duoc.ferremas.Models.Producto;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.SucursalStockP;
import cl.duoc.ferremas.Models.ModelsDTO.ProductoRDTO;
import cl.duoc.ferremas.Services.SucursalStockPService;
import cl.duoc.ferremas.Services.PrecioPHistorialService;
import cl.duoc.ferremas.Repository.CategoriaRepository;
import cl.duoc.ferremas.Repository.MarcaRepository;
import cl.duoc.ferremas.Repository.ProductoRepository;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class ProductoService {
    

    private final ProductoRepository productoRepository;
    private final SucursalStockPService sucursalStockPService;
    private final PrecioPHistorialService precioPHistorialService;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;

    public ProductoService(ProductoRepository productoRepository,SucursalStockPService sucursalStockPService,
    PrecioPHistorialService precioPHistorialService,MarcaRepository marcaRepository,CategoriaRepository categoriaRepository){
        this.productoRepository = productoRepository;
        this.sucursalStockPService = sucursalStockPService;
        this.precioPHistorialService = precioPHistorialService;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    // AL CREAR UN PRODUCTO SE CREA TAMBIEN SUCURSAL STOCK Y PRECIO P

    public Producto registrarProducto(ProductoRDTO productoRdto){
        Marca marcaP = marcaRepository.findByNombreMarcaContainingIgnoreCase(productoRdto.getMarca())
        .orElseThrow(() -> new EntityNotFoundException("Marca con nombre" + productoRdto.getMarca() + " no encontrada."));
        Categoria categoriaP = categoriaRepository.findByNombreCategoriaContainingIgnoreCase(productoRdto.getCategoria())
        .orElseThrow(() -> new EntityNotFoundException("Categoria con nombre " + productoRdto.getCategoria() + " no encontrada."));
        Producto nuevoP = productoRepository.save(new Producto(marcaP,categoriaP,productoRdto.generarCodigo(),productoRdto.getNombreP(),productoRdto.getPrecioP()));
        sucursalStockPService.registrarSucursalTodasStockP(nuevoP, productoRdto.getCantidadStock());
        precioPHistorialService.registrarHistorialPrecioP(nuevoP);
        return productoRepository.findById(nuevoP.getIdProducto())
        .orElseThrow(() -> new EntityNotFoundException("Codigo con id "+nuevoP.getIdProducto()+" no encotrado."));
    }

    //Este usarlo solo en caso puntual.
    public void actualizarPrecioProducto(Long id,BigDecimal precioActualizado){
        Producto productoC = productoRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + id));
        PrecioPHistorial precioHistorialOld = precioPHistorialService.encontrarPHistorialMasRecientePorProductoId(id);
        precioHistorialOld.setFechaFin(LocalDate.now());
        precioHistorialOld.setHoraFin(LocalTime.now());
        productoC.setPrecioP(precioActualizado);
        productoRepository.save(productoC);
        precioPHistorialService.registrarHistorialPrecioP(productoC);
    }

    public Producto actualizarProducto(Long idProducto,ProductoRDTO product){

        Producto productoC = productoRepository.findById(idProducto)
        .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con ID: " + idProducto));

        if (product.getCategoria()!=null){
            Categoria cate = categoriaRepository.findByNombreCategoriaContainingIgnoreCase(product.getCategoria())
            .orElseThrow(() -> new EntityNotFoundException("Categoria con nombre: " +product.getCategoria()+" no encontrada."));
            productoC.setCategoriaP(cate);
        }

        if (product.getMarca()!=null){
            Marca mark = marcaRepository.findByNombreMarcaContainingIgnoreCase(product.getMarca())
            .orElseThrow(() -> new EntityNotFoundException("Marca con nombre: " +product.getMarca()+" no encontrada."));
            productoC.setMarcaP(mark);
        }

        if (product.getNombreP()!=null){
            productoC.setNombreProducto(product.getNombreP());
        }

        if (product.getPrecioP()!=null){
            if (product.getPrecioP()!=productoC.getPrecioP()){
                precioPHistorialService.finalizarHistorialPrecio(idProducto);
                productoC.setPrecioP(product.getPrecioP());
                precioPHistorialService.registrarHistorialPrecioP(productoC);
            }
        }
        return productoRepository.save(productoC);
    }



    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public List<Producto> listarProductoConFiltros(String nombreP,String codigoP,String categoriaP,String marcaP,Integer stockMaximo){
        return productoRepository.buscarPorFiltros(nombreP,codigoP,categoriaP, marcaP, stockMaximo);
    }



    public void eliminarProductoConId(Long id){
        precioPHistorialService.eliminarHistorialDePrecios(id);
        sucursalStockPService.eliminarConIdProducto(id);
        productoRepository.deleteById(id);
    }



}
