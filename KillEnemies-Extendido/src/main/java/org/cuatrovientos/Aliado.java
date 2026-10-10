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

    @Override
    public void efecto(Hero heroe) {
        int total = danoExtra + heroe.getOrden().bonusAliado();
        heroe.addDanoExtra(total);
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡El aliado me da +" + total + " de daño!");
        System.out.printf("│ %-38s │%n", "Daño extra acumulado: " + heroe.getDanoExtra());
        System.out.println("└" + "─".repeat(40) + "┘");
    }

    @Override
    public boolean seConsume() {
        return true;
    }

}
