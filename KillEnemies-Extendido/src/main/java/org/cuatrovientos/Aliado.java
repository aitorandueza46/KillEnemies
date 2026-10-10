package org.cuatrovientos;

public class Aliado extends Friend {

    private final int danoExtra = 2;

    @Override
    public String getName() {
        return "Aliado";
    }

    public int getDanoExtra() {
        return danoExtra;
    }

}
