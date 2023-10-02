package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Bar;

public interface BarRepository extends JpaRepository<Bar, String>{

    @Query(value = "SELECT * FROM bares", nativeQuery=true)
    Collection<Bar> darBares();

    @Query(value = "SELECT * FROM bares WHERE nombre = :nombre", nativeQuery=true)
    Bar darBar(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bares (nombre, estilo, costo, capacidad, hotel_nombre) VALUES(hoteles_sequence.nextval, :nombre, :esilo, :costo, :capacidad, :costocargado, :hotel_nombre)", nativeQuery=true)
    void insertarBar(@Param("nombre") String nombre, @Param("estilo") String estilo, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costocargado") Integer costocargado, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE bares SET estilo = :estilo, costo = :costo, capacidad = :capacidad, costocargado = :costocargado, hotel_nombre = :hotel_nombre WHERE nombre=:nombre", nativeQuery = true)
    void actualizarBar(@Param("estilo") String estilo, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costocargado") Integer costocargado, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bares WHERE nombre = :nombre", nativeQuery=true)
    void eliminarBar(@Param("nombre") String nombre);

}