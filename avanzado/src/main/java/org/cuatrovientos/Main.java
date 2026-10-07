package org.cuatrovientos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Character> personajes = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            personajes.add(new Friend());
        }

        for (int i = 0; i < 5; i++) {
            personajes.add(new Enemy());
        }

        Collections.shuffle(personajes);

        int amigos = 0;
        int enemigos = 0;

        for (Character personaje : personajes) {
            if (personaje.isEnemy()) {
                enemigos++;
            } else {
                amigos++;
            }
        }

        System.out.println("hay " + amigos + " amigos y " + enemigos + " enemigos");

        Hero heroe = new Hero();
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;

        while (!personajes.isEmpty() && opcion != 3) {

            for (int i = 0; i < personajes.size(); i++) {
                System.out.println("el personaje " + i + " es un " + personajes.get(i).getName());
            }

            System.out.println("1. Atacar");
            System.out.println("2. Defender");
            System.out.println("3. Salir");
            System.out.println("elige opcion(1,2,3)");
            opcion = teclado.nextInt();

            if (opcion == 1 || opcion == 2) {

                System.out.println("elige indice");
                int indice = teclado.nextInt();

                if (indice < 0 || indice >= personajes.size()) {

                    System.out.println("indice no valido");

                } else {

                    Character objetivo = personajes.get(indice);

                    if (opcion == 1) {
                        if (objetivo.isEnemy()) {
                            heroe.attack((Enemy) objetivo);
                        } else {
                            heroe.attack((Friend) objetivo);
                        }
                        personajes.remove(indice);
                    } else {
                        if (objetivo.isEnemy()) {
                            heroe.defend((Enemy) objetivo);
                            personajes.add(indice + 1, objetivo);
                        } else {
                            heroe.defend((Friend) objetivo);
                        }
                    }

                }

            } else if (opcion != 3) {

                System.out.println("opcion no valida");

            }

        }

        teclado.close();

        System.out.println("--- fin de la partida ---");

        for (int i = 0; i < personajes.size(); i++) {
            System.out.println("el personaje " + i + " es un " + personajes.get(i).getName());
        }

        System.out.println("enemigos matados: " + heroe.getEnemigosMatados());
        System.out.println("amigos defendidos: " + heroe.getAmigosDefendidos());

    }

}