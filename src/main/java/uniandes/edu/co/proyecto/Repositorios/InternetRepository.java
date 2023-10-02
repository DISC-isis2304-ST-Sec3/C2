package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import uniandes.edu.co.proyecto.Modelo.Internet;

public interface InternetRepository extends JpaRepository<Internet, String>{
    @Query(value = "SELECT * FROM internets", nativeQuery=true)
    Collection<Internet> darInternet();

    @Query(value = "SELECT * FROM internets WHERE id = :id", nativeQuery=true)
    Internet darInternet(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO internets (id, costo, capacidad, hotel_nombre) VALUES(hoteles_sequence.nextval, :id, :costo, :capacidad, :hotel_nombre)", nativeQuery=true)
    void insertarInternet(@Param("id") Integer id, @Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE internets SET costo = :costo, capacidad = :capacidad, hotel_nombre = :hotel_nombre WHERE id=:id", nativeQuery = true)
    void actualizarInternet(@Param("costo") Integer costo, @Param("capacidad") Integer capacidad, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM internets WHERE id = :id", nativeQuery=true)
    void eliminarInternet(@Param("id") Integer id);    
}
