package org.cuatrovientos;

import java.io.Serializable;

public class Hero implements Character, Serializable {

    private final Orden orden;
    private int vida;
    private int vidaMax;
    private int dano;
    private int enemigosMatados;
    private int amigosDefendidos;
    private int danoExtra;

    public Hero(Orden orden) {
        this.orden = orden;
        this.vidaMax = orden.getVida();
        this.vida = orden.getVida();
        this.dano = orden.getDano();
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return orden.getNombre();
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public int getVidaMax() {
        return vidaMax;
    }

    @Override
    public void recibirDano(int dano) {
        this.vida -= dano;
        if (this.vida < 0) {
            this.vida = 0;
        }
    }

    public int curar(int cantidad) {
        int antes = vida;
        vida += cantidad;
        if (vida > vidaMax) {
            vida = vidaMax;
        }
        return vida - antes;
    }

    public Orden getOrden() {
        return orden;
    }

    public int getDano() {
        return dano;
    }

    public int getDanoExtra() {
        return danoExtra;
    }

    public void addDanoExtra(int cantidad) {
        danoExtra += cantidad;
    }

    public void resetDanoExtra() {
        danoExtra = 0;
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
