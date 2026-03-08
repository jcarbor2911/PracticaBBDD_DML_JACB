package ies.losalcores.api_rocketleague.controller;

import ies.losalcores.api_rocketleague.model.Arena;
import ies.losalcores.api_rocketleague.service.ArenaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/arenas")
public class ArenaController {

    private final ArenaService arenaService;

    public ArenaController(ArenaService arenaService) {
        this.arenaService = arenaService;
    }

    @GetMapping
    public List<Arena> listar() {
        return arenaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arena> obtenerPorId(@PathVariable Long id) {
        Arena arena = arenaService.obtenerPorId(id);

        if (arena == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(arena);
    }

    @PostMapping
    public ResponseEntity<Arena> crear(@RequestBody Arena arena) {
        Arena nuevaArena = arenaService.guardar(arena);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaArena);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arena> actualizar(@PathVariable Long id, @RequestBody Arena arena) {
        Arena arenaActualizada = arenaService.actualizar(id, arena);

        if (arenaActualizada == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(arenaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminada = arenaService.eliminar(id);

        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
