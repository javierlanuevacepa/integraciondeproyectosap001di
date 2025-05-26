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

    

   // @Query("SELECT p FROM Producto p WHERE " +
   //        "(:nombre IS NULL OR LOWER(p.nombre_producto) LIKE LOWER(CONCAT('%', :nombreP, '%'))) AND " +
   //        "(:categoria IS NULL OR LOWER(p.categoria.nombre) = LOWER(:categoria)) AND " +
   //        "(:stock IS NULL OR p.stock < :stock)")
   // List<Producto> buscarConFiltros(@Param("nombre") String nombreP,
   //                                 @Param("categoria") String categoria,
   //                                 @Param("stock") Integer stock);





    // LISTAR PRODUCTOS POR MARCA
    List<Producto> findByMarcaPNombreMarcaContainingIgnoreCase(String nombreMarca);

    // LISTAR PRODUCTOS POR CATEGORIA
    List<Producto> findByCategoriaPNombreCategoriaContainingIgnoreCase(String nombreMarca);




    @Query("""
        SELECT p FROM Producto p
        LEFT JOIN p.sucursalStock ss
        WHERE (:nombre IS NULL OR LOWER(p.nombreProducto) LIKE LOWER(CONCAT('%', :nombre, '%')))
        AND (:codigoP IS NULL OR LOWER(p.codigoProducto) LIKE LOWER(CONCAT('%', :codigoP, '%')))
        AND (:categoria IS NULL OR LOWER(p.categoriaP.nombreCategoria) = LOWER(:categoria))
        AND (:marca IS NULL OR LOWER(p.marcaP.nombreMarca) = LOWER(:marca))
        AND (:stock IS NULL OR (
            SELECT SUM(s.cStock) FROM SucursalStockP s WHERE s.producto = p
        ) < :stock)
    """)
    List<Producto> buscarPorFiltros(
        @Param("nombre") String nombre,
        @Param("codigoP") String codigoP,
        @Param("categoria") String categoria,
        @Param("marca") String marca,
        @Param("stock") Integer stock
    );







}
