package uniandes.edu.co.proyecto.Repositorios;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Tienda;

public interface TiendaRepository extends JpaRepository<Tienda, String> {
    @Query(value = "SELECT * FROM tiendas", nativeQuery=true)
    Collection<Tienda> darTiendas();

    @Query(value = "SELECT * FROM tiendas WHERE nombre = :nombre", nativeQuery=true)
    Tienda darTienda(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO tiendas (nombre, tipo, hotel_nombre) VALUES(hoteles_sequence.nextval, :nombre, :tipo, :hotel_nombre))", nativeQuery=true)
    void insertarTienda(@Param("nombre") String nombre, @Param("tipo") String tipo, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE tiendas SET tipo = :tipo,  hotel_nombre = :hotel_nombre WHERE nombre=:nombre", nativeQuery = true)
    void actualizarTienda(@Param("tipo") String tipo, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM tiendas WHERE nombre = :nombre", nativeQuery=true)
    void eliminarTienda(@Param("nombre") String nombre);
    
}
