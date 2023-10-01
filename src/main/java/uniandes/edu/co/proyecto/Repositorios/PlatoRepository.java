package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Habitacion;
import uniandes.edu.co.proyecto.Modelo.Plato;

public interface PlatoRepository extends JpaRepository<Plato, Integer>{
    @Query(value = "SELECT * FROM platos", nativeQuery=true)
    Collection<Plato> darPlatos();

    @Query(value = "SELECT * FROM platos WHERE id = :id", nativeQuery=true)
    Plato darPlato(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO platos (id, nombre, costo, restaurante) VALUES(hoteles_sequence.nextval, :id, :nombre, :costo, :restaurante)", nativeQuery=true)
    void insertarPlato(@Param("id") Integer id, @Param("nombre") String nombre, @Param("costo") Integer costo, @Param("restaurante") String retaurante);

    @Modifying
    @Transactional
    @Query(value = "UPDATE platos SET nombre = :nombre, costo = :costo, restaurante = :restaurante WHERE id = :id", nativeQuery = true)
    void actualizarPlato(@Param("nombre") String nombre, @Param("costo") Integer costo, @Param("restaurante") String restaurante);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM platos WHERE id = :id", nativeQuery=true)
    void eliminarPlato(@Param("id") Integer id);
}
