package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Empleado;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Long>{
    

    // Encontrar los empleados con el nombre de sucursal
    List<Empleado> findBySucursalEmpleadoNombreSucursalContainingIgnoreCase(String nombreSucursal);

    // Encontrar empleados con id sucursal
    List<Empleado> findBySucursalEmpleadoIdSucursal(Long idSucursal);

    // ENcontrar con sucursal id y nombre de rol
    List<Empleado> findBySucursalEmpleadoIdSucursalAndRolEmpleadoDescripcionRol(Long idSucursal, String descripcionRol);
    
}
