package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.UsuarioPDetalle;

import cl.duoc.ferremas.Models.UPedidoDetalleId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;




@Repository
public interface UsuarioPDetalleRepository extends JpaRepository<UsuarioPDetalle,UPedidoDetalleId>{
     
}
