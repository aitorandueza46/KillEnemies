package org.cuatrovientos;

public class Arte {

    private static final int ANCHO = 38;

    private static final String[] CUERPO = {
            "      (o o)",
            "     /|   |\\",
            "      |   |",
            "     / \\_/ \\"
    };

    public static String[] heroe(Orden orden) {

        String aura;

        switch (orden) {
            case CORREDORES_DEL_VIENTO:
                aura = "     ~~>  ~~>  ~~>";
                break;
            case ESQUIRLAS_DEL_CIELO:
                aura = "     \\  |  /";
                break;
            case PORTADORES_DEL_POLVO:
                aura = "     ^ ^ ^ ^ ^";
                break;
            case BAILARINES_DEL_FILO:
                aura = "     - | - | -";
                break;
            case OBSERVADORES_DE_LA_VERDAD:
                aura = "     * (O) *";
                break;
            case TEJEDORES_DE_LUZ:
                aura = "     * . * . *";
                break;
            case FORJADORES_DE_ALMAS:
                aura = "     [ ] [ ] [ ]";
                break;
            case MOLDEADORES_DE_VOLUNTAD:
                aura = "     T | T | T";
                break;
            case GUARDIANES_DE_LA_PIEDRA:
                aura = "     # # # # #";
                break;
            case FORJADORES_DEL_VINCULO:
                aura = "     ~o~ ~o~ ~o~";
                break;
            default:
                aura = "";
                break;
        }

        String[] figura = new String[1 + CUERPO.length];
        figura[0] = aura;
        System.arraycopy(CUERPO, 0, figura, 1, CUERPO.length);
        return figura;
    }

    public static String[] odium() {
        return new String[] {
                "      \\  |  /",
                "       \\ | /",
                "     <( o o )>",
                "      /|   |\\",
                "       | ^ |",
                "      / \\ / \\"
        };
    }

    public static void imprimir(String[] figura) {
        System.out.println("┌" + "─".repeat(ANCHO + 2) + "┐");
        for (String linea : figura) {
            System.out.printf("│ %-" + ANCHO + "s │%n", linea);
        }
        System.out.println("└" + "─".repeat(ANCHO + 2) + "┘");
    }

}
