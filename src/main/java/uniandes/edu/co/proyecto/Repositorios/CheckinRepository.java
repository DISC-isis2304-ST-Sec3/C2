package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Checkin;

public interface CheckinRepository extends JpaRepository<Checkin, Integer>{

    @Query(value = "SELECT * FROM checkins", nativeQuery=true)
    Collection<Checkin> darCheckins();

    @Query(value = "SELECT * FROM checkins WHERE id = :id", nativeQuery=true)
    Checkin darCheckin(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkins (id, documentocliente, dia, realizadopor, cuentaabierta, documentoCliente, documentoEmpleado) VALUES(hoteles_sequence.nextval, :id, :documentocliente, :dia, :realizadopor, :cuentaabierta, :documentoCliente, :documentoEmpleado)", nativeQuery=true)
    void insertarCheckin(@Param("id") Integer id, @Param("documentocliente") Integer documentocliente, @Param("dia") Date dia, @Param("realizadopor") String realizadopor, @Param("cuentaabierta") Integer cuentaabierta, @Param("documentoCliente") Integer documentoCliente, @Param("documentoEmpleado") Integer documentoEmpleado);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE checkins SET documentocliente = :documentocliente, dia = :dia, realizadopor = :realizadopor, cuentaabierta = :cuentaabierta, documentoCliente = :documentoCliente, documentoEmpleado = :documentoEmpleado WHERE id=:id", nativeQuery = true)
    void actualizarCheckin(@Param("documentocliente") Integer documentocliente, @Param("dia") Date dia, @Param("realizadopor") String realizadopor, @Param("cuentaabierta") Integer cuentaabierta, @Param("documentoCliente") Integer documentoCliente, @Param("documentoEmpleado") Integer documentoEmpleado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkins WHERE documentocliente = :documentocliente)", nativeQuery=true)
    void eliminarCheckin(@Param("id") Integer id);

    @Query(value = "SELECT fecha, COUNT(*) as ocupacion\r\n" +
       "FROM checkin\r\n" +
       "GROUP BY fecha\r\n" +
       "ORDER BY ocupacion DESC\r\n" +
       "LIMIT 1", nativeQuery = true)
    Date darFechaMayorOcupacion();

    @Query(value = "SELECT fecha, COUNT(*) as ocupacion\r\n" +
    "FROM checkin\r\n" +
    "GROUP BY fecha\r\n" +
    "ORDER BY ocupacion ASC\r\n" +
    "LIMIT 1", nativeQuery = true)
    Date darFechaMenorOcupacion();

    @Query(value = "SELECT fecha, SUM(consumo) as ingresos\r\n" +
       "FROM cuenta\r\n" +
       "INNER JOIN checkin ON cuenta.documento = checkin.documento\r\n" +
       "GROUP BY fecha\r\n" +
       "ORDER BY ingresos DESC\r\n" +
       "LIMIT 1", nativeQuery = true)
    Date darFechaMayoresIngresos();

}
