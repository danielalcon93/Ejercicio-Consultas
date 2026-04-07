package Entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString

public class Partida {

    private int id;
    private String jugador;
    private String rival;
    private ModoJuego modoJuego;
    private String equipoLocal;
    private int golesLocal;
    private int golesVisitante;
    private String duracion;
    private LocalDateTime fecha;
    private int estrellasGanadas;
}
