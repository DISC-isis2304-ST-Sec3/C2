package uniandes.edu.co.proyecto.Repositorios;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.Modelo.Acompañante;


public interface AcompañanteRepository extends JpaRepository<Acompañante, String>{
    @Query(value = "SELECT * FROM acompañantes", nativeQuery=true)
    Collection<Acompañante> darAcompañantes();

    @Query(value = "SELECT * FROM acompañantes WHERE nombre = :nombre", nativeQuery=true)
    Acompañante darAcompañante(@Param("idacompañante") int idacompañante);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO acompañantes (idacompañante, documento_cliente) VALUES(hoteles_sequence.nextval, :idacompañante, :documento_cliente)", nativeQuery=true)
    void insertarAcompañante(@Param("idacompañante") int idacompañante, @Param("documento_cliente") int documento_cliente);

    @Modifying
    @Transactional
    @Query(value = "Update INTO acompañantes (idacompañante, documento_cliente) WHERE idacompañante =: idacompañante", nativeQuery=true)
    void actualizarAcompañante( @Param("documento_cliente") int documento_cliente);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM acompañantes WHERE idacompañante = :idacompañante", nativeQuery=true)
    void eliminarAcompañante(@Param("idacompañante") String idacompañante);
}
