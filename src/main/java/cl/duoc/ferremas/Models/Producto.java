package cl.duoc.ferremas.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;


    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marcaP; 

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoriaP; 

    //Al registrar un nuevo producto voy a diseñar un algoritmo para que se genere un codigo automaticamente
    @Column(name = "codigo_producto", nullable = false, unique = true)
    private String codigoProducto;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private BigDecimal precioP;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<SucursalStockP> sucursalStock = new ArrayList<>();


    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PrecioPHistorial> historialPrecios = new ArrayList<>();


    public Producto() {
    }

    public Producto(Long idProducto, Marca marcaP, Categoria categoriaP, String codigoProducto, String nombreProducto, BigDecimal precioP, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.idProducto = idProducto;
        this.marcaP = marcaP;
        this.categoriaP = categoriaP;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioP = precioP;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Producto( Marca marcaP, Categoria categoriaP, String codigoProducto, String nombreProducto, BigDecimal precioP, LocalDate fechaRegistro, LocalTime horaRegistro,List<SucursalStockP> sucursalStock,List<PrecioPHistorial> historialPrecios) {
        this.marcaP = marcaP;
        this.categoriaP = categoriaP;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioP = precioP;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.sucursalStock = sucursalStock;
        this.historialPrecios = historialPrecios;
    }

    public Producto( Marca marcaP, Categoria categoriaP, String codigoProducto, String nombreProducto, BigDecimal precioP) {
        this.marcaP = marcaP;
        this.categoriaP = categoriaP;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.precioP = precioP;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Producto( Marca marcaP, Categoria categoriaP, String nombreProducto, BigDecimal precioP) {
        this.marcaP = marcaP;
        this.categoriaP = categoriaP;
        this.nombreProducto = nombreProducto;
        this.precioP = precioP;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Marca getMarcaP() {
        return this.marcaP;
    }

    public void setMarcaP(Marca marcaP) {
        this.marcaP = marcaP;
    }

    public List<SucursalStockP> getSucursalStock(){
        return this.sucursalStock;
    }

    public void setSucursalStock(List<SucursalStockP> x){
        this.sucursalStock = x;
    }

    public List<PrecioPHistorial> getHistorialPrecios(){
        return this.historialPrecios;
    }

    public void setPrecioHistorial(List<PrecioPHistorial> x){
        this.historialPrecios = x;
    }

    public Categoria getCategoriaP() {
        return this.categoriaP;
    }

    public void setCategoriaP(Categoria categoriaP) {
        this.categoriaP = categoriaP;
    }

    public String getCodigoProducto() {
        return this.codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return this.nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioP() {
        return this.precioP;
    }

    public void setPrecioP(BigDecimal precioP) {
        this.precioP = precioP;
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

    public Producto idProducto(Long idProducto) {
        setIdProducto(idProducto);
        return this;
    }

    public Producto marcaP(Marca marcaP) {
        setMarcaP(marcaP);
        return this;
    }

    public Producto categoriaP(Categoria categoriaP) {
        setCategoriaP(categoriaP);
        return this;
    }

    public Producto codigoProducto(String codigoProducto) {
        setCodigoProducto(codigoProducto);
        return this;
    }

    public Producto nombreProducto(String nombreProducto) {
        setNombreProducto(nombreProducto);
        return this;
    }

    public Producto precioP(BigDecimal precioP) {
        setPrecioP(precioP);
        return this;
    }

    public Producto fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Producto horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idProducto='" + getIdProducto() + "'" +
            ", marcaP='" + getMarcaP() + "'" +
            ", categoriaP='" + getCategoriaP() + "'" +
            ", codigoProducto='" + getCodigoProducto() + "'" +
            ", nombreProducto='" + getNombreProducto() + "'" +
            ", precioP='" + getPrecioP() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }


    



}
