package cl.duoc.ferremas.Services;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Categoria;
import cl.duoc.ferremas.Models.Marca;
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
        Categoria categoriaP = categoriaRepository.findByNombreCategoria(productoRdto.getCategoria())
        .orElseThrow(() -> new EntityNotFoundException("Categoria con nombre " + productoRdto.getCategoria() + " no encontrada."));
        Producto nuevoP = productoRepository.save(new Producto(marcaP,categoriaP,productoRdto.generarCodigo(),productoRdto.getNombreP(),productoRdto.getPrecioP()));
        sucursalStockPService.registrarSucursalTodasStockP(nuevoP, productoRdto.getCantidadStock());
        precioPHistorialService.registrarHistorialPrecioP(nuevoP);
        return productoRepository.findById(nuevoP.getIdProducto())
        .orElseThrow(() -> new EntityNotFoundException("Codigo con id "+nuevoP.getIdProducto()+" no encotrado."));
    }


    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }



    public void eliminarProductoConId(Long id){
        productoRepository.deleteById(id);
    }



}
