package ies.losalcores.api_rocketleague.repository;

import ies.losalcores.api_rocketleague.model.Arena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaRepository extends JpaRepository<Arena, Long> {

    @Query("select a from Arena a")
    List<Arena> findAllJPQL();

    @Query("select a from Arena a where a.idArena between 1 and 5")
    List<Arena> findPrimerasCincoJPQL();

    @Query("select a from Arena a where a.tematica = :tematica")
    List<Arena> findByTematicaJPQL(@Param("tematica") String tematica);

    @Query("select a from Arena a where a.climaVisual = :clima")
    List<Arena> findByClimaVisualJPQL(@Param("clima") String clima);

    @Query("select a from Arena a where a.capacidadJugadores >= :capacidad")
    List<Arena> findByCapacidadMinimaJPQL(@Param("capacidad") Integer capacidad);

    default Arena insertarArena(Arena arena) {
        return save(arena);
    }
}
