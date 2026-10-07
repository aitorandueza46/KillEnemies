package org.cuatrovientos;

public class Friend implements Character {

    @Override
    public boolean isEnemy() {
        return false;
    }

    @Override
    public String getName() {
        return "amigo";
    }

    public void heal() {
        System.out.println("¡Te he curado!");
    }

}