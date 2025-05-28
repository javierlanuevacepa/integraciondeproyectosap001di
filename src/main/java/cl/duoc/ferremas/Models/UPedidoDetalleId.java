package cl.duoc.ferremas.Models;
import java.io.Serializable;
import jakarta.persistence.*;




@Embeddable
public class UPedidoDetalleId implements Serializable{
    private Long idPedido;
    private Long idProducto;


    public UPedidoDetalleId() {
    }

    public UPedidoDetalleId(Long idPedido, Long idProducto) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;
    }

    public Long getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }


}
