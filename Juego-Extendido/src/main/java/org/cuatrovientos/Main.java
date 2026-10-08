package org.cuatrovientos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

        File fichero = new File("partida.dat");
        ArrayList<Character> personajes = null;
        Hero heroe = null;
        boolean cargada = false;

        if (fichero.exists()) {

            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
                personajes = (ArrayList<Character>) entrada.readObject();
                heroe = (Hero) entrada.readObject();
                cargada = true;
            } catch (Exception e) {
                System.out.println("no se pudo cargar la partida, se empieza una nueva");
            }

        }

        if (personajes == null || heroe == null || personajes.isEmpty()) {

            cargada = false;
            fichero.delete();

            personajes = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                personajes.add(new Friend());
            }

            for (int i = 0; i < 5; i++) {
                personajes.add(new Enemy());
            }

            Collections.shuffle(personajes);

            heroe = new Hero();

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

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (!personajes.isEmpty() && opcion != 3) {

            System.out.println(bordeC);
            System.out.printf(fmtC, " L I S T A   D E   P E R S O N A J E S");
            System.out.println(bordeCm);
            for (int i = 0; i < personajes.size(); i++) {
                String frase = "el personaje " + i + " es un " + personajes.get(i).getName();
                String icono = personajes.get(i).isEnemy() ? "(x-x)" : "(^-^)";
                System.out.printf("│ %-31s %6s │%n", frase, icono);
            }
            System.out.println(bordeCb);

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

                        if (objetivo.isEnemy()) {
                            heroe.attack((Enemy) objetivo);
                        } else {
                            heroe.attack((Friend) objetivo);
                        }

                        personajes.remove(indice);

                        System.out.println(bordeC);
                        System.out.printf(fmtC, "  el personaje sale de la lista");
                        System.out.printf(fmtC,
                                "     " + (objetivo.isEnemy() ? "(x-x)" : "(^-^)") + "   ~ adios ~");
                        System.out.println(bordeCb);

                    } else {

                        if (objetivo.isEnemy()) {
                            heroe.defend((Enemy) objetivo);
                            personajes.add(indice + 1, objetivo);

                            System.out.println(bordeC);
                            System.out.printf(fmtC, "  el personaje se ha duplicado");
                            System.out.printf(fmtC, "    (x-x)  =>  (x-x) (x-x)");
                            System.out.println(bordeCb);
                        } else {
                            heroe.defend((Friend) objetivo);
                        }

                    }

                    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
                        salida.writeObject(personajes);
                        salida.writeObject(heroe);

                        System.out.println(bordeC);
                        System.out.printf(fmtC, "  partida guardada en partida.dat");
                        System.out.printf(fmtC, "     +-----+");
                        System.out.printf(fmtC, "     | ### |");
                        System.out.printf(fmtC, "     | # # |");
                        System.out.printf(fmtC, "     +-----+");
                        System.out.println(bordeCb);

                    } catch (IOException e) {

                        System.out.println(bordeC);
                        System.out.printf(fmtC, "  no se pudo guardar la partida");
                        System.out.println(bordeCb);

                    }

                }

            } else if (opcion != 3) {

                System.out.println(bordeC);
                System.out.printf(fmtC, "  opcion no valida, usa 1, 2 o 3");
                System.out.println(bordeCb);

            }

        }

        teclado.close();

        if (personajes.isEmpty()) {
            fichero.delete();
        }

        String[] fin = {
                "",
                "         F I N   D E   L A   P A R T I D A",
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

}
