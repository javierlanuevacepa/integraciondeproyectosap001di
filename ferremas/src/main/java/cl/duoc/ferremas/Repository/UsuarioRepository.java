package cl.duoc.ferremas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.duoc.ferremas.Models.Usuario;
import java.util.List;
import java.util.Optional;





@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    Optional<Usuario> findByCorreoUsuario(String correoUsuario);

}
