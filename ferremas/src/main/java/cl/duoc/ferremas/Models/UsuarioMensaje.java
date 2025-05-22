package cl.duoc.ferremas.Models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.*;


@Entity
@Table(name = "usuario_mensaje")
public class UsuarioMensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensaje")
    private Long idMensaje;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario cliente;

    @ManyToOne
    @JoinColumn(name = "id_vendedor", nullable = false)
    private Empleado vendedor;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;



    public UsuarioMensaje() {
    }

    public UsuarioMensaje(Long idMensaje, Usuario cliente, Empleado vendedor, String contenido, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.idMensaje = idMensaje;
        this.cliente = cliente;
        this.vendedor = vendedor;
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

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Empleado getVendedor() {
        return this.vendedor;
    }

    public void setVendedor(Empleado vendedor) {
        this.vendedor = vendedor;
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

    public UsuarioMensaje vendedor(Empleado vendedor) {
        setVendedor(vendedor);
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
            ", vendedor='" + getVendedor() + "'" +
            ", contenido='" + getContenido() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }

    


}
