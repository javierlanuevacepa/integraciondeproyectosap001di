package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.UsuarioMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;



@Repository
public interface UsuarioMensajeRepository extends JpaRepository<UsuarioMensaje, Long> {

   // Consultas desde el punto de vista del usuario
    List<UsuarioMensaje> findByClienteIdUsuario(Long idUsuario);

    // Consultas desde el punto de vista del vendedor
    List<UsuarioMensaje> findByEmpleadoIdEmpleado(Long idEmpleado);

    // O conversaciones entre ambos
    List<UsuarioMensaje> findByClienteIdUsuarioAndEmpleadoIdEmpleado(Long idUsuario, Long idVendedor);

    // Busca si el usuario ya ha mensajeado a un empleado específico
    @Query("SELECT um.empleado FROM UsuarioMensaje um WHERE um.cliente.idUsuario = :idUsuario GROUP BY um.empleado")
    List<Empleado> findEmpleadosConQuienUsuarioHaHablado(@Param("idUsuario") Long idUsuario);


    
}
