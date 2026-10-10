package org.cuatrovientos;

import java.io.Serializable;

public class Friend implements Character, Serializable {

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return "amigo";
    }

    public void heal() {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡Te he curado!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "      ___");
        System.out.printf("│ %-38s │%n", "      | |");
        System.out.printf("│ %-38s │%n", "     (o o)");
        System.out.printf("│ %-38s │%n", "      \\_/");
        System.out.println("└" + "─".repeat(40) + "┘");
    }

}
