package cl.duoc.ferremas.Models.ModelsDTO;


public class EmpleadoRDTO {
    
    private Long idRolEmpleado;

    private Long idSucursal;

    private String rutUsuario;
    
    private String codigoVerificador;

    private String pNombre;

    private String sNombre;

    private String pApellido;

    private String sApellido;

    private String correoEmpleado;

    private String nombreUsuario;

    private String contrasena;


    public EmpleadoRDTO() {
    }

    public EmpleadoRDTO(Long idRolEmpleado, Long idSucursal, String rutUsuario, String codigoVerificador, String pNombre, String sNombre, String pApellido, String sApellido, String correoEmpleado, String nombreUsuario, String contrasena) {
        this.idRolEmpleado = idRolEmpleado;
        this.idSucursal = idSucursal;
        this.rutUsuario = rutUsuario;
        this.codigoVerificador = codigoVerificador;
        this.pNombre = pNombre;
        this.sNombre = sNombre;
        this.pApellido = pApellido;
        this.sApellido = sApellido;
        this.correoEmpleado = correoEmpleado;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public Long getIdRolEmpleado() {
        return this.idRolEmpleado;
    }

    public void setIdRolEmpleado(Long idRolEmpleado) {
        this.idRolEmpleado = idRolEmpleado;
    }

    public Long getIdSucursal() {
        return this.idSucursal;
    }

    public void setIdSucursal(Long idSucursal) {
        this.idSucursal = idSucursal;
    }

    public String getRutUsuario() {
        return this.rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    public String getCodigoVerificador() {
        return this.codigoVerificador;
    }

    public void setCodigoVerificador(String codigoVerificador) {
        this.codigoVerificador = codigoVerificador;
    }

    public String getpNombre() {
        return this.pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return this.sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getpApellido() {
        return this.pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return this.sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public String getCorreoEmpleado() {
        return this.correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public String getNombreUsuario() {
        return this.nombreUsuario;
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

    public EmpleadoRDTO idRolEmpleado(Long idRolEmpleado) {
        setIdRolEmpleado(idRolEmpleado);
        return this;
    }

    public EmpleadoRDTO idSucursal(Long idSucursal) {
        setIdSucursal(idSucursal);
        return this;
    }

    public EmpleadoRDTO rutUsuario(String rutUsuario) {
        setRutUsuario(rutUsuario);
        return this;
    }

    public EmpleadoRDTO codigoVerificador(String codigoVerificador) {
        setCodigoVerificador(codigoVerificador);
        return this;
    }

    public EmpleadoRDTO pNombre(String pNombre) {
        setpNombre(pNombre);
        return this;
    }

    public EmpleadoRDTO sNombre(String sNombre) {
        setsNombre(sNombre);
        return this;
    }

    public EmpleadoRDTO pApellido(String pApellido) {
        setpApellido(pApellido);
        return this;
    }

    public EmpleadoRDTO sApellido(String sApellido) {
        setsApellido(sApellido);
        return this;
    }

    public EmpleadoRDTO correoEmpleado(String correoEmpleado) {
        setCorreoEmpleado(correoEmpleado);
        return this;
    }

    public EmpleadoRDTO nombreUsuario(String nombreUsuario) {
        setNombreUsuario(nombreUsuario);
        return this;
    }

    public EmpleadoRDTO contrasena(String contrasena) {
        setContrasena(contrasena);
        return this;
    }



    @Override
    public String toString() {
        return "{" +
            " idRolEmpleado='" + getIdRolEmpleado() + "'" +
            ", idSucursal='" + getIdSucursal() + "'" +
            ", rutUsuario='" + getRutUsuario() + "'" +
            ", codigoVerificador='" + getCodigoVerificador() + "'" +
            ", pNombre='" + getpNombre() + "'" +
            ", sNombre='" + getsNombre() + "'" +
            ", pApellido='" + getpApellido() + "'" +
            ", sApellido='" + getsApellido() + "'" +
            ", correoEmpleado='" + getCorreoEmpleado() + "'" +
            ", nombreUsuario='" + getNombreUsuario() + "'" +
            ", contrasena='" + getContrasena() + "'" +
            "}";
    }
    

}
