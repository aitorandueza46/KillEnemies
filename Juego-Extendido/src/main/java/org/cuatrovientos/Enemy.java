package org.cuatrovientos;

import java.io.Serializable;

public class Enemy implements Character, Serializable {

    @Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public String getName() {
        return "enemigo";
    }

    public void kill() {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "Ahhhggg, me mataste, bastardo!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "          .---.");
        System.out.printf("│ %-38s │%n", "         / o o \\");
        System.out.printf("│ %-38s │%n", "          \\ - /");
        System.out.printf("│ %-38s │%n", "         /|   |\\");
        System.out.printf("│ %-38s │%n", "          |_|_|");
        System.out.println("└" + "─".repeat(40) + "┘");
    }

}
