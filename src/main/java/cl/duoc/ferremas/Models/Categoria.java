package cl.duoc.ferremas.Models;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "categoria")
public class Categoria {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;


    @Column(name = "nombre_categoria", nullable = false, unique = true)
    private String nombreCategoria;

    @Column(name = "desc_categoria", nullable = true)
    private String descripcionCategoria;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "categoriaP", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> productos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long idCategoria, String nombreCategoria, String descripcionCategoria, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Categoria( String nombreCategoria, String descripcionCategoria, LocalDate fechaRegistro, LocalTime horaRegistro,List<Producto> productos) {

        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.productos = productos;
    }

    public Categoria( String nombreCategoria, String descripcionCategoria) {

        this.nombreCategoria = nombreCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdCategoria() {
        return this.idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return this.nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<Producto> getProductos(){
        return this.productos;
    }

    public void setProductos(List<Producto> x){
        this.productos = x;
    }

    public String getDescripcionCategoria() {
        return this.descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
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

    public Categoria idCategoria(Long idCategoria) {
        setIdCategoria(idCategoria);
        return this;
    }

    public Categoria nombreCategoria(String nombreCategoria) {
        setNombreCategoria(nombreCategoria);
        return this;
    }

    public Categoria descripcionCategoria(String descripcionCategoria) {
        setDescripcionCategoria(descripcionCategoria);
        return this;
    }

    public Categoria fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Categoria horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idCategoria='" + getIdCategoria() + "'" +
            ", nombreCategoria='" + getNombreCategoria() + "'" +
            ", descripcionCategoria='" + getDescripcionCategoria() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }
    



}
