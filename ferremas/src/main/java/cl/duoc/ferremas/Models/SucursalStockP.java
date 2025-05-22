package cl.duoc.ferremas.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "sucursal_stock_p")
public class SucursalStockP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursal;

    private Integer cStock;
    private LocalDate fechaRegistro;
    private LocalTime horaRegistro;




    public SucursalStockP() {
    }

    public SucursalStockP(Long id, Producto producto, Sucursal sucursal, Integer cStock, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.id = id;
        this.producto = producto;
        this.sucursal = sucursal;
        this.cStock = cStock;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public SucursalStockP( Producto producto, Sucursal sucursal, Integer cStock, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.producto = producto;
        this.sucursal = sucursal;
        this.cStock = cStock;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Sucursal getSucursal() {
        return this.sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Integer getCStock() {
        return this.cStock;
    }

    public void setCStock(Integer cStock) {
        this.cStock = cStock;
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

    public SucursalStockP id(Long id) {
        setId(id);
        return this;
    }

    public SucursalStockP producto(Producto producto) {
        setProducto(producto);
        return this;
    }

    public SucursalStockP sucursal(Sucursal sucursal) {
        setSucursal(sucursal);
        return this;
    }

    public SucursalStockP cStock(Integer cStock) {
        setCStock(cStock);
        return this;
    }

    public SucursalStockP fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public SucursalStockP horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", producto='" + getProducto() + "'" +
            ", sucursal='" + getSucursal() + "'" +
            ", cStock='" + getCStock() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }

    


}
