package cl.duoc.ferremas.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.duoc.ferremas.Services.SucursalService;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.ModelsDTO.SucursalRDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/v0/sucursal")
public class SucursalController {
    

    private final SucursalService sucursalService;

    public SucursalController(SucursalService sucursalService){
        this.sucursalService = sucursalService;
    }

    @GetMapping("")
    public List<Sucursal> retornarSucursales(){
        return sucursalService.listarSucursales();
    }

    @GetMapping("/{id}")
    public Optional<Sucursal> retornarSucursalconId(@PathVariable Long id){
        return sucursalService.buscarPorId(id);
    }

    @PostMapping
    public void registarSucursal(@RequestBody SucursalRDTO sucursal){
        sucursalService.regisrarSucursal(sucursal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarSucursalSinParametros(@PathVariable Long id, @RequestBody SucursalRDTO sucursalA) {
        Optional<Sucursal> sucursalOpt = sucursalService.buscarPorId(id);
        if (sucursalOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Sucursal sucursal = sucursalOpt.get();
        if (sucursalA.getNombreSucursal()!=null){
            sucursal.setNombreSucursal(sucursalA.getNombreSucursal());
        }
        if (sucursalA.getDireccionSucursal()!=null){
            sucursal.setDireccionSucursal(sucursalA.getDireccionSucursal());
        }
        sucursalService.guardarSucursal(sucursal);
        return ResponseEntity.ok("Sucursal actualizada");
    }



    @PatchMapping("/{id}")
    public ResponseEntity<?> actualizarConParametros(@PathVariable Long id, @RequestBody SucursalRDTO sucursalA) { 
        Optional<Sucursal> sucursalOpt = sucursalService.buscarPorId(id);
        if (sucursalOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Sucursal sucursal = sucursalOpt.get();
        if (sucursalA.getNombreSucursal()!=null){
            sucursal.setNombreSucursal(sucursalA.getNombreSucursal());
        }
        if (sucursalA.getDireccionSucursal()!=null){
            sucursal.setDireccionSucursal(sucursalA.getDireccionSucursal());
        }
        sucursalService.guardarSucursal(sucursal);
        return ResponseEntity.ok("Sucursal actualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarSucursal(@PathVariable Long id) { 
        Optional<Sucursal> sucursalOpt = sucursalService.buscarPorId(id);
        if (sucursalOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
        sucursalService.eliminarSucursal(id);
        return ResponseEntity.ok("Sucursal eliminada correctamente.");
        }
    }





}
