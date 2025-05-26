package cl.duoc.ferremas.Config;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cl.duoc.ferremas.Repository.CategoriaRepository;
import cl.duoc.ferremas.Repository.EmpleadoRepository;
import cl.duoc.ferremas.Repository.EmpleadoRolRepository;
import cl.duoc.ferremas.Repository.MarcaRepository;
import cl.duoc.ferremas.Repository.SucursalRepository;
import cl.duoc.ferremas.Models.EmpleadoRol;
import cl.duoc.ferremas.Models.Marca;
import cl.duoc.ferremas.Models.Categoria;
import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Sucursal;


@Component
public class DataInitializer implements CommandLineRunner {

    private final EmpleadoRolRepository empleadoRolRepository;

    private final SucursalRepository sucursalRepository;

    private final EmpleadoRepository empleadoRepository;

    private final MarcaRepository marcaRepository;

    private final CategoriaRepository categoriaRepository;

    public DataInitializer(EmpleadoRolRepository empleadoRolRepository,SucursalRepository sucursalRepository,
    EmpleadoRepository empleadoRepository,MarcaRepository marcaRepository,CategoriaRepository categoriaRepository) {
        this.empleadoRolRepository = empleadoRolRepository;
        this.sucursalRepository = sucursalRepository;
        this.empleadoRepository = empleadoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void run(String... args) {
        if (empleadoRolRepository.count() == 0) {
            empleadoRolRepository.save(new EmpleadoRol("Administrador", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Vendedor/Encargado", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Bodeguero", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Contador", LocalDate.now(), LocalTime.now()));
        }

        if (marcaRepository.count() == 0){
            marcaRepository.save(new Marca("Baucker"));
            marcaRepository.save(new Marca("CAT"));
            marcaRepository.save(new Marca("Bosch"));
            marcaRepository.save(new Marca("Stanley"));
            marcaRepository.save(new Marca("Truper"));
        }

        if (categoriaRepository.count() == 0){
            categoriaRepository.save(new Categoria("Herramientas manuales", "Martillos, destornilladores, llaves, alicates, sierras"));
            categoriaRepository.save(new Categoria("Herramientas eléctricas", "Taladros, esmeriles, sierras eléctricas, atornilladores, rotomartillos"));
            categoriaRepository.save(new Categoria("Pinturas y accesorios", "Pinturas al agua, esmaltes, rodillos, brochas, diluyentes"));
            categoriaRepository.save(new Categoria("Electricidad", "Interruptores, enchufes, cables, ampolletas, tableros eléctricos"));
            categoriaRepository.save(new Categoria("Iluminación", "Ampolletas LED, tubos fluorescentes, lámparas, focos exteriores"));
            categoriaRepository.save(new Categoria("Plomería y gasfitería", "Tuberías, fittings, griferías, sellos, flexibles"));
            categoriaRepository.save(new Categoria("Adhesivos y selladores", "Silicona, poxipol, colafría, cinta doble contacto, selladores PU"));
            categoriaRepository.save(new Categoria("Cerraduras y herrajes", "Cerraduras, bisagras, picaportes, candados, pasadores"));
            categoriaRepository.save(new Categoria("Baño y cocina", "Lavaplatos, lavamanos, WC, duchas, accesorios sanitarios"));
            categoriaRepository.save(new Categoria("Construcción", "Cemento, yeso, planchas OSB, perfiles metálicos, estucos"));
            categoriaRepository.save(new Categoria("Fijaciones", "Tornillos, clavos, tarugos, pernos, tuercas, arandelas"));
            categoriaRepository.save(new Categoria("Ferretería general", "Cadenas, alambres, poleas, tensores, herramientas varias"));
            categoriaRepository.save(new Categoria("Seguridad industrial", "Cascos, guantes, lentes de seguridad, mascarillas, ropa de trabajo"));
            categoriaRepository.save(new Categoria("Jardinería", "Palas, rastrillos, mangueras, regadores, tijeras de poda"));
            categoriaRepository.save(new Categoria("Limpieza", "Escobas, traperos, detergentes, cloro, guantes"));
        }

        if (sucursalRepository.count() == 0){

            Sucursal nvaEra = new Sucursal("Sucursal Nueva Era","Cantagallo 234",LocalDate.now(),LocalTime.now());
            Sucursal sRepu = new Sucursal("Sucursal Republica","Avenida España 123",LocalDate.now(),LocalTime.now());

            sucursalRepository.save(nvaEra);
            sucursalRepository.save(sRepu);
            
            // Obtener roles
            EmpleadoRol admin = empleadoRolRepository.findByDescripcionRol("Administrador");
            EmpleadoRol vendedor = empleadoRolRepository.findByDescripcionRol("Vendedor/Encargado");
            EmpleadoRol bodeguero = empleadoRolRepository.findByDescripcionRol("Bodeguero");
            EmpleadoRol contador = empleadoRolRepository.findByDescripcionRol("Contador");
        
            // Empleados para Sucursal Nueva Era
            empleadoRepository.save(new Empleado(admin, nvaEra, "12345678", "1", "Javier", "Antonio", "Gonzalez", "Barrientos", "javier@gmail.com", "ja.gonzalezb", "123"));
            empleadoRepository.save(new Empleado(vendedor, nvaEra, "23456789", "2", "Marcela", "Isabel", "Rojas", "Fuentes", "marcela.rf@gmail.com", "ma.rojasf", "abc123"));
            empleadoRepository.save(new Empleado(bodeguero, nvaEra, "34567890", "3", "Carlos", "Eduardo", "Vera", "Lopez", "carlosvl@gmail.com", "car.vera", "pass123"));
            empleadoRepository.save(new Empleado(contador, nvaEra, "45678901", "4", "Andrea", "Patricia", "Diaz", "Muñoz", "andrea.dm@gmail.com", "and.diaz", "conta321"));
        
            // Empleados para Sucursal Republica
            empleadoRepository.save(new Empleado(admin, sRepu, "56789012", "5", "Luis", "Miguel", "Torres", "Perez", "luismp@gmail.com", "lu.torres", "admin456"));
            empleadoRepository.save(new Empleado(vendedor, sRepu, "67890123", "6", "Camila", "Josefina", "Navarro", "Silva", "camila.ns@gmail.com", "ca.navarro", "vendi456"));
            empleadoRepository.save(new Empleado(bodeguero, sRepu, "78901234", "7", "Pedro", "Andres", "Soto", "Cano", "pedrosc@gmail.com", "pe.soto", "bode123"));
            empleadoRepository.save(new Empleado(contador, sRepu, "89012345", "8", "Valeria", "Fernanda", "Pizarro", "Aguilar", "valeria.pa@gmail.com", "va.pizarro", "conta789"));

        }
        


    }
}