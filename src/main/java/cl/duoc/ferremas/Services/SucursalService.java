package cl.duoc.ferremas.Services;

import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.ModelsDTO.SucursalRDTO;
import cl.duoc.ferremas.Models.SucursalStockP;
import cl.duoc.ferremas.Repository.SucursalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    public SucursalService(SucursalRepository sucursalRepository){
        this.sucursalRepository = sucursalRepository;
    }

    // Listar todos
    public List<Sucursal> listarSucursales(){
        return sucursalRepository.findAll();
    }

    // Buscar por ID
    public Optional<Sucursal> buscarPorId(Long id){
        return sucursalRepository.findById(id);
    }

    //Usar para actualizar
    public Sucursal guardarSucursal(Sucursal sucursad){
        return sucursalRepository.save(sucursad);
    }

    //Usar para registrar 
    public Sucursal regisrarSucursal(SucursalRDTO sucursad){
        return sucursalRepository.save(new Sucursal(sucursad.getNombreSucursal(),sucursad.getDireccionSucursal(),LocalDate.now(),LocalTime.now()));
    }

    // Eliminar
    public void eliminarSucursal(Long id){
        sucursalRepository.deleteById(id);
    }

    // Obtener empleados de una sucursal
    public List<Empleado> obtenerEmpleados(Long idSucursal) {
        return sucursalRepository.findById(idSucursal)
                .map(Sucursal::getEmpleados)
                .orElse(Collections.emptyList());
    }

    // Obtener stock de productos
    public List<SucursalStockP> obtenerStock(Long idSucursal) {
        return sucursalRepository.findById(idSucursal)
                .map(Sucursal::getStockProductos)
                .orElse(Collections.emptyList());
    }

}
