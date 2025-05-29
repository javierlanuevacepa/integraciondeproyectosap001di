package cl.duoc.ferremas.Controllers;

import org.springframework.web.bind.annotation.RestController;

import cl.duoc.ferremas.Models.UsuarioMensaje;
import cl.duoc.ferremas.Services.UsuarioMensajeService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v0/mensajes")
public class UsuarioMensajesController {
    
    private final UsuarioMensajeService usuarioMensajeService;

    public UsuarioMensajesController(UsuarioMensajeService usuarioMensajeService){
        this.usuarioMensajeService = usuarioMensajeService;
    }


     // Enviar mensaje
    @PostMapping("/enviar")
    public ResponseEntity<UsuarioMensaje> enviarMensaje(
            @RequestParam Long idUsuario,
            @RequestParam Long idSucursal,
            @RequestBody String contenido) {
        try {

  
            UsuarioMensaje nuevoMensaje = usuarioMensajeService.enviarMensaje(idUsuario, idSucursal, contenido);
            return ResponseEntity.ok(nuevoMensaje);

        } catch (RuntimeException e) {
            System.out.println("ERROOOOOR:"+e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }




}
