package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Restaurante;
public interface RestauranteRepository extends JpaRepository<Restaurante, String> {
    
    @Query(value = "SELECT * FROM restaurantes", nativeQuery=true)
    Collection<Restaurante> darRestaurantes();

    @Query(value = "SELECT * FROM restaurantes WHERE nombre = :nombre", nativeQuery=true)
    Restaurante darRestaurante(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO restaurantes (nombre, estilo, costo, capacidad, hotel_nombre) VALUES(hoteles_sequence.nextval, :nombre, :esilo, :costo, :capacidad, :costocargado, :hotel_nombre)", nativeQuery=true)
    void insertarRestaurante(@Param("nombre") String nombre, @Param("estilo") String estilo, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costocargado") Integer costocargado, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE restaurantes SET estilo = :estilo, costo = :costo, capacidad = :capacidad, costocargado = :costocargado, hotel_nombre = :hotel_nombre WHERE nombre=:nombre", nativeQuery = true)
    void actualizarRestaurante(@Param("estilo") String estilo, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costocargado") Integer costocargado, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM restaurantes WHERE nombre = :nombre", nativeQuery=true)
    void eliminarRestaurante(@Param("nombre") String nombre);
}
