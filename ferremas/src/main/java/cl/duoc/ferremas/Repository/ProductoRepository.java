package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    Producto findBynombreProducto(String nombreProducto);

    Producto findBycodigoProducto(String codigoProducto);

    



    // LISTAR PRODUCTOS POR MARCA
    List<Producto> findByMarcaPNombreMarcaContainingIgnoreCase(String nombreMarca);

    // LISTAR PRODUCTOS POR CATEGORIA
    List<Producto> findByCategoriaPNombreCategoriaContainingIgnoreCase(String nombreMarca);


}
