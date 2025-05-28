package cl.duoc.ferremas.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import cl.duoc.ferremas.Services.EmpleadoService;
import cl.duoc.ferremas.Services.SucursalService;
import jakarta.validation.Valid;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.ModelsDTO.EmpleadoRDTO;
import cl.duoc.ferremas.Models.Empleado;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.net.URI;
import java.util.List;
import java.util.Optional;




@RestController
@RequestMapping("/v0/empleado")
public class EmpleadoController {
    
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }


    @GetMapping("")
    public List<Empleado> getEmpleados(){
        return this.empleadoService.listarEmpleados();
    }


    @PostMapping("")
    public ResponseEntity<Empleado> registrarEmpleado(@Valid @RequestBody EmpleadoRDTO empleadoR) {
        Empleado employe =  empleadoService.registrarEmpleado(empleadoR);

        URI location = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(employe.getIdEmpleado())
        .toUri();

        return ResponseEntity
        .created(location) // Código 201 + header Location
        .body(employe); // Body con el empleado creado
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable Long id){
        Optional<Empleado> empleadoOpt = empleadoService.buscarPorId(id);
        if (empleadoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }else{
        empleadoService.eliminarEmpleado(id);;
        return ResponseEntity.ok("Empleado eliminado correctamente.");
        }
    }

    
    


}
