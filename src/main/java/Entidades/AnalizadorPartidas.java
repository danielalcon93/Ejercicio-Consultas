package Entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalizadorPartidas {
    static void main() {
    List<Partida> partidas = new ArrayList<>();

    partidas.add(new Partida(1, "Juan_Lopez", "CPU_Madrid", ModoJuego.PVP, "FC_Barcelona",
            3, 1, "12min", LocalDateTime.of(2026,4,
            1,19,30),120));

    partidas.add(new Partida(2, "Maria_Garcia", "Rafael_Torres", ModoJuego.EVENTO, "Real_Madrid",
                2, 2, "20min", LocalDateTime.of(2026,4,
                2,21,15),85));

    partidas.add(new Partida(3, "Carlos_Martin", "Equipo_IA", ModoJuego.LIGA, "Atletico_Madrid",
                1, 0, "12min", LocalDateTime.of(2026,4,
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

        IO.println("------------------------------");
    /* Consulta 2: Partidas por modo de juego*/
        //2.Contar cuántas partidas hay de cada modo (groupingBy).
    partidas.stream()
            .collect(Collectors.groupingBy(Partida::getModoJuego, Collectors.counting()))
            .forEach((c,v) -> IO.println(c + ": " + v + " Partidas"));

        IO.println("------------------------------");
    /* Consulta 3: Goles totales marcados*/
        //3.Suma de todos los golesLocal.
        int totalGoles = partidas.stream()
                .mapToInt(p -> p.getGolesLocal())
                .sum();
                IO.println("Total de goles marcados por los equipos Locales: " + totalGoles);

    /* Consulta 4: Mejor rival derrotado*/
        //4.Partida con más estrellas contra cada rival, ordenada por estrellas.
        IO.println("------------------------------");
        partidas.stream()
                .sorted(Comparator.comparing(Partida::getEstrellasGanadas).reversed())
                .limit(1)
                .forEach(System.out::println);

    /* Consulta 5: Media de estrellas por modo*/
        //5.Calcular averagingInt(estrellasGanadas) por modoJuego.
        IO.println("------------------------------");
        partidas.stream()
                .collect(Collectors.groupingBy(Partida::getModoJuego,
                                                Collectors.averagingInt(Partida::getEstrellasGanadas)))
                .forEach((c,v) -> IO.println(c + ": " + v + " Media de estrellas por modo de Juego"));

    /* Consulta 6: Partidas de más de 20 minutos*/
        //6.Filtrar duracion que contenga "20min" o "30min".
        IO.println("------------------------------");
        partidas.stream()
                .filter(p -> p.getDuracion().equals("20min") || p.getDuracion().equals("30min"))
                .forEach(System.out::println);

    /* Consulta 7: Equipos más usados*/
        //7. Los 5 equiposLocal con más apariciones.
        IO.println("------------------------------");
        Map<String, Long> count = partidas.stream()
                .collect(Collectors.groupingBy(Partida::getEquipoLocal, Collectors.counting()));
                 count.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                         .limit(5)
                         .forEach(System.out::println);

    /* Consulta 8: Peor racha (3+ derrotas seguidas)*/
        //8. Partidas perdidas ordenadas por fecha (golesLocal < golesVisitante).
        IO.println("------------------------------");
        partidas.stream()
                .filter(p -> p.getGolesLocal() < p.getGolesVisitante())
                .sorted(Comparator.comparing(Partida::getFecha))
                .forEach(System.out::println);


    /* Consulta 9: Evolución mensual*/
        //9. Agrupar por mes de fecha y contar victorias.
        IO.println("------------------------------");
        partidas.stream()
                .filter(p -> p.getGolesLocal() > p.getGolesVisitante())
                .collect(Collectors.groupingBy(p -> p.getFecha().getMonth(),Collectors.counting()))
                .forEach((c,v) -> IO.println(c + ": " + v + " Victorias en total"));

    }
}

