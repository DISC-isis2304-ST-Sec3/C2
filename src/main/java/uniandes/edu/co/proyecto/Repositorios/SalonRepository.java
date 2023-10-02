package uniandes.edu.co.proyecto.Repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Salon;


public interface SalonRepository  extends JpaRepository<Salon, String>{
    @Query(value = "SELECT * FROM salones", nativeQuery=true)
    Collection<Salon> darSalones();

    @Query(value = "SELECT * FROM salones WHERE id = :id", nativeQuery=true)
    Salon darSalon(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO salones (id, estilo, costo, capacidad, hotel_nombre) VALUES(hoteles_sequence.nextval, :id, :esilo, :costo, :capacidad, :costoadicional, :costoad :hotel_nombre)", nativeQuery=true)
    void insertarSalon(@Param("id") Integer id,  @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costoadicional") Boolean costoadicional, @Param("costoad") Integer costoad,@Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE salones SET estilo = :estilo, costo = :costo, capacidad = :capacidad, costoadicional = :costoadicional, costoad = :costoad, hotel_nombre = :hotel_nombre WHERE id=:id", nativeQuery = true)
    void actualizarSalon(@Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("costoadicional") Boolean costoadicional, @Param("costoad") Integer costoad,@Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM salones WHERE id = :id", nativeQuery=true)
    void eliminarSalon(@Param("id") Integer id);
}
