package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Planconsumo;
import uniandes.edu.co.proyecto.Modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    @Query(value = "SELECT * FROM productos", nativeQuery=true)
    Collection<Producto> darProducto();

    @Query(value = "SELECT * FROM productos WHERE id = :id", nativeQuery=true)
    Planconsumo darProductos(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos (id, nombre, precio, id_super) VALUES(hoteles_sequence.nextval, :id, :nombre, :precio, :id_super)", nativeQuery=true)
    void insertarProducto(@Param("id") Integer id, @Param("nombre") String nombre, @Param("precio") Integer precio, @Param("id_super") Integer id_super);

    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, precio = :precio, id_super = :id_super WHERE id=:id", nativeQuery = true)
    void actualizarProducto(@Param("nombre") String nombre, @Param("precio") Integer precio, @Param("id_super") Integer id_super);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id", nativeQuery=true)
    void eliminarProducto(@Param("id") String id);
    
}
