package Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AnalizadorPartidas {
    static void main() {
    List<Partida> partidas = new ArrayList<>();

    partidas.add(new Partida(1, "Juan_Lopez", "CPU_Madrid", ModoJuego.PVP, "FC_Barcelona",
            3, 1, "12 Min", LocalDateTime.of(2026,4,
            1,19,30),120));

    partidas.add(new Partida(2, "Maria_Garcia", "Rafael_Torres", ModoJuego.EVENTO, "Real_Madrid",
                2, 2, "20 Min", LocalDateTime.of(2026,4,
                2,21,15),85));

    partidas.add(new Partida(3, "Carlos_Martin", "Equipo_IA", ModoJuego.LIGA, "Atletico_Madrid",
                1, 0, "12 Min", LocalDateTime.of(2026,4,
                3,18,45),150));

    partidas.add(new Partida(4, "Lucia_Fernandez", "CPU_Sevilla", ModoJuego.PVP, "Sevilla_FC",
            4, 2, "15min", LocalDateTime.of(2026,4,
            4,20,10),110));

    partidas.add(new Partida(5, "David_Ruiz", "Andres_Gomez", ModoJuego.LIGA, "Valencia_CF",
                0, 1, "12min", LocalDateTime.of(2026,4,
                5,17,25),60));

    partidas.add(new Partida(6, "Elena_Sanchez", "CPU_Betis", ModoJuego.EVENTO, "Real_Betis",
                3, 3, "18min", LocalDateTime.of(2026,4,
                5,22,40),95));

    partidas.add(new Partida(7, "Jorge_Moreno", "Pedro_Herrera", ModoJuego.PVP, "Villarreal_CF",
                2, 0, "14min", LocalDateTime.of(2026,4,
                6,19,5),130));

    partidas.add(new Partida(8, "Paula_Diaz", "CPU_Atletico", ModoJuego.LIGA, "Atletico_Madrid",
                1, 2, "12min", LocalDateTime.of(2026,4,
                6,21,30),70));

    partidas.add(new Partida(9, "Sergio_Navarro", "Luis_Castro", ModoJuego.EVENTO, "RC_Celta",
                5, 3, "20min", LocalDateTime.of(2026,4,
                7,18,20),160));

    partidas.add(new Partida(10, "Ana_Romero", "CPU_Valencia", ModoJuego.PVP, "Valencia_CF",
                2, 1, "13min", LocalDateTime.of(2026,4,
                7,20,55),105));


    /* Consulta 1: Victorias del jugador*/
    //1.Mostrar todas las partidas ganadas (golesLocal > golesVisitante).
    partidas.stream()
            .filter(p -> p.getGolesLocal() > p.getGolesVisitante())
            .forEach(System.out::println);

    IO.println("---------------------");
    /* Consulta 2: Partidas por modo de juego*/
        //2.Contar cuántas partidas hay de cada modo (groupingBy).
    partidas.stream()
            .collect(Collectors.groupingBy(Partida::getModoJuego, Collectors.counting()))
            .forEach((c,v) -> IO.println(c + ": " + v + " Partidas"));

    IO.println("---------------------");
    /* Consulta 3: Goles totales marcados*/
        //3.Suma de todos los golesLocal.
        partidas.stream()


    }
}

