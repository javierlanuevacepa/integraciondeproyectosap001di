package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.UsuarioMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;



@Repository
public interface UsuarioMensajeRepository extends JpaRepository<UsuarioMensaje, Long> {

   // Consultas desde el punto de vista del usuario
    List<UsuarioMensaje> findByClienteIdUsuario(Long idUsuario);

    // Consultas desde el punto de vista del vendedor
    List<UsuarioMensaje> findByEmpleadoIdEmpleado(Long idEmpleado);

    // O conversaciones entre ambos
    List<UsuarioMensaje> findByClienteIdUsuarioAndEmpleadoIdEmpleado(Long idUsuario, Long idVendedor);
}
