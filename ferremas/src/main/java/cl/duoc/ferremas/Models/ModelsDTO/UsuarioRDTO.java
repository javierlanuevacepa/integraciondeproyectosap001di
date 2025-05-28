package cl.duoc.ferremas.Models.ModelsDTO;
import java.util.Objects;

public class UsuarioRDTO {
    
    private String correoElectronico;
    private String contrasena;


    

    public UsuarioRDTO() {
    }

    public UsuarioRDTO(String correoElectronico, String contrasena) {
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    public String getCorreoElectronico() {
        return this.correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UsuarioRDTO correoElectronico(String correoElectronico) {
        setCorreoElectronico(correoElectronico);
        return this;
    }

    public UsuarioRDTO contrasena(String contrasena) {
        setContrasena(contrasena);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioRDTO)) {
            return false;
        }
        UsuarioRDTO usuarioRDTO = (UsuarioRDTO) o;
        return Objects.equals(correoElectronico, usuarioRDTO.correoElectronico) && Objects.equals(contrasena, usuarioRDTO.contrasena);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correoElectronico, contrasena);
    }

    @Override
    public String toString() {
        return "{" +
            " correoElectronico='" + getCorreoElectronico() + "'" +
            ", contrasena='" + getContrasena() + "'" +
            "}";
    }

    
}
