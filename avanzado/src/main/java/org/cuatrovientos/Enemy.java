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
        System.out.println("Ahhhggg, me mataste, bastardo!");
    }

}