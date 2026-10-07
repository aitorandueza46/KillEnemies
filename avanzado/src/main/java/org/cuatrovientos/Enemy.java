package org.cuatrovientos;

public class Enemy implements Character {

    @Override
    public boolean isEnemy() {
        return true;
    }

    @Override
    public String getName() {
        return "enemigo";
    }

    public void kill() {
        System.out.println("Ahhhggg, me mataste, bastardo!");
    }

}