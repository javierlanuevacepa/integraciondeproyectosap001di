package cl.duoc.ferremas.Models;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "u_pedido_detalle")
public class UsuarioPDetalle {

    @EmbeddedId
    private UPedidoDetalleId id = new UPedidoDetalleId();

    @ManyToOne
    @JsonBackReference("pedido-detalle")
    @MapsId("idPedido")
    @JoinColumn(name = "id_pedido")
    private UsuarioPedido pedido;
    
    @ManyToOne
    @JsonBackReference("detalle-producto")
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private Integer cantidad;
    private BigDecimal precioUnitario;

    private LocalDate fechaRegistro;
    private LocalTime horaRegistro;



    public UsuarioPDetalle() {
    }

    public UsuarioPDetalle(UPedidoDetalleId id, UsuarioPedido pedido, Producto producto, Integer cantidad, BigDecimal precioUnitario, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.id = id;
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public UsuarioPDetalle( UsuarioPedido pedido, Producto producto, Integer cantidad, BigDecimal precioUnitario) {
        this.pedido = pedido;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public UPedidoDetalleId getId() {
        return this.id;
    }

    public void setId(UPedidoDetalleId id) {
        this.id = id;
    }

    public UsuarioPedido getPedido() {
        return this.pedido;
    }

    public void setPedido(UsuarioPedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public UsuarioPDetalle id(UPedidoDetalleId id) {
        setId(id);
        return this;
    }

    public UsuarioPDetalle pedido(UsuarioPedido pedido) {
        setPedido(pedido);
        return this;
    }

    public UsuarioPDetalle producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public UsuarioPDetalle cantidad(Integer cantidad) {
        setCantidad(cantidad);
        return this;
    }

    public UsuarioPDetalle precioUnitario(BigDecimal precioUnitario) {
        setPrecioUnitario(precioUnitario);
        return this;
    }

    public UsuarioPDetalle fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public UsuarioPDetalle horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", pedido='" + getPedido() + "'" +
            ", producto='" + getProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", precioUnitario='" + getPrecioUnitario() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }








    
}
