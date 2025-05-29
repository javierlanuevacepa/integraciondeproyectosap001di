package cl.duoc.ferremas.Models.ModelsDTO;

import java.util.List;
import java.util.Objects;

public class UsuarioPedidoDTO {
    private Long idCliente; // solo el ID
    
    private List<UsuarioPDetalleDTO> detalles;


    public UsuarioPedidoDTO() {
    }

    public UsuarioPedidoDTO(Long idCliente, List<UsuarioPDetalleDTO> detalles) {
        this.idCliente = idCliente;
        this.detalles = detalles;
    }

    public Long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public List<UsuarioPDetalleDTO> getDetalles() {
        return this.detalles;
    }

    public void setDetalles(List<UsuarioPDetalleDTO> detalles) {
        this.detalles = detalles;
    }

    public UsuarioPedidoDTO idCliente(Long idCliente) {
        setIdCliente(idCliente);
        return this;
    }

    public UsuarioPedidoDTO detalles(List<UsuarioPDetalleDTO> detalles) {
        setDetalles(detalles);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioPedidoDTO)) {
            return false;
        }
        UsuarioPedidoDTO usuarioPedidoDTO = (UsuarioPedidoDTO) o;
        return Objects.equals(idCliente, usuarioPedidoDTO.idCliente) && Objects.equals(detalles, usuarioPedidoDTO.detalles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, detalles);
    }

    @Override
    public String toString() {
        return "{" +
            " idCliente='" + getIdCliente() + "'" +
            ", detalles='" + getDetalles() + "'" +
            "}";
    }


}