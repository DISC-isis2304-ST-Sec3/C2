package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Reservaservicio;

public interface ReservaservicioRepository extends JpaRepository<Reservaservicio, Integer> {
    @Query(value = "SELECT * FROM reservasservicio", nativeQuery=true)
    Collection<Reservaservicio> darReservasservicios();

    @Query(value = "SELECT * FROM reservasservicios WHERE id = :id", nativeQuery=true)
    Reservaservicio darReservaservicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservasservicios (id, habitacion, servicio, horainicio, horafin, documentoCliente) VALUES(hoteles_sequence.nextval, :id, :habitacion, :servicio, :horainicio, :horafin, :documentoCliente)", nativeQuery=true)
    void insertarReservaservicio(@Param("id") Integer id, @Param("habitacion") Integer habitacion, @Param("servicio") String servicio, @Param("horainicio") String horainicio, @Param("horafin") String horafin, @Param("documentoCliente") Integer documentoCliente);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservasservicios SET habitacion = :habitacion, servicio = :servicio, horainicio = :horainicio, horafin = :horafin, documentoCliente = :documentoCliente WHERE id=:id", nativeQuery = true)
    void actualizarReservaservicio(@Param("habitacion") Integer habitacion, @Param("servicio") String servicio, @Param("horainicio") String horainicio, @Param("horafin") String horafin, @Param("documentoCliente") Integer documentoCliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservasservicios WHERE id = :id)", nativeQuery=true)
    void eliminarReservaservicio(@Param("id") Integer id);
}
