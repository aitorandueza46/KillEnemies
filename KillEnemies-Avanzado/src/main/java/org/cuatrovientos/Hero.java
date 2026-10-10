package org.cuatrovientos;

import java.io.Serializable;

public class Hero implements Character, Serializable {

    private final String name;
    private int enemigosMatados;
    private int amigosDefendidos;

    public Hero(String name) {
        this.name = name;
    }

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    public void attack(Enemy enemy) {
        System.out.println("¡He atacado a un enemigo!");
        enemy.kill();
        enemigosMatados++;
    }

    public void attack(Friend friend) {
        System.out.println("¡He atacado a un amigo!");
    }

    public void defend(Friend friend) {
        System.out.println("¡He defendido a un amigo!");
        friend.heal();
        amigosDefendidos++;
    }

    public void defend(Enemy enemy) {
        System.out.println("¡He defendido a un enemigo!");
    }

    public int getEnemigosMatados() {
        return enemigosMatados;
    }

    public int getAmigosDefendidos() {
        return amigosDefendidos;
    }

}
