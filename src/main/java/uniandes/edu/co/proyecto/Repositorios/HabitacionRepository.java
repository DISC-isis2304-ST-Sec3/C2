package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Integer>{
    @Query(value = "SELECT * FROM habitaciones", nativeQuery=true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE id = :id", nativeQuery=true)
    Habitacion darHabitacion(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (id, tipo, capacidad, precio, consumo, nombreHotel) VALUES(hoteles_sequence.nextval, :id, :tipo, :capacidad, :precio, :consumo, :nombreHotel)", nativeQuery=true)
    void insertarHabitacion(@Param("id") Integer id, @Param("tipo") String tipo, @Param("capacidad") Integer capacidad, @Param("precio") Integer precio, @Param("consumo") Integer consumo, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE habitaciones SET tipo = :tipo, capacidad = :capacidad, precio = :precio, consumo = :consumo, nombreHotel = :nombreHotel WHERE id = :id", nativeQuery = true)
    void actualizarHabitacion(@Param("tipo") String tipo, @Param("capacidad") Integer capacidad, @Param("precio") Integer precio, @Param("consumo") Integer consumo, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE id = :id", nativeQuery=true)
    void eliminarHabitacion(@Param("id") Integer id);

}
