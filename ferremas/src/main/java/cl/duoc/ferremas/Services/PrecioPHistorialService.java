package cl.duoc.ferremas.Services;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Producto;
import cl.duoc.ferremas.Models.PrecioPHistorial;
import cl.duoc.ferremas.Repository.PrecioPHistorialRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PrecioPHistorialService {
    

    private final PrecioPHistorialRepository precioPHistorialRepository;

    public PrecioPHistorialService(PrecioPHistorialRepository precioPHistorialRepository){
        this.precioPHistorialRepository = precioPHistorialRepository;
    }

    public void registrarHistorialPrecioP(Producto producto){
        this.precioPHistorialRepository.save(new PrecioPHistorial(producto,producto.getPrecioP()));
    }

    public PrecioPHistorial encontrarPHistorialPorId(Long id){
        return this.precioPHistorialRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Historial de precio con id " + id + " no encontrado."));
    }

    public PrecioPHistorial encontrarPHistorialMasRecientePorProductoId(Long idProducto){
        return this.precioPHistorialRepository.findTopByProductoIdProductoOrderByFechaRegistroDescHoraRegistroDesc(idProducto);
    }
}
