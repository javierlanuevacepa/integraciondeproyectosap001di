package cl.duoc.ferremas.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario_mensaje")
public class UsuarioMensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Long idMensaje;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_empleado", nullable = false)
    private Empleado empleado;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;



    public UsuarioMensaje() {
    }

    public UsuarioMensaje(Long idMensaje, Usuario cliente, Empleado empleado, String contenido, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.idMensaje = idMensaje;
        this.cliente = cliente;
        this.empleado = empleado;
        this.contenido = contenido;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Long getIdMensaje() {
        return this.idMensaje;
    }

    public void setIdMensaje(Long idMensaje) {
        this.idMensaje = idMensaje;
    }

    public Usuario getCliente() {
        return this.cliente;
    }

    public Long getIdVendedor(){
        return this.empleado.getIdEmpleado();
    }

    public Long getIdUsuario(){
        return this.cliente.getIdUsuario();
    }


    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Empleado getempleado() {
        return this.empleado;
    }

    public void setempleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    public UsuarioMensaje idMensaje(Long idMensaje) {
        setIdMensaje(idMensaje);
        return this;
    }

    public UsuarioMensaje cliente(Usuario cliente) {
        setCliente(cliente);
        return this;
    }

    public UsuarioMensaje empleado(Empleado empleado) {
        setempleado(empleado);
        return this;
    }

    public UsuarioMensaje contenido(String contenido) {
        setContenido(contenido);
        return this;
    }

    public UsuarioMensaje fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public UsuarioMensaje horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idMensaje='" + getIdMensaje() + "'" +
            ", cliente='" + getCliente() + "'" +
            ", empleado='" + getempleado() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }

    


}
