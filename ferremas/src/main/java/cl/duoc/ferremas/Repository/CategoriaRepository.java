package cl.duoc.ferremas.Repository;

import cl.duoc.ferremas.Models.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;




@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{
    
    Optional<Categoria> findByDescripcionCategoria(String descripcionCategoria);

    Optional<Categoria> findByNombreCategoriaContainingIgnoreCase(String nombreCategoria);
}
