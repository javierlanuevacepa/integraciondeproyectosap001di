package cl.duoc.ferremas.Models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;


    @Column(name = "correo_usuario", nullable = false, unique = true)
    private String correoUsuario;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "cliente")
    @JsonManagedReference
    private List<UsuarioMensaje> mensajesEnviados;

    

    public Usuario() {
    }

    public Usuario(Long idUsuario, String correoUsuario, String contrasena, LocalDate fechaRegistro, LocalTime horaRegistro, List<UsuarioMensaje> mensajesEnviados) {
        this.idUsuario = idUsuario;
        this.correoUsuario = correoUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.mensajesEnviados = mensajesEnviados;
    }

    public Usuario( String correoUsuario, String contrasena, LocalDate fechaRegistro, LocalTime horaRegistro, List<UsuarioMensaje> mensajesEnviados) {
        this.correoUsuario = correoUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.mensajesEnviados = mensajesEnviados;
    }

    public Usuario( String correoUsuario, String contrasena) {
        this.correoUsuario = correoUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdUsuario() {
        return this.idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreoUsuario() {
        return this.correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public LocalTime getHoraRegistro() {
        return this.horaRegistro;
    }

    public void setHoraRegistro(LocalTime horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public List<UsuarioMensaje> getMensajesEnviados() {
        return this.mensajesEnviados;
    }

    public void setMensajesEnviados(List<UsuarioMensaje> mensajesEnviados) {
        this.mensajesEnviados = mensajesEnviados;
    }

    public Usuario idUsuario(Long idUsuario) {
        setIdUsuario(idUsuario);
        return this;
    }

    public Usuario correoUsuario(String correoUsuario) {
        setCorreoUsuario(correoUsuario);
        return this;
    }

    public Usuario contrasena(String contrasena) {
        setContrasena(contrasena);
        return this;
    }

    public Usuario fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Usuario horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }

    public Usuario mensajesEnviados(List<UsuarioMensaje> mensajesEnviados) {
        setMensajesEnviados(mensajesEnviados);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idUsuario='" + getIdUsuario() + "'" +
            ", correoUsuario='" + getCorreoUsuario() + "'" +
            ", contrasena='" + getContrasena() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            ", mensajesEnviados='" + getMensajesEnviados() + "'" +
            "}";
    }


}
