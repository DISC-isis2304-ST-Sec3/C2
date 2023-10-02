package uniandes.edu.co.proyecto.Repositorios;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Checkout;

public interface CheckOutRepository extends JpaRepository<Checkout, String>{

    @Query(value = "SELECT * FROM checkouts", nativeQuery=true)
    Collection<Checkout> darCheckouts();

    @Query(value = "SELECT * FROM checkouts WHERE id = :id", nativeQuery=true)
    Checkout darCheckout(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO checkouts (id, dia, cuentaabierta, cuentatotal, pagocuenta, cliente_documento) VALUES(hoteles_sequence.nextval, :id, :dia, ;cuentaabierta, :cuentatotal, :pagocuenta, :cliente_documento)", nativeQuery=true)
    void insertarCheckout(@Param("id") Integer id, @Param("dia") Date dia, @Param("cuentaabierta") Integer cuentaabierta, @Param("cuentatotal") Integer cuentatotal, @Param("pagocuenta") Integer pagocuenta, @Param("cliente_documento") Integer cliente_documento);

    @Modifying
    @Transactional
    @Query(value = "UPDATE checkouts SET  dia = :dia, cuentaabierta = :cuentaabierta, cuentatotal = :cuentatotal, pagocuenta = :pagocuenta, cliente_documento = :cliente_documento WHERE id=:id", nativeQuery = true)
    void actualizarCheckout( @Param("dia") Date dia, @Param("cuentaabierta") Integer cuentaabierta, @Param("cuentatotal") Integer cuentatotal, @Param("pagocuenta") Integer pagocuenta, @Param("cliente_documento") Integer cliente_documento);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM checkouts WHERE id = :id", nativeQuery=true)
    void eliminarCheckout(@Param("id") Integer id);

}