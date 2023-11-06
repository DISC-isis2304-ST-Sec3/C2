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

    @Query(value = "SELECT clientes.*, cuentas.consumo, reservas.fechaentrada FROM clientes INNER JOIN reservas.clientes_documento = clientes.documento "+
    "INNER JOIN clientes.documento = cuentas.clientes_documento "+
    "WHERE ((reservas.fechasalida - reservas.fechaentrada) >= 14) OR (cuentas.consumo > 15000000 AND reservas.fechaentrada > '01-01-2023') ", nativeQuery = true)
    Collection<Cliente> darBuenosClientes();
}

