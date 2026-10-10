package org.cuatrovientos;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int largo = 54;
        int corto = 40;
        String bordeL = "┌" + "─".repeat(largo) + "┐";
        String bordeLm = "├" + "─".repeat(largo) + "┤";
        String bordeLb = "└" + "─".repeat(largo) + "┘";
        String bordeC = "┌" + "─".repeat(corto) + "┐";
        String bordeCm = "├" + "─".repeat(corto) + "┤";
        String bordeCb = "└" + "─".repeat(corto) + "┘";
        String fmtL = "│ %-" + (largo - 2) + "s │%n";
        String fmtC = "│ %-" + (corto - 2) + "s │%n";

        String[] portada = {
                "",
                "               K I L L   E N E M I E S",
                "                     Ev1 · PSP",
                "",
                "      O                           (x_x)",
                "     /|\\         vs                /|\\",
                "     / \\                           / \\",
                "",
                "[ H E R O E ]               [ E N E M I G O ]",
                "",
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░",
                ""
        };

        System.out.println(bordeL);
        for (String linea : portada) {
            System.out.printf(fmtL, linea);
        }
        System.out.println(bordeLb);

        Scanner teclado = new Scanner(System.in);

        File fichero = new File("partida.dat");
        ArrayList<Character> personajes = null;
        Hero heroe = null;
        boolean cargada = false;

        if (fichero.exists()) {

            Partida partidaGuardada = Partida.cargar(fichero);

            if (partidaGuardada != null) {
                personajes = partidaGuardada.getPersonajes();
                heroe = partidaGuardada.getHeroe();
                cargada = true;
            } else {
                System.out.println("no se pudo cargar la partida, se empieza una nueva");
            }

        }

        if (personajes == null || heroe == null || personajes.isEmpty()) {

            cargada = false;
            fichero.delete();

            personajes = new ArrayList<>();

            personajes.add(new Sanador());
            personajes.add(new Sanador());
            personajes.add(new Sanador());
            personajes.add(new Aliado());
            personajes.add(new Aliado());

            personajes.add(new Fusionado());
            personajes.add(new Fusionado());
            personajes.add(new Cantor());
            personajes.add(new Cantor());
            personajes.add(new Oyente());

            personajes.add(new Odium());

            Collections.shuffle(personajes);

            System.out.println(bordeL);
            System.out.printf(fmtL, "                E L I G E   H E R O E");
            System.out.println(bordeLm);
            Orden[] ordenes = Orden.values();
            for (int i = 0; i < ordenes.length; i++) {
                System.out.printf(fmtL, "  [" + (i + 1) + "] " + ordenes[i].getNombre()
                        + "   Vida " + ordenes[i].getVida() + "   Daño " + ordenes[i].getDano());
                System.out.printf(fmtL, "      " + ordenes[i].getPasiva());
                for (String linea : Arte.heroe(ordenes[i])) {
                    System.out.printf(fmtL, "    " + linea);
                }
            }
            System.out.println(bordeLb);

            System.out.println(bordeC);
            System.out.printf(fmtC, "  Opcion (1-" + ordenes.length + "):");
            System.out.println(bordeCb);
            System.out.print("> ");
            int eleccion = teclado.nextInt();
            if (eleccion < 1 || eleccion > ordenes.length) {
                eleccion = 1;
            }
            heroe = new Hero(ordenes[eleccion - 1]);

        }

        System.out.println(bordeC);
        if (cargada) {
            System.out.printf(fmtC, "  <= partida cargada de partida.dat");
        } else {
            System.out.printf(fmtC, "  => nueva partida");
        }
        System.out.println(bordeCb);

        int amigos = 0;
        int enemigos = 0;

        for (Character personaje : personajes) {
            if (personaje.isEnemy()) {
                enemigos++;
            } else {
                amigos++;
            }
        }

        System.out.println(bordeC);
        System.out.printf(fmtC, "  hay " + amigos + " amigos y " + enemigos + " enemigos");
        System.out.printf(fmtC, "    (^-^)      y      (x-x)");
        System.out.println(bordeCb);

        Juego juego = new Juego();
        boolean derrota = false;
        boolean victoria = false;
        int opcion = 0;

        while (!personajes.isEmpty() && opcion != 3 && !derrota && !victoria) {

            showCharacters(personajes);

            String[] menu = {
                    "",
                    "  A C C I O N E S   D E L   H E R O E",
                    "",
                    "  [1] Atacar",
                    "        ^",
                    "       /|\\",
                    "        |",
                    "     ===|===",
                    "        |",
                    "        o",
                    "",
                    "  [2] Defender",
                    "  +---------+",
                    "  |    +    |",
                    "  |         |",
                    "  |         |",
                    "   \\       /",
                    "    \\     /",
                    "     \\   /",
                    "      \\_/",
                    "",
                    "  [3] Salir",
                    "  +---+",
                    "  | O |",
                    "  |   |",
                    "  |   |",
                    "  +---+",
                    ""
            };

            System.out.println(bordeL);
            System.out.printf(fmtL, menu[1]);
            System.out.println(bordeLm);
            for (int i = 2; i < menu.length; i++) {
                System.out.printf(fmtL, menu[i]);
            }
            System.out.println(bordeLb);

            System.out.println(bordeC);
            System.out.printf(fmtC, "  Opcion (1, 2 o 3):");
            System.out.println(bordeCb);
            System.out.print("> ");
            opcion = teclado.nextInt();

            if (opcion == 1 || opcion == 2) {

                System.out.println(bordeC);
                System.out.printf(fmtC, "  Indice del personaje:");
                System.out.println(bordeCb);
                System.out.print("> ");
                int indice = teclado.nextInt();

                if (indice < 0 || indice >= personajes.size()) {

                    System.out.println(bordeC);
                    System.out.printf(fmtC, "  >: [ ]   indice no valido");
                    System.out.println(bordeCb);

                } else {

                    Character objetivo = personajes.get(indice);

                    if (opcion == 1) {

                        if (objetivo.isEnemy() && !((Enemy) objetivo).esVencible(personajes)) {

                            System.out.println(bordeC);
                            System.out.printf(fmtC, "  Odium aun no puede ser atacado");
                            System.out.printf(fmtC, "  quedan enemigos en pie");
                            System.out.println(bordeCb);

                        } else if (objetivo.isEnemy()) {

                            boolean gana = juego.combatir(heroe, (Enemy) objetivo);

                            if (gana) {

                                if (((Enemy) objetivo).esJefe()) {
                                    victoria = true;
                                }

                                personajes.remove(indice);
                                salirDeLista(bordeC, fmtC, bordeCb, "(x-x)");

                                if (!victoria && juego.jefeVencible(personajes)) {
                                    System.out.println(bordeL);
                                    System.out.printf(fmtL, "        O D I U M   D E S C I E N D E");
                                    System.out.printf(fmtL, "   no quedan enemigos: ya puedes atacarlo");
                                    System.out.println(bordeLb);
                                }

                            } else {

                                derrota = true;

                            }

                        } else {

                            heroe.attack((Friend) objetivo);
                            personajes.remove(indice);
                            salirDeLista(bordeC, fmtC, bordeCb, "(^-^)");

                        }

                    } else {

                        if (objetivo.isEnemy()) {

                            heroe.defend((Enemy) objetivo);

                            if (((Enemy) objetivo).esJefe()) {

                                System.out.println(bordeC);
                                System.out.printf(fmtC, "  Odium no puede duplicarse");
                                System.out.println(bordeCb);

                            } else {

                                personajes.add(indice + 1, objetivo);

                                System.out.println(bordeC);
                                System.out.printf(fmtC, "  el personaje se ha duplicado");
                                System.out.printf(fmtC, "    (x-x)  =>  (x-x) (x-x)");
                                System.out.println(bordeCb);

                            }

                        } else {

                            Friend amigo = (Friend) objetivo;
                            boolean consumido = amigo.seConsume();

                            juego.proteger(heroe, amigo, personajes);

                            if (consumido) {
                                System.out.println(bordeC);
                                System.out.printf(fmtC, "  el aliado se ha consumido");
                                System.out.printf(fmtC, "     (>_<)   ~ adios ~");
                                System.out.println(bordeCb);
                            }

                        }

                    }

                    boolean guardada = new Partida(personajes, heroe).guardar(fichero);
                    cajaGuardado(bordeC, fmtC, bordeCb, guardada);

                }

            } else if (opcion != 3) {

                System.out.println(bordeC);
                System.out.printf(fmtC, "  opcion no valida, usa 1, 2 o 3");
                System.out.println(bordeCb);

            }

        }

        teclado.close();

        if (personajes.isEmpty() || derrota || victoria) {
            fichero.delete();
        }

        String titulo;
        if (derrota) {
            titulo = "         D E R R O T A   D E L   H E R O E";
        } else if (victoria) {
            titulo = "         V I C T O R I A   D E L   H E R O E";
        } else {
            titulo = "         F I N   D E   L A   P A R T I D A";
        }

        String[] fin = {
                "",
                titulo,
                "",
                "                   _______________",
                "                  /               \\",
                "                 /  O           O  \\",
                "                 |       ___       |",
                "                 |      (o o)      |",
                "                  \\     '---'     /",
                "                 |    | | | | |    |",
                "                  '---------------'",
                ""
        };

        System.out.println(bordeL);
        for (String linea : fin) {
            System.out.printf(fmtL, linea);
        }
        System.out.printf(fmtL, "                enemigos matados:  " + heroe.getEnemigosMatados());
        System.out.printf(fmtL, "                amigos defendidos: " + heroe.getAmigosDefendidos());
        System.out.println(bordeLb);

    }

    static void showCharacters(ArrayList<Character> personajes) {

        int corto = 40;
        String bordeC = "┌" + "─".repeat(corto) + "┐";
        String bordeCm = "├" + "─".repeat(corto) + "┤";
        String bordeCb = "└" + "─".repeat(corto) + "┘";
        String fmtC = "│ %-" + (corto - 2) + "s │%n";

        System.out.println(bordeC);
        System.out.printf(fmtC, " L I S T A   D E   P E R S O N A J E S");
        System.out.println(bordeCm);
        for (int i = 0; i < personajes.size(); i++) {
            Character personaje = personajes.get(i);
            String tipo = personaje.isEnemy() ? "enemigo" : "amigo";
            String icono = personaje.isEnemy() ? "(x-x)" : "(^-^)";
            String nombre = i + ": " + tipo + " " + personaje.getName() + " " + icono;
            String vida = personaje.getVidaMax() > 0
                    ? "Vida " + personaje.getVida() + "/" + personaje.getVidaMax()
                    : "";
            System.out.printf("│ %-27s %10s │%n", nombre, vida);
        }
        System.out.println(bordeCb);

    }

    static void salirDeLista(String bordeC, String fmtC, String bordeCb, String cara) {

        System.out.println(bordeC);
        System.out.printf(fmtC, "  el personaje sale de la lista");
        System.out.printf(fmtC, "     " + cara + "   ~ adios ~");
        System.out.println(bordeCb);

    }

    static void cajaGuardado(String bordeC, String fmtC, String bordeCb, boolean guardada) {

        System.out.println(bordeC);
        if (guardada) {
            System.out.printf(fmtC, "  partida guardada en partida.dat");
            System.out.printf(fmtC, "     +-----+");
            System.out.printf(fmtC, "     | ### |");
            System.out.printf(fmtC, "     | # # |");
            System.out.printf(fmtC, "     +-----+");
        } else {
            System.out.printf(fmtC, "  no se pudo guardar la partida");
        }
        System.out.println(bordeCb);

    }

}
