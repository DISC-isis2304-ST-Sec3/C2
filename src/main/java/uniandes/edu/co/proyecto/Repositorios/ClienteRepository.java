package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
    @Query(value = "SELECT * FROM clientes", nativeQuery=true)
    Collection<Cliente> darClientes();

    @Query(value = "SELECT * FROM clientes WHERE documento = :documento", nativeQuery=true)
    Cliente darCliente(@Param("documento") Integer documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO clientes (nombre, apellido, documento, edad, habitacion, consumo, hotel_nombre, checksins_id, checksouts_id, reservas_id) VALUES(hoteles_sequence.nextval, :nombre, :apellido, :documento, :edad, :habitacion, :consumo, :hotel_nombre, :checksins_id, :checksouts_id, :reservas_id)", nativeQuery=true)
    void insertarCliente(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("documento") Integer documento, @Param("edad") Integer edad, @Param("habitacion") Integer habitacion, @Param("consumo") Integer consumo, @Param("hotel_nombre") String hotel_nombre, @Param("checksins_id") Integer checksins_id, @Param("checksouts_id") Integer checksouts_id, @Param("reservas_id") Integer reservas_id);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE clientes SET nombre = :nombre, apellido = :apellido, edad = :edad, habitacion = :habitacion, consumo = :consumo, hotel_nombre = :hotel_nombre, checksins_id = :checksins_id, checksouts_id = :checksouts_id, reservas_id = :reservas_id WHERE documento = :documento", nativeQuery = true)
    void actualizarCliente(@Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") Integer edad, @Param("habitacion") Integer habitacion, @Param("consumo") Integer consumo, @Param("hotel_nombre") String hotel_nombre, @Param("checksins_id") Integer checksins_id, @Param("checksouts_id") Integer checksouts_id, @Param("reservas_id") Integer reservas_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM clientes WHERE documento = :documento", nativeQuery=true)
    void eliminarCliente(@Param("documento") Integer documento);

    //Requerimiento 12
    @Query(value = "SELECT * FROM clientes WHERE hotel_nombre = :hotel_nombre"
    + "INNER JOIN checkins ON clientes.checkins_id = checkins.id"
    + "INNER JOIN checkouts ON clientes.checkouts_id = checkouts.id"
    + "INNER JOIN cuentas on clientes.documento = cuentas.clientes_documento"
    + "INNER JOIN cuentasspas on cuentas.id = cuentasspas.cuentas_id"
    + "AND (((SELECT dia from checkins) Between ((1/01/2023 And 31/03/2023) OR (1/04/2023 And 30/06/2023) OR (1/07/2023 And 30/09/2023) OR (1/10/2023 And 31/12/2023)))"
    + "AND ((SELECT dia from checkouts) Between ((1/01/2023 And 31/03/2023) OR (1/04/2023 And 30/06/2023) OR (1/07/2023 And 30/09/2023) OR (1/10/2023 And 31/12/2023))))"
    + "OR (SELECT consumo from cuentas where consumo > 300000)"
    + "OR (clientes.documento = cuentas.clientes_documento AND cuentas.id = cuentasspas.cuentas_id)", nativeQuery=true)
    Collection<Cliente> darClientesHotel(@Param("hotel_nombre") String hotel_nombre);

    //Requerimiento 9
    @Query(value = "SELECT * FROM clientes where hotel_nombre = :hotel_nombre"
    + "INNER JOIN clientes on clientes.documento = cuentas.clientes_documento"
    + "INNER JOIN cuentasspas on cuentas.id = cuentasspas.cuentas_id"
    + "INNER JOIN cntasbares on cuentas.id = cntasbartes.cuentas_id"
    + "INNER JOIN cntasredes on cuentas.id = cntasredes.cuentas_id"
    + "INNER JOIN cntasres on cuentas.id = cntasres.cuentas_id"
    + "INNER JOIN cntassuper on cuentas.id = cntassuper.cuentas_id"
    + "INNER JOIN cntastiendas on cuentas.id = cntastiendas.cuentas_id"
    + "INNER JOIN cuentasspas on spas.id = cuentasspas.spas_id"
    + "INNER JOIN cntasbares on bares.nombre = cntasbares.bares_nombre"
    + "INNER JOIN cntasredes on internets.id =cntasredes.internets_id"
    + "INNER JOIN cntasres on restaurantes.rests_id = cntasres.restaurantes_rests_id"
    + "INNER JOIN cntassuper on supers.nombre = supers.supers_nombre"
    + "INNER JOIN cntastiendas on tiendas.nombre = cntastiendas.tiendas_nombre"
    + "AND (cuentasspas.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasbares.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasredes.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasres.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntassuper.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntastiendas.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "GROUPBY caracteristica", nativeQuery = true)
    Collection<Cliente> darClientesCaracteristica(@Param("hotel_nombre") String hotel_nombre); 

    //Requerimiento 10
    @Query(value = "SELECT * FROM clientes where hotel_nombre = :hotel_nombre"
    + "INNER JOIN clientes on clientes.documento = cuentas.clientes_documento"
    + "INNER JOIN cuentasspas on cuentas.id = cuentasspas.cuentas_id"
    + "INNER JOIN cntasbares on cuentas.id = cntasbartes.cuentas_id"
    + "INNER JOIN cntasredes on cuentas.id = cntasredes.cuentas_id"
    + "INNER JOIN cntasres on cuentas.id = cntasres.cuentas_id"
    + "INNER JOIN cntassuper on cuentas.id = cntassuper.cuentas_id"
    + "INNER JOIN cntastiendas on cuentas.id = cntastiendas.cuentas_id"
    + "INNER JOIN cuentasspas on spas.id = cuentasspas.spas_id"
    + "INNER JOIN cntasbares on bares.nombre = cntasbares.bares_nombre"
    + "INNER JOIN cntasredes on internets.id =cntasredes.internets_id"
    + "INNER JOIN cntasres on restaurantes.rests_id = cntasres.restaurantes_rests_id"
    + "INNER JOIN cntassuper on supers.nombre = supers.supers_nombre"
    + "INNER JOIN cntastiendas on tiendas.nombre = cntastiendas.tiendas_nombre"
    + "AND (cuentasspas.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasbares.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasredes.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntasres.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntassuper.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "OR (cntastiendas.fecha BETWEEN (fecha_inicial =: fecha_inicial AND fecha_final =: fecha_final))"
    + "AND cuenta.valor = 0"
    + "GROUPBY caracteristica", nativeQuery = true)
    Collection<Cliente> darClientesCaracteristica2(@Param("hotel_nombre") String hotel_nombre);
 
}
