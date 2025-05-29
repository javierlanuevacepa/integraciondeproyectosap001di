package cl.duoc.ferremas.Models;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuario_pedido")
public class UsuarioPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long idPedido;


    @ManyToOne
    @JsonBackReference("usuario-pedido")
    @JoinColumn(name = "id_cliente", nullable = false)
    private Usuario clientePedido;


    @Column(name = "estado", nullable = false)
    private String estadoPedido; // PENDIENTE , ACEPTADO, RECHAZADO

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonManagedReference("pedido-detalle")
    private List<UsuarioPDetalle> detalles = new ArrayList<>();

  

    public UsuarioPedido() {
    }

    public UsuarioPedido(Long idPedido, String estadoPedido, LocalDate fechaRegistro, LocalTime horaRegistro, List<UsuarioPDetalle> detalles) {
        this.idPedido = idPedido;
        this.estadoPedido = estadoPedido;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.detalles = detalles;
    }

    public UsuarioPedido( Usuario clientePedido, List<UsuarioPDetalle> detalles) {
        this.clientePedido = clientePedido;
        this.estadoPedido = "PENDIENTE";
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
        this.detalles = detalles;
    }

    public Long getIdPedido() {
        return this.idPedido;
    }



    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getClientePedido(){
        return this.clientePedido;
    }

    public void setClientePedido(Usuario usuario){
        this.clientePedido = usuario;
    }

    public String getEstadoPedido() {
        return this.estadoPedido;
    }

    public void setEstadoPedido(String estadoPedido) {
        this.estadoPedido = estadoPedido;
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

    public List<UsuarioPDetalle> getDetalles() {
        return this.detalles;
    }

    public void setDetalles(List<UsuarioPDetalle> detalles) {
        this.detalles = detalles;
    }

    public UsuarioPedido idPedido(Long idPedido) {
        setIdPedido(idPedido);
        return this;
    }

    public UsuarioPedido estadoPedido(String estadoPedido) {
        setEstadoPedido(estadoPedido);
        return this;
    }

    public UsuarioPedido fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public UsuarioPedido horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }

    public UsuarioPedido detalles(List<UsuarioPDetalle> detalles) {
        setDetalles(detalles);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idPedido='" + getIdPedido() + "'" +
            ", estadoPedido='" + getEstadoPedido() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            ", detalles='" + getDetalles() + "'" +
            "}";
    }





    
}
