package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Planconsumo;

public interface PlanconsumoRepositry extends JpaRepository<Planconsumo, Integer> {
    
    @Query(value = "SELECT * FROM planesconsumo", nativeQuery=true)
    Collection<Planconsumo> darPlanesconsumo();

    @Query(value = "SELECT * FROM planesconsumo WHERE id = :id", nativeQuery=true)
    Planconsumo darPlanconsumo(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planesconsumo (id, tiempo, tipo, precio, promocion, beneficio, hotel_nombre) VALUES(hoteles_sequence.nextval, :id, :tiempo, :tipo, :precio, :promocion, :beneficio, :hotel_nombre)", nativeQuery=true)
    void insertarPlanconsumo(@Param("id") Integer id, @Param("tiempo") Integer tiempo, @Param("tipo") String tipo, @Param("precio") Integer precio, @Param("promocion") String promocion, @Param("beneficio") String beneficio, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE planesconsumo SET tiempo = :tiempo, tipo = :tipo, precio = :precio, promocion = :promocion, beneficio = :beneficio, hotel_nombre = :hotel_nombre WHERE id=:id", nativeQuery = true)
    void actualizarPlanconsumo(@Param("tiempo") Integer tiempo, @Param("tipo") String tipo, @Param("precio") Integer precio, @Param("promocion") String promocion, @Param("beneficio") String beneficio, @Param("hotel_nombre") String hotel_nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM planesconsumo WHERE id = :id", nativeQuery=true)
    void eliminarPlanconsumo(@Param("id") Integer id);
    
}
