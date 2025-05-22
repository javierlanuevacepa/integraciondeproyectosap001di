package cl.duoc.ferremas.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "sucursal")
public class Sucursal {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_sucursal")
    private Long idSucursal;

    private String nombreSucursal;

    private String direccionSucursal;

    private LocalDate fechaRegistro;

    private LocalTime horaRegistro;


    // 🚹 Relación con empleados
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados = new ArrayList<>();

    // 📦 Relación con productos en stock
    @OneToMany(mappedBy = "sucursal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SucursalStockP> stockProductos = new ArrayList<>();




    public Sucursal() {
    }

    public Sucursal(Long idSucursal, String nombreSucursal, String direccionSucursal, LocalDate fechaRegistro, LocalTime horaRegistro, List<Empleado> empleados, List<SucursalStockP> stockProductos) {
        this.idSucursal = idSucursal;
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.empleados = empleados;
        this.stockProductos = stockProductos;
    }

    public Sucursal( String nombreSucursal, String direccionSucursal, LocalDate fechaRegistro, LocalTime horaRegistro, List<Empleado> empleados, List<SucursalStockP> stockProductos) {

        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.empleados = empleados;
        this.stockProductos = stockProductos;
    }

    public Sucursal( String nombreSucursal, String direccionSucursal, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;

    }

    public Long getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getNombreSucursal() {
        return this.nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getDireccionSucursal() {
        return this.direccionSucursal;
    }

    public void setDireccionSucursal(String direccionSucursal) {
        this.direccionSucursal = direccionSucursal;
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

    public List<Empleado> getEmpleados() {
        return this.empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public List<SucursalStockP> getStockProductos() {
        return this.stockProductos;
    }

    public void setStockProductos(List<SucursalStockP> stockProductos) {
        this.stockProductos = stockProductos;
    }

    public Sucursal idSucursal(Long idSucursal) {
        setIdSucursal(idSucursal);
        return this;
    }

    public Sucursal nombreSucursal(String nombreSucursal) {
        setNombreSucursal(nombreSucursal);
        return this;
    }

    public Sucursal direccionSucursal(String direccionSucursal) {
        setDireccionSucursal(direccionSucursal);
        return this;
    }

    public Sucursal fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Sucursal horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }

    public Sucursal empleados(List<Empleado> empleados) {
        setEmpleados(empleados);
        return this;
    }

    public Sucursal stockProductos(List<SucursalStockP> stockProductos) {
        setStockProductos(stockProductos);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idSucursal='" + getIdSucursal() + "'" +
            ", nombreSucursal='" + getNombreSucursal() + "'" +
            ", direccionSucursal='" + getDireccionSucursal() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            ", empleados='" + getEmpleados() + "'" +
            ", stockProductos='" + getStockProductos() + "'" +
            "}";
    }


}
