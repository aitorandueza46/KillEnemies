package org.cuatrovientos;

import java.util.ArrayList;

public class Odium extends Enemy {

    public Odium() {
        super("Odium", 40, 5);
        this.jefe = true;
    }

    @Override
    public boolean esVencible(ArrayList<Character> personajes) {
        for (Character personaje : personajes) {
            if (personaje.isEnemy() && personaje != this) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void kill() {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡Odium ha sido destruido!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "        \\ | /");
        System.out.printf("│ %-38s │%n", "       -- * --");
        System.out.printf("│ %-38s │%n", "        / | \\");
        System.out.println("└" + "─".repeat(40) + "┘");
    }

}
