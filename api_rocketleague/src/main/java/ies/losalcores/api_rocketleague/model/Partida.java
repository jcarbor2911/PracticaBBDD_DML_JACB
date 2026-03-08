package ies.losalcores.api_rocketleague.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "partida")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    @Id
    @Column(name = "id_partida")
    private Long idPartida;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "duracion_minutos")
    private Integer duracionMinutos;

    @Column(name = "marcador_final")
    private String marcadorFinal;

    @Column(name = "modo_juego")
    private String modoJuego;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_arena")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Arena arena;
}
