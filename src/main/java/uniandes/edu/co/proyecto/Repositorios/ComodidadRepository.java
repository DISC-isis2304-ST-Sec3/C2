package uniandes.edu.co.proyecto.Repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Comodidad;


public interface ComodidadRepository extends JpaRepository<Comodidad, String>{

    @Query(value = "SELECT * FROM comodidades", nativeQuery=true)
    Collection<Comodidad> darComodidades();

    @Query(value = "SELECT * FROM comodidades WHERE nombre = :nombre", nativeQuery=true)
    Comodidad darComodidad(@Param("pk") int pk);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO comodidades (pk, comodidad) VALUES(hoteles_sequence.nextval, :pk, :comodidad)", nativeQuery=true)
    void insertarComodidad(@Param("pk") String pk, @Param("comodidad") String comodidad);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE comodidades SET  comodidad = :comodidad WHERE pk=:pk", nativeQuery = true)
    void actualizarComodidad(@Param("comodidad") String comodidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM comodidades WHERE pk = :pk", nativeQuery=true)
    void eliminarBar(@Param("pk") String pk);
    
}
