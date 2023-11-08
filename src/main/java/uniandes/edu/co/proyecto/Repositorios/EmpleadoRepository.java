package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Empleado;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    @Query(value = "SELECT * FROM empleados", nativeQuery=true)
    Collection<Empleado> darEmpleados();

    @Query(value = "SELECT * FROM empleados WHERE documento = :documento", nativeQuery=true)
    Empleado darEmpleado(@Param("documento") String documento);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO empleados (documento, nombre, apellido, edad, cargo, salario, hotel_nombre) VALUES(hoteles_sequence.nextval, :documento, :nombre, :apellido, :edad, :cargo, :salario, :hotel_nombre)", nativeQuery=true)
    void insertarEmpleado(@Param("documento") int documento, @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") Integer edad, @Param("cargo") String cargo, @Param("salario") Integer salario, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE empleados SET nombre = :nombre, apellido = :apellido, edad = :edad, cargo = :cargo, salario = :salario, hotel_nombre =:hotel_nombre  WHERE documento=:documento", nativeQuery = true)
    void actualizarEmpleado( @Param("nombre") String nombre, @Param("apellido") String apellido, @Param("edad") Integer edad, @Param("cargo") String cargo, @Param("salario") Integer salario,  @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM empleados WHERE documento = :documento", nativeQuery=true)
    void eliminarEmpleado(@Param("documento") String documento);

    
}
