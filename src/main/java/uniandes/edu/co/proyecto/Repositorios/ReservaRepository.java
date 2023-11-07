package uniandes.edu.co.proyecto.Repositorios;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
    @Query(value = "SELECT * FROM reservas", nativeQuery=true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE id = :id", nativeQuery=true)
    Reserva darReserva(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (id, numpersonas, fechaentrada, fechasalida, clientes_documento) VALUES(hoteles_sequence.nextval, :id, :numpersonas, :fechaentrada, :fechasalida, :clientes_documento)", nativeQuery=true)
    void insertarReserva(@Param("id") Integer id, @Param("numpersonas") Integer numpersonas, @Param("fechaentrada") Date fechaentradas, @Param("fechasalida") Date fechasalida, @Param("clientes_documento") Integer clientes_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET numpersonas = :numpersonas, fechaentrada = :fechaentrada, fechasalida = :fechasalida, clientes_documento = :clientes_documento WHERE id = :id", nativeQuery = true)
    void actualizarReserva(@Param("numpersonas") Integer numpersonas, @Param("fechaentrada") Date fechaentrada, @Param("fechasalida") Date fechasalida, @Param("clientes_documento") Integer clientes_documento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE id = :id", nativeQuery=true)
    void eliminarReserva(@Param("id") Integer id);
}
