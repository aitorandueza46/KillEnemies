package org.cuatrovientos;

import java.io.Serializable;
import java.util.ArrayList;

public class Enemy implements Character, Serializable {

    protected String nombre;
    protected int vida;
    protected int vidaMax;
    protected int dano;
    protected boolean jefe;

    public Enemy(String nombre, int vida, int dano) {
        this.nombre = nombre;
        this.vidaMax = vida;
        this.vida = vida;
        this.dano = dano;
        this.jefe = false;
    }

    @Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public String getName() {
        return nombre;
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

    public int getDano() {
        return dano;
    }

    public boolean esJefe() {
        return jefe;
    }

    public boolean esVencible(ArrayList<Character> personajes) {
        return true;
    }

    public int atacar() {
        System.out.println("  " + nombre + " contraataca con " + dano + " de daño");
        return dano;
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
