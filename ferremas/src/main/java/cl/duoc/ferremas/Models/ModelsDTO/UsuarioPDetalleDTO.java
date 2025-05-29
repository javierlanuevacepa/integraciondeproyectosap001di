package cl.duoc.ferremas.Models.ModelsDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class UsuarioPDetalleDTO {
    private Long idProducto;
    private Integer cantidad;
    private BigDecimal precioUnitario;




    public UsuarioPDetalleDTO() {
    }

    public UsuarioPDetalleDTO(Long idProducto, Integer cantidad, BigDecimal precioUnitario) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public UsuarioPDetalleDTO idProducto(Long idProducto) {
        setIdProducto(idProducto);
        return this;
    }

    public UsuarioPDetalleDTO cantidad(Integer cantidad) {
        setCantidad(cantidad);
        return this;
    }

    public UsuarioPDetalleDTO precioUnitario(BigDecimal precioUnitario) {
        setPrecioUnitario(precioUnitario);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioPDetalleDTO)) {
            return false;
        }
        UsuarioPDetalleDTO usuarioPDetalleDTO = (UsuarioPDetalleDTO) o;
        return Objects.equals(idProducto, usuarioPDetalleDTO.idProducto) && Objects.equals(cantidad, usuarioPDetalleDTO.cantidad) && Objects.equals(precioUnitario, usuarioPDetalleDTO.precioUnitario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, cantidad, precioUnitario);
    }

    @Override
    public String toString() {
        return "{" +
            " idProducto='" + getIdProducto() + "'" +
            ", cantidad='" + getCantidad() + "'" +
            ", precioUnitario='" + getPrecioUnitario() + "'" +
            "}";
    }

    
}