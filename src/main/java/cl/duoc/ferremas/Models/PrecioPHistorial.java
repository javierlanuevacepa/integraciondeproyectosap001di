package cl.duoc.ferremas.Models;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name = "precio_p_historial")
public class PrecioPHistorial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHistorial; // necesitas una PK si vas a manejar historial fácilmente

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    private BigDecimal precioP;

    private LocalDate fechaRegistro;
    private LocalTime horaRegistro;


    @Column(name = "fecha_fin", nullable = true)
    private LocalDate fechaFin;

    @Column(name = "hora_fin", nullable = true)
    private LocalTime horaFin;
    



    public PrecioPHistorial() {
    }

    public PrecioPHistorial(Long idHistorial, Producto producto, BigDecimal precioP, LocalDate fechaFin, LocalTime horaFin) {
        this.idHistorial = idHistorial;
        this.producto = producto;
        this.precioP = precioP;

        this.fechaFin = fechaFin;
        this.horaFin = horaFin;
    }

    public PrecioPHistorial( Producto producto, BigDecimal precioP) {
        this.producto = producto;
        this.precioP = precioP;

        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdHistorial() {
        return this.idHistorial;
    }

    public void setIdHistorial(Long idHistorial) {
        this.idHistorial = idHistorial;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public BigDecimal getPrecioP() {
        return this.precioP;
    }

    public void setPrecioP(BigDecimal precioP) {
        this.precioP = precioP;
    }

    public void finalizarPrecio(){
        setFechaFin(LocalDate.now());
        setHoraFin(LocalTime.now());
    }

    public LocalDate getFechaRegistro(){
        return this.fechaRegistro;
    }

    public LocalTime getHoraRegistro(){
        return this.horaRegistro;
    }

    public LocalDate getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalTime getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public PrecioPHistorial idHistorial(Long idHistorial) {
        setIdHistorial(idHistorial);
        return this;
    }

    public PrecioPHistorial producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public PrecioPHistorial precioP(BigDecimal precioP) {
        setPrecioP(precioP);
        return this;
    }


    public PrecioPHistorial fechaFin(LocalDate fechaFin) {
        setFechaFin(fechaFin);
        return this;
    }

    public PrecioPHistorial horaFin(LocalTime horaFin) {
        setHoraFin(horaFin);
        return this;
    }

 
    @Override
    public String toString() {
        return "{" +
            " idHistorial='" + getIdHistorial() + "'" +
            ", producto='" + getProducto() + "'" +
            ", precioP='" + getPrecioP() + "'" +
            ", fechaFin='" + getFechaFin() + "'" +
            ", horaFin='" + getHoraFin() + "'" +
            "}";
    }
    



    
}
