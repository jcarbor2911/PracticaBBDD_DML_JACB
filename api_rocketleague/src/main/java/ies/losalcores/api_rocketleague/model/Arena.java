package ies.losalcores.api_rocketleague.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "arena")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arena {

    @Id
    @Column(name = "id_arena")
    private Long idArena;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tematica")
    private String tematica;

    @Column(name = "capacidad_jugadores")
    private Integer capacidadJugadores;

    @Column(name = "clima_visual")
    private String climaVisual;
}
