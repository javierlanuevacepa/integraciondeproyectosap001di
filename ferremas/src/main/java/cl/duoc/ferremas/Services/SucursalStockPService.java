package cl.duoc.ferremas.Services;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import cl.duoc.ferremas.Models.Producto;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.SucursalStockP;
import cl.duoc.ferremas.Models.PrecioPHistorial;
import cl.duoc.ferremas.Repository.PrecioPHistorialRepository;
import cl.duoc.ferremas.Repository.SucursalStockPRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class SucursalStockPService {

    private final SucursalStockPRepository sucursalStockRepository;

    private final SucursalService sucursalService;

    public SucursalStockPService(SucursalStockPRepository sucursalStockRepository,SucursalService sucursalService){
        this.sucursalStockRepository = sucursalStockRepository;
        this.sucursalService = sucursalService;
    }

    public void registrarSucursalTodasStockP(Producto producto,int cantidadStock){
        sucursalService.listarSucursales().forEach(sucursalS ->{
            sucursalStockRepository.save(new SucursalStockP(producto,sucursalS,cantidadStock));
        });
    }



    public SucursalStockP encontrarStockPconId(Long id){
        return sucursalStockRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Stock de producto no encontrada con ID: " + id));
    }

    public SucursalStockP actualizarStock(Long idPStock,int nuevoStock){
        SucursalStockP sucurP = encontrarStockPconId(idPStock);
        sucurP.setCStock(nuevoStock);
        return sucursalStockRepository.save(sucurP);
    }




}
