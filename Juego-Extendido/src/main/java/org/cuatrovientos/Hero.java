package org.cuatrovientos;

import java.io.Serializable;

public class Hero implements Character, Serializable {

    private int enemigosMatados;
    private int amigosDefendidos;

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return "heroe";
    }

    public void attack(Enemy enemy) {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡He atacado a un enemigo!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "          ^");
        System.out.printf("│ %-38s │%n", "         /|\\");
        System.out.printf("│ %-38s │%n", "          |");
        System.out.printf("│ %-38s │%n", "       ===|===");
        System.out.printf("│ %-38s │%n", "          |");
        System.out.printf("│ %-38s │%n", "          o");
        System.out.println("└" + "─".repeat(40) + "┘");
        enemy.kill();
        enemigosMatados++;
    }

    public void attack(Friend friend) {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡He atacado a un amigo!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "        (@_@)");
        System.out.printf("│ %-38s │%n", "         /|\\");
        System.out.printf("│ %-38s │%n", "         / \\");
        System.out.println("└" + "─".repeat(40) + "┘");
    }

    public void defend(Friend friend) {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡He defendido a un amigo!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "  +---------+");
        System.out.printf("│ %-38s │%n", "  |    +    |");
        System.out.printf("│ %-38s │%n", "  |         |");
        System.out.printf("│ %-38s │%n", "  |         |");
        System.out.printf("│ %-38s │%n", "   \\       /");
        System.out.printf("│ %-38s │%n", "    \\     /");
        System.out.printf("│ %-38s │%n", "     \\   /");
        System.out.printf("│ %-38s │%n", "      \\_/");
        System.out.println("└" + "─".repeat(40) + "┘");
        friend.heal();
        amigosDefendidos++;
    }

    public void defend(Enemy enemy) {
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡He defendido a un enemigo!");
        System.out.printf("│ %-38s │%n", "");
        System.out.printf("│ %-38s │%n", "  +---------+");
        System.out.printf("│ %-38s │%n", "  |    +    |");
        System.out.printf("│ %-38s │%n", "  |         |");
        System.out.printf("│ %-38s │%n", "   \\       /");
        System.out.printf("│ %-38s │%n", "    \\     /");
        System.out.printf("│ %-38s │%n", "      \\_/");
        System.out.printf("│ %-38s │%n", "     (x-x)");
        System.out.println("└" + "─".repeat(40) + "┘");
    }

    public int getEnemigosMatados() {
        return enemigosMatados;
    }

    public int getAmigosDefendidos() {
        return amigosDefendidos;
    }

}
