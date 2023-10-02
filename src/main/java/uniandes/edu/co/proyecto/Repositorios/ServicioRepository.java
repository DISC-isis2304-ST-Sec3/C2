package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Integer>{
    @Query(value = "SELECT * FROM servicios", nativeQuery=true)
    Collection<Servicio> darServicio();

    @Query(value = "SELECT * FROM servicios WHERE id = :id", nativeQuery=true)
    Servicio darServicio(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios (id, tipo, numprendas, costos, nombre_hotel) VALUES(hoteles_sequence.nextval, :id, :tipo, :numprendas, :costos, :nombre_hotel)", nativeQuery=true)
    void insertarServicio(@Param("id") Integer id, @Param("tipo") String tipo, @Param("numprendas") Integer numprendas, @Param("costos") Integer costos, @Param("nombre_hotel") String nombre_hotel);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios SET tipo = :tipo, numprendas = :numprendas, costos = :costos, nombre_hotel = :nombre_hotel WHERE id = :id", nativeQuery = true)
    void actualizarServicio(@Param("tipo") String tipo, @Param("numprendas") Integer numprendas, @Param("costos") Integer costos, @Param("nombre_hotel") String nombre_hotel);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicio WHERE id = :id", nativeQuery=true)
    void eliminarServicio(@Param("id") Integer id);

}
