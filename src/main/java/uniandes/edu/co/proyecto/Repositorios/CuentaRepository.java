package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    @Query(value = "SELECT * FROM cuentas", nativeQuery=true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE id = :id", nativeQuery=true)
    Cuenta darCuenta(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO cuentas (id, consumo, valor, cliente) VALUES(hoteles_sequence.nextval, :id, :consumo, :valor, :cliente)", nativeQuery=true)
    void insertarCuenta(@Param("id") Integer id, @Param("consumo") Integer consumo, @Param("valor") Integer valor, @Param("cliente") String cliente);

    @Modifying
    @Transactional
    @Query(value = "UPDATE cuentas SET id = :id, consumo = :consumo, valor = :valor, cliente = :cliente WHERE id=:id", nativeQuery = true)
    void actualizarCuenta(@Param("id") Integer id, @Param("consumo") Integer consumo, @Param("valor") Integer valor, @Param("cliente") String cliente);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cuentas WHERE id = :id", nativeQuery=true)
    void eliminarCuenta(@Param("id") Integer id);
}
