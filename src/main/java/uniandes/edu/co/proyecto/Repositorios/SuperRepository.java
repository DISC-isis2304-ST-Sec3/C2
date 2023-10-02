package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Super;


public interface SuperRepository extends JpaRepository<Super, String> {
    @Query(value = "SELECT * FROM supers", nativeQuery=true)
    Collection<Super> darSupers();

    @Query(value = "SELECT * FROM supers WHERE nombre = :nombre", nativeQuery=true)
    Super darSuper(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO supers (nombre, consumo, hotel_nombre) VALUES(hoteles_sequence.nextval, :nombre, :consumo, :hotel_nombre)", nativeQuery=true)
    void insertarSuper(@Param("nombre") String nombre, @Param("consumo") Integer consumo,  @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE supers SET consumo = :consumo, hotel_nombre = :hotel_nombre WHERE nombre=:nombre", nativeQuery = true)
    void actualizarSuper(@Param("consumo") Integer consumo,  @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM supers WHERE nombre = :nombre", nativeQuery=true)
    void eliminarSuper(@Param("nombre") String nombre);
    
}
