package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.EmpleadoRol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface EmpleadoRolRepository extends JpaRepository<EmpleadoRol,Long>{
    
    
    
    EmpleadoRol findByDescripcionRol(String descripcionRol);
}
