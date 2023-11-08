package uniandes.edu.co.proyecto.Repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer>{
    @Query(value = "SELECT * FROM prestamos", nativeQuery=true)
    Collection<Prestamo> darPrestamos();

    @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery=true)
    Prestamo darPrestamo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (id, devuelto, malestado, hotel_nombre, id_cuenta) VALUES(hoteles_sequence.nextval, :nombre, :id, :devuelto, :malestado)", nativeQuery=true)
    void insertarPrestamo(@Param("id") Integer id, @Param("devuelto") Integer devuelto, @Param("malestado") Integer malestado, @Param("hotel_nombre") String hotel_nombre, @Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET devuelto = :devuelto, malestado = :malestado, hotel_nombre = :hotel_nombre, id_cuenta =: id_cuenta WHERE id=:id", nativeQuery = true)
    void actualizarPrestamo(@Param("devuelto") Integer devuelto, @Param("malestado") Integer malestado, @Param("hotel_nombre") String hotel_nombre, @Param("id_cuenta") Integer id_cuenta);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery=true)
    void eliminarPrestamo(@Param("id") Integer id);
    
}
