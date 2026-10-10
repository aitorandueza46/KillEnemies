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
        System.out.println("  ¡He atacado a un enemigo!");
        int danoReal = getDanoDeAtaque(enemy);
        enemy.recibirDano(danoReal);
        System.out.println("  " + enemy.getName() + " recibe " + danoReal
                + " de daño (Vida " + enemy.getVida() + "/" + enemy.getVidaMax() + ")");
        if (enemy.getVida() <= 0) {
            enemy.kill();
            enemigosMatados++;
        }
    }

    public int getDanoDeAtaque(Enemy enemy) {
        int total = dano + danoExtra;
        switch (orden) {
            case CORREDORES_DEL_VIENTO:
                total += 2;
                break;
            case ESQUIRLAS_DEL_CIELO:
                if (enemy.esJefe()) {
                    total += 2;
                }
                break;
            case BAILARINES_DEL_FILO:
                total += 1;
                break;
            case FORJADORES_DE_ALMAS:
                total += 3;
                break;
            case MOLDEADORES_DE_VOLUNTAD:
                if (vida * 2 > vidaMax) {
                    total += 2;
                }
                break;
            default:
                break;
        }
        return total;
    }

    public int reducirDano(int cantidad) {
        switch (orden) {
            case PORTADORES_DEL_POLVO:
            case BAILARINES_DEL_FILO:
            case GUARDIANES_DE_LA_PIEDRA:
                return Math.max(0, cantidad - 1);
            case TEJEDORES_DE_LUZ:
                return Math.max(0, cantidad - 2);
            default:
                return cantidad;
        }
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
