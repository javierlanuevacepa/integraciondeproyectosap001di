package cl.duoc.ferremas.Services;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Usuario;
import cl.duoc.ferremas.Models.ModelsDTO.UsuarioRDTO;
import jakarta.persistence.EntityNotFoundException;
import cl.duoc.ferremas.Repository.UsuarioMensajeRepository;
import cl.duoc.ferremas.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    

    private final UsuarioRepository usuarioRepository;

    private final UsuarioMensajeRepository usuarioMensajeRepository;


    public UsuarioService(UsuarioRepository usuarioRepository,UsuarioMensajeRepository usuarioMensajeRepository){
        this.usuarioRepository = usuarioRepository;
        this.usuarioMensajeRepository = usuarioMensajeRepository;
    }


    public Usuario registrarUsuario(Usuario user){
        return usuarioRepository.save(user);
    }

    public List<Usuario> listarTodosLosUsuarios(){
        return usuarioRepository.findAll();
    }

    public void eliminarUsuarioConCorreo(String correo){
        usuarioRepository.delete(usuarioRepository.findByCorreoUsuario(correo)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con correo electronico: " + correo + " no encontrado.")));
    }

    public Usuario actualizarUsuario(Long id,UsuarioRDTO userDTO){
        Usuario user = usuarioRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Usuario con id: " + id + " no encontrado."));

        if (userDTO.getCorreoElectronico()!=null){
            if (!usuarioRepository.findByCorreoUsuario(userDTO.getCorreoElectronico()).isPresent()){
                user.setCorreoUsuario(userDTO.getCorreoElectronico());
            }
        }

        if (userDTO.getContrasena()!=null){
            user.setContrasena(userDTO.getContrasena());
        }
        return usuarioRepository.save(user);
    }




}
