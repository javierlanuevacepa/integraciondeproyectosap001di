package cl.duoc.ferremas.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "nombre_marca", nullable = false, unique = true)
    private String nombreMarca;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "marcaP", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Producto> productos = new ArrayList<>();

    public Marca() {
    }

    public Marca(Long idMarca, String nombreMarca, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.idMarca = idMarca;
        this.nombreMarca = nombreMarca;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Marca( String nombreMarca, LocalDate fechaRegistro, LocalTime horaRegistro,List<Producto> productos) {
   
        this.nombreMarca = nombreMarca;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.productos = productos;
    }



    public Marca( String nombreMarca) {
        this.nombreMarca = nombreMarca;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdMarca() {
        return this.idMarca;
    }

    public void setIdMarca(Long idMarca) {
        this.idMarca = idMarca;
    }

    public String getnombreMarca() {
        return this.nombreMarca;
    }

    public void setnombreMarca(String nombreMarca) {
        this.nombreMarca = nombreMarca;
    }

    public List<Producto> getProductos(){
        return this.productos;
    }

    public void setProductos(List<Producto> x){
        this.productos = x;
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

    public Marca idMarca(Long idMarca) {
        setIdMarca(idMarca);
        return this;
    }

    public Marca nombreMarca(String nombreMarca) {
        setnombreMarca(nombreMarca);
        return this;
    }

    public Marca fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Marca horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " idMarca='" + getIdMarca() + "'" +
            ", nombreMarca='" + getnombreMarca() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            "}";
    }
    

}
