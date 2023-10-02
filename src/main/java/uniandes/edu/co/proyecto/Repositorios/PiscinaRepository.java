package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Piscina;

public interface PiscinaRepository extends JpaRepository<Piscina, String> {
    
    @Query(value = "SELECT * FROM piscinas", nativeQuery=true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id = :id", nativeQuery=true)
    Piscina darPiscina(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (id, capacidad, profunidad, horario, hotel_nombre) VALUES(hoteles_sequence.nextval, :nombre, :id, :capacidad, :profunidad, :horario, :hotel_nombre)", nativeQuery=true)
    void insertarPiscina(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("profunidad") Integer profundidad, @Param("horario") String horario, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET capacidad = :capacidad, profunidad = :profundidad, horario = :horario, hotel_nombre = :hotel_nombre WHERE id=:id", nativeQuery = true)
    void actualizarPiscina(@Param("capacidad") Integer capacidad, @Param("profunidad") Integer profunidad, @Param("horario") String horario, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id", nativeQuery=true)
    void eliminarPiscina(@Param("id") Integer id);

}
