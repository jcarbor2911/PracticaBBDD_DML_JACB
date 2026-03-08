package ies.losalcores.api_rocketleague.repository;

import ies.losalcores.api_rocketleague.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {

    @Query("select p from Partida p")
    List<Partida> findAllJPQL();

    @Query("select p from Partida p where p.modoJuego = :modo")
    List<Partida> findByModoJuegoJPQL(@Param("modo") String modoJuego);

    @Query("select p from Partida p where p.duracionMinutos >= :duracion")
    List<Partida> findByDuracionMinimaJPQL(@Param("duracion") Integer duracionMinutos);

    @Query("select p from Partida p where p.arena.idArena = :idArena")
    List<Partida> findByArenaJPQL(@Param("idArena") Long idArena);

    @Query("select p from Partida p where p.marcadorFinal = :marcador")
    List<Partida> findByMarcadorJPQL(@Param("marcador") String marcadorFinal);

    @Transactional
    @Modifying
    @Query("delete from Partida p where p.idPartida = :id")
    int deletePartidaJPQL(@Param("id") Long id);
}
