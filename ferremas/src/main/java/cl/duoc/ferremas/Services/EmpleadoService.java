package cl.duoc.ferremas.Services;


import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.EmpleadoRol;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.ModelsDTO.EmpleadoRDTO;
import cl.duoc.ferremas.Repository.EmpleadoRepository;
import cl.duoc.ferremas.Repository.EmpleadoRolRepository;
import cl.duoc.ferremas.Repository.UsuarioMensajeRepository;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Collections;
import java.time.LocalDate;
import java.time.LocalTime;



@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;


    private final SucursalService sucursalService;

    private final EmpleadoRolRepository empleadoRolRepository;

    private final UsuarioMensajeRepository usuarioMensajeRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository,SucursalService sucursalService,EmpleadoRolRepository empleadoRolRepository,UsuarioMensajeRepository usuarioMensajeRepository){
        this.empleadoRepository = empleadoRepository;
        this.sucursalService = sucursalService;
        this.empleadoRolRepository = empleadoRolRepository;
        this.usuarioMensajeRepository = usuarioMensajeRepository;
    }


    public List<Empleado> listarEmpleados(){
        return empleadoRepository.findAll();
    }


    public Optional<Empleado> buscarPorId(Long id){
        return empleadoRepository.findById(id);
    }

    public void eliminarEmpleado(Long id){
        empleadoRepository.deleteById(id);
    }


    public Empleado registrarEmpleado(EmpleadoRDTO empleadoR){
        Sucursal sucursal = sucursalService.buscarPorId(empleadoR.getIdSucursal())
        .orElseThrow(() -> new EntityNotFoundException("Sucursal no encontrada con ID: " + empleadoR.getIdSucursal()));

        EmpleadoRol rolEmplo= empleadoRolRepository.findById(empleadoR.getIdRolEmpleado())
        .orElseThrow(() -> new EntityNotFoundException("Rol de empleado no encontrada con ID: " + empleadoR.getIdRolEmpleado()));

        Empleado employer = new Empleado(rolEmplo,sucursal,empleadoR.getRutUsuario(),empleadoR.getCodigoVerificador(),empleadoR.getpNombre(),
        empleadoR.getsNombre(),empleadoR.getpApellido(),empleadoR.getsApellido(),empleadoR.getCorreoEmpleado(),empleadoR.getNombreUsuario(),
        empleadoR.getContrasena());

        return empleadoRepository.save(employer);
    }







}
