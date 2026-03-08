package ies.losalcores.api_rocketleague.service;

import ies.losalcores.api_rocketleague.model.Arena;
import ies.losalcores.api_rocketleague.model.Partida;
import ies.losalcores.api_rocketleague.repository.ArenaRepository;
import ies.losalcores.api_rocketleague.repository.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository partidaRepository;
    private final ArenaRepository arenaRepository;

    public PartidaService(PartidaRepository partidaRepository, ArenaRepository arenaRepository) {
        this.partidaRepository = partidaRepository;
        this.arenaRepository = arenaRepository;
    }

    public List<Partida> obtenerTodas() {
        return partidaRepository.findAll();
    }

    public Partida obtenerPorId(Long id) {
        return partidaRepository.findById(id).orElse(null);
    }

    public Partida guardar(Partida partida) {
        if (partida.getArena() == null || partida.getArena().getIdArena() == null) {
            return null;
        }

        Arena arena = arenaRepository.findById(partida.getArena().getIdArena()).orElse(null);

        if (arena == null) {
            return null;
        }

        partida.setArena(arena);
        return partidaRepository.save(partida);
    }

    public Partida actualizar(Long id, Partida partidaActualizada) {
        Partida partida = partidaRepository.findById(id).orElse(null);

        if (partida == null) {
            return null;
        }

        if (partidaActualizada.getArena() == null || partidaActualizada.getArena().getIdArena() == null) {
            return null;
        }

        Arena arena = arenaRepository.findById(partidaActualizada.getArena().getIdArena()).orElse(null);

        if (arena == null) {
            return null;
        }

        partida.setFechaHora(partidaActualizada.getFechaHora());
        partida.setDuracionMinutos(partidaActualizada.getDuracionMinutos());
        partida.setMarcadorFinal(partidaActualizada.getMarcadorFinal());
        partida.setModoJuego(partidaActualizada.getModoJuego());
        partida.setArena(arena);

        return partidaRepository.save(partida);
    }

    public boolean eliminar(Long id) {
        if (!partidaRepository.existsById(id)) {
            return false;
        }

        partidaRepository.deleteById(id);
        return true;
    }
}
