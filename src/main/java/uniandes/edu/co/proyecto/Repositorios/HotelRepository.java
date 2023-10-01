package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {
    @Query(value = "SELECT * FROM hoteles", nativeQuery=true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE nombre = :nombre", nativeQuery=true)
    Hotel darHotel(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (nombre, tipo, ciudad, pais, internet) VALUES(hoteles_sequence.nextval, :nombre, :tipo, :ciudad, :pais, :internet)", nativeQuery=true)
    void insertarHotel(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("ciudad") String ciudad, @Param("pais") String pais, @Param("internet") Integer internet);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET  tipo = :tipo, ciudad = :ciudad, pais = :pais, internet = : internet WHERE id=:id", nativeQuery = true)
    void actualizarHotel(@Param("tipo") String tipo, @Param("ciudad") String ciudad, @Param("pais") String pais, @Param("internet") Integer internet);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id = :id", nativeQuery=true)
    void eliminarHotel(@Param("nombre") String nombre);
}
