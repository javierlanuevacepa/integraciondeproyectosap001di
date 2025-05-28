package cl.duoc.ferremas.Controllers;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.duoc.ferremas.Services.ProductoService;
import cl.duoc.ferremas.Services.SucursalService;
import jakarta.validation.Valid;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.ModelsDTO.ProductoRDTO;
import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Producto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.math.BigDecimal;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/v0/producto")
public class ProductoController {

    private final ProductoService productoService;


    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }

    @GetMapping("")
    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    @PostMapping("")
    public ResponseEntity<Producto> registrarProducto( @RequestBody ProductoRDTO producto) {
        Producto product = productoService.registrarProducto(producto);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(product.getIdProducto())
        .toUri();

        return ResponseEntity
        .created(location) // Código 201 + header Location
        .body(product); 
    }
    
    @GetMapping("/buscar")
    public ResponseEntity<List<Producto>> buscarProductos(
        @RequestParam(required = false) String nombre,
        @RequestParam(required = false) String categoria,
        @RequestParam(required = false) String codigo,
        @RequestParam(required = false) String marca,
        @RequestParam(required = false) Integer stockMaximo
    ) {
        List<Producto> resultados = productoService.listarProductoConFiltros(nombre, categoria,codigo, marca, stockMaximo);
        return ResponseEntity.ok(resultados);
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoRDTO productus) {
        
        Producto resultado = productoService.actualizarProducto(id, productus);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(resultado.getIdProducto())
        .toUri();

        return ResponseEntity
        .created(location) // Código 201 + header Location
        .body(resultado); 
    }

    @PutMapping("actualizarPrecio/{id}/{precioActualizado}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @PathVariable BigDecimal precioActualizado) {
        
        Producto resultado = productoService.actualizarPrecioP(id, precioActualizado);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(resultado.getIdProducto())
        .toUri();

        return ResponseEntity
        .created(location) // Código 201 + header Location
        .body(resultado); 
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Long id){

        productoService.eliminarProductoConId(id);
        return ResponseEntity.ok("Producto eliminado correctamente.");
        
    }


    


}
