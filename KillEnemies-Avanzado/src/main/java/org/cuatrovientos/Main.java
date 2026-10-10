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

        File fichero = new File("partida.dat");
        ArrayList<Character> personajes = null;
        Hero heroe = null;

        if (fichero.exists()) {

            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
                personajes = (ArrayList<Character>) entrada.readObject();
                heroe = (Hero) entrada.readObject();
                System.out.println("partida cargada de partida.dat");
            } catch (Exception e) {
                System.out.println("no se pudo cargar la partida, se empieza una nueva");
            }

        }

        if (personajes == null || heroe == null || personajes.isEmpty()) {

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

                    try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
                        salida.writeObject(personajes);
                        salida.writeObject(heroe);
                        System.out.println("partida guardada");
                    } catch (IOException e) {
                        System.out.println("no se pudo guardar la partida");
                    }

                }

            } else if (opcion != 3) {

                System.out.println("opcion no valida");

            }

        }

        teclado.close();

        if (personajes.isEmpty()) {
            fichero.delete();
        }

        System.out.println("--- fin de la partida ---");

        for (int i = 0; i < personajes.size(); i++) {
            System.out.println("el personaje " + i + " es un " + personajes.get(i).getName());
        }

        System.out.println("enemigos matados: " + heroe.getEnemigosMatados());
        System.out.println("amigos defendidos: " + heroe.getAmigosDefendidos());

    }

}