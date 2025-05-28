package cl.duoc.ferremas.Models.ModelsDTO;

import java.time.LocalDate;
import java.util.UUID;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;


public class ProductoRDTO {

    private String marca;
    private String categoria;
    private String nombreP;
    private BigDecimal precioP;
    private int cantidadStock;
    

    public ProductoRDTO() {
    }

    public ProductoRDTO(String marca, String categoria,  String nombreP, BigDecimal precioP, int cantidadStock) {
        this.marca = marca;
        this.categoria = categoria;
        this.nombreP = nombreP;
        this.precioP = precioP;
        this.cantidadStock = cantidadStock;
    }

    public ProductoRDTO(String marca, String categoria,  String nombreP, BigDecimal precioP) {
        this.marca = marca;
        this.categoria = categoria;
        this.nombreP = nombreP;
        this.precioP = precioP;
    }

    //public String generarCodigo(Long idSupuesto) {
    //    char nom = Character.toUpperCase(nombreP.charAt(0));
    //    char cat = Character.toUpperCase(categoria.charAt(0));
    //    char mar = Character.toUpperCase(marca.charAt(0));
    //    // Reemplazar por milisegundos y dias
    //    String anio = String.valueOf(LocalDate.now().getYear()).substring(2);
    //    String mes = String.format("%02d", LocalDate.now().getMonthValue());
    //    int precioEntero = precioP.intValue();
    //    String precioCorto = String.format("%02d", ((int) precioEntero) % 100);
    //    // Generar un hash único de 4 caracteres basado en UUID
    //    String uniqueHash = UUID.randomUUID().toString().replace("-", "").substring(0, 4).toUpperCase();
    //    return "" + nom + cat + ++idSupuesto + mar + anio + mes + precioCorto + "-" + uniqueHash;
    //}

    public String generarCodigo() {
    char nom = Character.toUpperCase(nombreP.charAt(0));
    char cat = Character.toUpperCase(categoria.charAt(0));
    char mar = Character.toUpperCase(marca.charAt(0));
    int precioEntero = precioP.intValue();
    String precioFragmento = String.format("%02d", precioEntero % 100);
    long tiempoMillis = System.currentTimeMillis();
    String hash = UUID.randomUUID().toString().replace("-", "").substring(0, 4).toUpperCase();
    return "" + nom + cat + mar + precioFragmento + "-" + tiempoMillis + hash;
    }   


    public int getCantidadStock(){
        return this.cantidadStock;
    }

    public void setCantidadStock(int x){
        this.cantidadStock = x;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreP() {
        return this.nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public BigDecimal getPrecioP() {
        return this.precioP;
    }

    public void setPrecioP(BigDecimal precioP) {
        this.precioP = precioP;
    }



    public ProductoRDTO marca(String marca) {
        setMarca(marca);
        return this;
    }

    public ProductoRDTO categoria(String categoria) {
        setCategoria(categoria);
        return this;
    }


    public ProductoRDTO nombreP(String nombreP) {
        setNombreP(nombreP);
        return this;
    }

    public ProductoRDTO precioP(BigDecimal precioP) {
        setPrecioP(precioP);
        return this;
    }




    @Override
    public String toString() {
        return "{" +
            " marca='" + getMarca() + "'" +
            ", categoria='" + getCategoria() + "'" +
            ", nombreP='" + getNombreP() + "'" +
            ", precioP='" + getPrecioP() + "'" +
            "}";
    }



}
