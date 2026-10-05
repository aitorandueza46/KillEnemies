package org.cuatrovientos;

import java.util.ArrayList;
import java.util.Collections;

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

        for (Character personaje : personajes) {
            if (personaje.isEnemy()) {
                ((Enemy) personaje).kill();
            }
        }




        
    }

}