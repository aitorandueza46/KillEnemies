package org.cuatrovientos;

public class Sanador extends Friend {

    private final int curacion = 6;

    @Override
    public String getName() {
        return "Sanador";
    }

    public int getCuracion() {
        return curacion;
    }

    @Override
    public void efecto(Hero heroe) {
        int total = curacion + heroe.getOrden().bonusCuracion();
        int curado = heroe.curar(total);
        System.out.println("┌" + "─".repeat(40) + "┐");
        System.out.printf("│ %-38s │%n", "¡Te he curado " + curado + " de vida!");
        System.out.printf("│ %-38s │%n", "Vida " + heroe.getVida() + "/" + heroe.getVidaMax());
        System.out.println("└" + "─".repeat(40) + "┘");
    }

}
