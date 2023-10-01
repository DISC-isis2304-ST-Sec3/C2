package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Gimnasio;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Integer>{

    @Query(value = "SELECT * FROM gimnasios", nativeQuery=true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE id = :id", nativeQuery=true)
    Gimnasio darGimnasio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (id, capacidad, horario, nombreHotel) VALUES(hoteles_sequence.nextval, :id, :capacidd, :horario, :nombreHotel)", nativeQuery=true)
    void insertarGimnasio(@Param("id") Integer id, @Param("capacidad") Integer capacidad, @Param("horario") Date horario, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad = :capacidad, horario = :horario, nombreHotel = :nombreHotel WHERE id=:id", nativeQuery = true)
    void actualizarGimnasio(@Param("capacidad") Integer capacidad, @Param("horario") Date horario, @Param("nombreHotel") String nombreHotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id", nativeQuery=true)
    void eliminarGimnasios(@Param("id") Integer id);
}
