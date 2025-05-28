package cl.duoc.ferremas.Config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cl.duoc.ferremas.Repository.*;
import cl.duoc.ferremas.Models.EmpleadoRol;
import cl.duoc.ferremas.Models.Marca;
import cl.duoc.ferremas.Models.PrecioPHistorial;
import cl.duoc.ferremas.Models.Producto;
import cl.duoc.ferremas.Models.Categoria;
import cl.duoc.ferremas.Models.Empleado;
import cl.duoc.ferremas.Models.Sucursal;
import cl.duoc.ferremas.Models.SucursalStockP;
import cl.duoc.ferremas.Models.ModelsDTO.ProductoRDTO;


@Component
public class DataInitializer implements CommandLineRunner {

   

    private final EmpleadoRolRepository empleadoRolRepository;
    private final SucursalRepository sucursalRepository;
    private final EmpleadoRepository empleadoRepository;
    private final MarcaRepository marcaRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;
    private final SucursalStockPRepository sucursalStockPRepository;
    private final PrecioPHistorialRepository precioPHistorialRepository;



    public DataInitializer(EmpleadoRolRepository empleadoRolRepository,SucursalRepository sucursalRepository,
    EmpleadoRepository empleadoRepository,MarcaRepository marcaRepository,CategoriaRepository categoriaRepository,
    ProductoRepository productoRepository,SucursalStockPRepository sucursalStockPRepository,PrecioPHistorialRepository precioPHistorialRepository) {
        this.empleadoRolRepository = empleadoRolRepository;
        this.sucursalRepository = sucursalRepository;
        this.empleadoRepository = empleadoRepository;
        this.marcaRepository = marcaRepository;
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
        this.sucursalStockPRepository = sucursalStockPRepository;
        this.precioPHistorialRepository = precioPHistorialRepository;
    }





    @Override
    public void run(String... args) {


        if (empleadoRolRepository.count() == 0 && marcaRepository.count() == 0 && categoriaRepository.count() == 0 && sucursalRepository.count() == 0
           && productoRepository.count() == 0) {
            empleadoRolRepository.save(new EmpleadoRol("Administrador", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Vendedor/Encargado", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Bodeguero", LocalDate.now(), LocalTime.now()));
            empleadoRolRepository.save(new EmpleadoRol("Contador", LocalDate.now(), LocalTime.now()));
       

        
            Marca marca1 = marcaRepository.save(new Marca("Baucker"));
            Marca marca2 = marcaRepository.save(new Marca("CAT"));
            marcaRepository.save(new Marca("Bosch"));
            marcaRepository.save(new Marca("Stanley"));
            marcaRepository.save(new Marca("Truper"));
       

        
            Categoria categoria1 = categoriaRepository.save(new Categoria("Herramientas manuales", "Martillos, destornilladores, llaves, alicates, sierras"));
            Categoria categoria2 = categoriaRepository.save(new Categoria("Herramientas eléctricas", "Taladros, esmeriles, sierras eléctricas, atornilladores, rotomartillos"));
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


            ProductoRDTO productoR1 = new ProductoRDTO("Baucker","Herramientas manuales","Martillo carpintero",new BigDecimal(5000),10);
            ProductoRDTO productoR2 = new ProductoRDTO("CAT","Herramientas eléctricas","Taladro estandar",new BigDecimal(5000),10);

            Producto producto1 = productoRepository.save(new Producto(marca1,categoria1,productoR1.generarCodigo(),"Martillo carpintero",new BigDecimal(5000)));
            Producto producto2 = productoRepository.save(new Producto(marca2,categoria2,productoR2.generarCodigo(),"Taladro estandar",new BigDecimal(30000)));

            sucursalRepository.findAll().forEach(sucursalS ->{
                sucursalStockPRepository.save(new SucursalStockP(producto1,sucursalS,10));
                sucursalStockPRepository.save(new SucursalStockP(producto2,sucursalS,10));
            });

            precioPHistorialRepository.save(new PrecioPHistorial(producto1,producto1.getPrecioP()));
            precioPHistorialRepository.save(new PrecioPHistorial(producto2,producto2.getPrecioP()));
        }
        
        


    }
}