package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.UsuarioMensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


public interface UsuarioMensajeRepository extends JpaRepository<UsuarioMensaje, Long> {
    // Buscar todos los mensajes recibidos por un vendedor
    List<UsuarioMensaje> findByVendedorIdEmp(Long idVendedor);

    // Buscar todos los mensajes enviados por un cliente
    List<UsuarioMensaje> findByClienteIdUsuario(Long idCliente);
}
