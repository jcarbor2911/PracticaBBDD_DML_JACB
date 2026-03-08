package ies.losalcores.api_rocketleague.service;

import ies.losalcores.api_rocketleague.model.Arena;
import ies.losalcores.api_rocketleague.repository.ArenaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {

    private final ArenaRepository arenaRepository;

    public ArenaService(ArenaRepository arenaRepository) {
        this.arenaRepository = arenaRepository;
    }

    public List<Arena> obtenerTodas() {
        return arenaRepository.findAll();
    }

    public Arena obtenerPorId(Long id) {
        return arenaRepository.findById(id).orElse(null);
    }

    public Arena guardar(Arena arena) {
        return arenaRepository.save(arena);
    }

    public Arena actualizar(Long id, Arena arenaActualizada) {
        Arena arena = arenaRepository.findById(id).orElse(null);

        if (arena == null) {
            return null;
        }

        arena.setNombre(arenaActualizada.getNombre());
        arena.setTematica(arenaActualizada.getTematica());
        arena.setCapacidadJugadores(arenaActualizada.getCapacidadJugadores());
        arena.setClimaVisual(arenaActualizada.getClimaVisual());

        return arenaRepository.save(arena);
    }

    public boolean eliminar(Long id) {
        if (!arenaRepository.existsById(id)) {
            return false;
        }

        arenaRepository.deleteById(id);
        return true;
    }
}
