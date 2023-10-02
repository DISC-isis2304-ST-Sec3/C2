package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Spa;

public interface SpaRepository extends JpaRepository<Spa, Integer> {
    @Query(value = "SELECT * FROM spas", nativeQuery=true)
    Collection<Spa> darSpas();

    @Query(value = "SELECT * FROM spas WHERE id = :id", nativeQuery=true)
    Spa darSpa(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas (id, duracion, costo, consumo, horario, nombre_hotel) VALUES(hoteles_sequence.nextval, :id, :duracion, :costo, :consumo, :horario, :nombre_hotel)", nativeQuery=true)
    void insertarSpa(@Param("id") Integer id, @Param("duracion") Integer duracion, @Param("costo") Integer costo, @Param("consumo") Integer consumo, @Param("horario") String horario, @Param("nombre_hotel") String nombre_hotel);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET duracion = :duracion, costo = :costo, consumo = :consumo, horario = :horario, nombre_hotel = :nombre_hotel WHERE id=:id", nativeQuery = true)
    void actualizarSpa(@Param("duracion") Integer duracion, @Param("costo") Integer costo, @Param("consumo") Integer consumo, @Param("horario") String horario, @Param("nombre_hotel") String nombre_hotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE id = :id)", nativeQuery=true)
    void eliminarSpa(@Param("id") Integer id);
    
}
