package cl.duoc.ferremas.Models.ModelsDTO;



// ESTA CLASE SERA USADA PARA REGISTRAR UNA SUCURSAL.
public class SucursalRDTO {
    private String nombreSucursal;
    private String direccionSucursal;


    public SucursalRDTO() {
    }

    public SucursalRDTO(String nombreSucursal, String direccionSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.direccionSucursal = direccionSucursal;
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

    public SucursalRDTO nombreSucursal(String nombreSucursal) {
        setNombreSucursal(nombreSucursal);
        return this;
    }

    public SucursalRDTO direccionSucursal(String direccionSucursal) {
        setDireccionSucursal(direccionSucursal);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " nombreSucursal='" + getNombreSucursal() + "'" +
            ", direccionSucursal='" + getDireccionSucursal() + "'" +
            "}";
    }
    
}
