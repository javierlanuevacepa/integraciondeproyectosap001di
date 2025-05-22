package cl.duoc.ferremas.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name = "emp_rol")
public class EmpleadoRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_rol")
    private Long idRol;

    @Column(name = "desc_rol", nullable = false, unique = true)
    private String descripcionRol;


    private LocalDate fechaRegistro;


    private LocalTime horaRegistro; 


    @OneToMany(mappedBy = "emp_rol", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Empleado> empleados = new ArrayList<>();



    public EmpleadoRol() {
    }

    public EmpleadoRol(Long idRol, String descripcionRol, LocalDate fechaRegistro, LocalTime horaRegistro, List<Empleado> empleados) {
        this.idRol = idRol;
        this.descripcionRol = descripcionRol;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.empleados = empleados;
    }

    public EmpleadoRol(String descripcionRol, LocalDate fechaRegistro, LocalTime horaRegistro, List<Empleado> empleados) {

        this.descripcionRol = descripcionRol;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.empleados = empleados;
    }


    public EmpleadoRol(String descripcionRol, LocalDate fechaRegistro, LocalTime horaRegistro) {
        this.descripcionRol = descripcionRol;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
    }

    public Long getIdRol() {
        return this.idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getDescripcionRol() {
        return this.descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
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

    public EmpleadoRol idRol(Long idRol) {
        setIdRol(idRol);
        return this;
    }

    public EmpleadoRol descripcionRol(String descripcionRol) {
        setDescripcionRol(descripcionRol);
        return this;
    }

    public EmpleadoRol fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public EmpleadoRol horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }

    public EmpleadoRol empleados(List<Empleado> empleados) {
        setEmpleados(empleados);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idRol='" + getIdRol() + "'" +
            ", descripcionRol='" + getDescripcionRol() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            ", empleados='" + getEmpleados() + "'" +
            "}";
    }


}
