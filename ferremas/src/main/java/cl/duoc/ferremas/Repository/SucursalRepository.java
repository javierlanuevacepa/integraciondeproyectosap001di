package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Sucursal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface SucursalRepository extends JpaRepository<Sucursal,Long>{

    //Buscar por sucursal
    Sucursal findBynombreSucursalContainingIgnoreCase(String nombreSucursal);

    
   


}
