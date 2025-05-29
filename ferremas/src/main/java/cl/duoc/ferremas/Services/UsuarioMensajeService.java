package cl.duoc.ferremas.Services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Usuario;
import cl.duoc.ferremas.Models.UsuarioMensaje;
import cl.duoc.ferremas.Models.ModelsDTO.UsuarioRDTO;
import jakarta.persistence.EntityNotFoundException;
import cl.duoc.ferremas.Repository.EmpleadoRepository;
import cl.duoc.ferremas.Repository.UsuarioMensajeRepository;
import cl.duoc.ferremas.Repository.UsuarioRepository;

@Service
public class UsuarioMensajeService {

    private final UsuarioRepository usuarioRepository;
    private final EmpleadoRepository empleadoRepository;
    private final UsuarioMensajeRepository mensajeRepository;

    public UsuarioMensajeService(UsuarioRepository usuarioRepository,
                          EmpleadoRepository empleadoRepository,
                          UsuarioMensajeRepository mensajeRepository) {
        this.usuarioRepository = usuarioRepository;
        this.empleadoRepository = empleadoRepository;
        this.mensajeRepository = mensajeRepository;
    }

    
    public UsuarioMensaje enviarMensaje(Long idUsuario, Long idSucursal, String contenido) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

       
        List<Empleado> anteriores = mensajeRepository.findEmpleadosConQuienUsuarioHaHablado(idUsuario);
        Empleado empleado;

        if (!anteriores.isEmpty()) {
            empleado = anteriores.get(0); // si hay más de uno, tomamos el primero
        } else {
            
            List<Empleado> disponibles = empleadoRepository.findBySucursalEmpleadoIdSucursalAndRolEmpleadoDescripcionRol(idSucursal, "Vendedor/Encargado");
            if (disponibles.isEmpty()) {
                throw new RuntimeException("No hay vendedores en la sucursal");
            }
            empleado = disponibles.get(0); // lógica de asignación básica
        }

        return mensajeRepository.save(new UsuarioMensaje(usuario,empleado,contenido));
    }

    
}
