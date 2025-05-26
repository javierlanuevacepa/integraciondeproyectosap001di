package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Marca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;




@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long>{
    

    Optional<Marca> findByNombreMarcaContainingIgnoreCase(String nombreMarca);

}
