package ies.losalcores.api_rocketleague.controller;

import ies.losalcores.api_rocketleague.model.Partida;
import ies.losalcores.api_rocketleague.service.PartidaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {

    private final PartidaService partidaService;

    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    @GetMapping
    public List<Partida> listar() {
        return partidaService.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> obtenerPorId(@PathVariable Long id) {
        Partida partida = partidaService.obtenerPorId(id);

        if (partida == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(partida);
    }

    @PostMapping
    public ResponseEntity<Partida> crear(@RequestBody Partida partida) {
        Partida nuevaPartida = partidaService.guardar(partida);

        if (nuevaPartida == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaPartida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> actualizar(@PathVariable Long id, @RequestBody Partida partida) {
        Partida partidaActualizada = partidaService.actualizar(id, partida);

        if (partidaActualizada == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(partidaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminada = partidaService.eliminar(id);

        if (!eliminada) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
