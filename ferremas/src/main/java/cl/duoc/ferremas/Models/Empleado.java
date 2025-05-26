package cl.duoc.ferremas.Models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Long idEmpleado;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_rol", nullable = false)
    private EmpleadoRol rolEmpleado; 

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "id_sucursal", nullable = false)
    private Sucursal sucursalEmpleado;

    @Column(name = "rut_empleado", nullable = false, unique = true)
    private String rutUsuario;

    @Column(name = "digito_verif", nullable = false)
    private String digitoVerificador;

    @Column(name = "p_nombre", nullable = false)
    private String pNombre;

    @Column(name = "s_nombre", nullable = true)
    private String sNombre;

    @Column(name = "p_apellido", nullable = false)
    private String pApellido;

    @Column(name = "s_apellido", nullable = true)
    private String sApellido;

    @Column(name = "correo_emp", nullable = false, unique = true)
    private String correoEmp;

    @Column(name = "usuario_emp", nullable = false, unique = true)
    private String nombreUsuario;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @Column(name = "hora_registro", nullable = false)
    private LocalTime horaRegistro;

    @OneToMany(mappedBy = "empleado")
    private List<UsuarioMensaje> mensajesRecibidos;

   


    public Empleado() {
    }

    public Empleado(Long idEmpleado, EmpleadoRol rolEmpleado, Sucursal sucursalEmpleado, String rutUsuario, String digitoVerificador, String pNombre, String sNombre, String pApellido, String sApellido, String correoEmp, String nombreUsuario, String contrasena, LocalDate fechaRegistro, LocalTime horaRegistro, List<UsuarioMensaje> mensajesRecibidos) {
        this.idEmpleado = idEmpleado;
        this.rolEmpleado = rolEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
        this.rutUsuario = rutUsuario;
        this.digitoVerificador = digitoVerificador;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.correoEmp = correoEmp;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public Empleado( EmpleadoRol rolEmpleado, Sucursal sucursalEmpleado, String rutUsuario, String digitoVerificador, String pNombre, String sNombre, String pApellido, String sApellido, String correoEmp, String nombreUsuario, String contrasena, LocalDate fechaRegistro, LocalTime horaRegistro, List<UsuarioMensaje> mensajesRecibidos) {
        this.rolEmpleado = rolEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
        this.rutUsuario = rutUsuario;
        this.digitoVerificador = digitoVerificador;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.correoEmp = correoEmp;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = fechaRegistro;
        this.horaRegistro = horaRegistro;
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public Empleado( EmpleadoRol rolEmpleado, Sucursal sucursalEmpleado, String rutUsuario, String digitoVerificador, String pNombre, String sNombre, String pApellido, String sApellido, String correoEmp, String nombreUsuario, String contrasena) {
        this.rolEmpleado = rolEmpleado;
        this.sucursalEmpleado = sucursalEmpleado;
        this.rutUsuario = rutUsuario;
        this.digitoVerificador = digitoVerificador;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.correoEmp = correoEmp;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.fechaRegistro = LocalDate.now();
        this.horaRegistro = LocalTime.now();
    }

    public Long getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public EmpleadoRol getRolEmpleado() {
        return this.rolEmpleado;
    }

    public void setRolEmpleado(EmpleadoRol rolEmpleado) {
        this.rolEmpleado = rolEmpleado;
    }

    public Sucursal getSucursalEmpleado() {
        return this.sucursalEmpleado;
    }

    public void setSucursalEmpleado(Sucursal sucursalEmpleado) {
        this.sucursalEmpleado = sucursalEmpleado;
    }

    public String getRutUsuario() {
        return this.rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getDigitoVerificador() {
        return this.digitoVerificador;
    }

    public void setDigitoVerificador(String digitoVerificador) {
        this.digitoVerificador = digitoVerificador;
    }

    public String getPNombre() {
        return this.pNombre;
    }

    public void setPNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getSNombre() {
        return this.sNombre;
    }

    public void setSNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getPApellido() {
        return this.pApellido;
    }

    public void setPApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getSApellido() {
        return this.sApellido;
    }

    public void setSApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getCorreoEmp() {
        return this.correoEmp;
    }

    public void setCorreoEmp(String correoEmp) {
        this.correoEmp = correoEmp;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
    }

    public String getNombreSucursal(){
        return this.getSucursalEmpleado().getNombreSucursal();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
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

    public String getDescRolEmpleado(){
        return this.rolEmpleado.getDescripcionRol();
    }

    public void setHoraRegistro(LocalTime horaRegistro) {
        this.horaRegistro = horaRegistro;
    }

    public List<UsuarioMensaje> getMensajesRecibidos() {
        return this.mensajesRecibidos;
    }

    public void setMensajesRecibidos(List<UsuarioMensaje> mensajesRecibidos) {
        this.mensajesRecibidos = mensajesRecibidos;
    }

    public Empleado idEmpleado(Long idEmpleado) {
        setIdEmpleado(idEmpleado);
        return this;
    }

    public Empleado rolEmpleado(EmpleadoRol rolEmpleado) {
        setRolEmpleado(rolEmpleado);
        return this;
    }

    public Empleado sucursalEmpleado(Sucursal sucursalEmpleado) {
        setSucursalEmpleado(sucursalEmpleado);
        return this;
    }

    public Empleado rutUsuario(String rutUsuario) {
        setRutUsuario(rutUsuario);
        return this;
    }

    public Empleado digitoVerificador(String digitoVerificador) {
        setDigitoVerificador(digitoVerificador);
        return this;
    }

    public Empleado pNombre(String pNombre) {
        setPNombre(pNombre);
        return this;
    }

    public Empleado sNombre(String sNombre) {
        setSNombre(sNombre);
        return this;
    }

    public Empleado pApellido(String pApellido) {
        setPApellido(pApellido);
        return this;
    }

    public Empleado sApellido(String sApellido) {
        setSApellido(sApellido);
        return this;
    }

    public Empleado correoEmp(String correoEmp) {
        setCorreoEmp(correoEmp);
        return this;
    }

    public Empleado nombreUsuario(String nombreUsuario) {
        setNombreUsuario(nombreUsuario);
        return this;
    }

    public Empleado contrasena(String contrasena) {
        setContrasena(contrasena);
        return this;
    }

    public Empleado fechaRegistro(LocalDate fechaRegistro) {
        setFechaRegistro(fechaRegistro);
        return this;
    }

    public Empleado horaRegistro(LocalTime horaRegistro) {
        setHoraRegistro(horaRegistro);
        return this;
    }

    public Empleado mensajesRecibidos(List<UsuarioMensaje> mensajesRecibidos) {
        setMensajesRecibidos(mensajesRecibidos);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idEmpleado='" + getIdEmpleado() + "'" +
            ", rolEmpleado='" + getRolEmpleado() + "'" +
            ", sucursalEmpleado='" + getSucursalEmpleado() + "'" +
            ", rutUsuario='" + getRutUsuario() + "'" +
            ", digitoVerificador='" + getDigitoVerificador() + "'" +
            ", pNombre='" + getPNombre() + "'" +
            ", sNombre='" + getSNombre() + "'" +
            ", pApellido='" + getPApellido() + "'" +
            ", sApellido='" + getSApellido() + "'" +
            ", correoEmp='" + getCorreoEmp() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", contrasena='" + getContrasena() + "'" +
            ", fechaRegistro='" + getFechaRegistro() + "'" +
            ", horaRegistro='" + getHoraRegistro() + "'" +
            ", mensajesRecibidos='" + getMensajesRecibidos() + "'" +
            "}";
    }

    
}
