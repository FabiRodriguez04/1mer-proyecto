/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra1clase;

import javax.swing.JOptionPane;

/**
 *
 * @author Fabian
 */
import javax.swing.JOptionPane;

public class Parqueo123 {

    private String[][] nivel1;
    private String[][] nivel2;
    private String[][] nivel3;

    public Parqueo123() {
        nivel1 = new String[4][5];
        nivel2 = new String[5][5];
        nivel3 = new String[6][5];
        Niveles();
    }

    private void Niveles() {
        // Nivel 1
        nivel1[0] = new String[]{"O", "D", "O", "O", "O"};
        nivel1[1] = new String[]{"O", "O", "O", "O", "O"};
        nivel1[2] = new String[]{"O", "O", "D", "O", "O"};
        nivel1[3] = new String[]{"E", "E", "E", "O", "O"};

        // Nivel 2
        nivel2[0] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[1] = new String[]{"O", "D", "O", "O", "O"};
        nivel2[2] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[3] = new String[]{"O", "O", "O", "O", "O"};
        nivel2[4] = new String[]{"E", "E", "E", "O", "O"};

        // Nivel 3
        nivel3[0] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[1] = new String[]{"O", "D", "O", "O", "O"};
        nivel3[2] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[3] = new String[]{"O", "O", "O", "O", "O"};
        nivel3[4] = new String[]{"O", "O", "D", "O", "O"};
        nivel3[5] = new String[]{"E", "E", "E", "O", "O"};
    }

    public void MostrarParqueo() {
        String imprimirNiveles = "A continuación se mostrarán los 3 niveles de parqueos disponibles\n"
                + "Nivel 1:\n" + mostrar(nivel1) + "\n"
                + "Nivel 2:\n" + mostrar(nivel2) + "\n"
                + "Nivel 3:\n" + mostrar(nivel3);

        JOptionPane.showMessageDialog(null, imprimirNiveles);
    }

    private String mostrar(String[][] nivel) {
        String mostrarLosNiveles = "";
        for (int i = 0; i < nivel.length; i++) {
            for (int j = 0; j < nivel[i].length; j++) {
                mostrarLosNiveles = mostrarLosNiveles + "| " + nivel[i][j] + " ";
            }
            mostrarLosNiveles = mostrarLosNiveles + "|\n";
        }
        return mostrarLosNiveles;
    }

    public void ReservarEspacio() {
        boolean continuar = true;

        while (continuar) {
            int nivel = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de parqueo que desea (1-2-3)"));

            // Validar que el nivel sea correcto antes de continuar
            if (nivel < 1 || nivel > 3) {
                JOptionPane.showMessageDialog(null, "Número de nivel incorrecto. Intente nuevamente.");
                continue; // Regresa al inicio del while y vuelve a preguntar
            }

            String[][] ParqueoSeleccionado;

            // Seleccionar el nivel correcto
            if (nivel == 1) {
                ParqueoSeleccionado = nivel1;
            } else if (nivel == 2) {
                ParqueoSeleccionado = nivel2;
            } else {
                ParqueoSeleccionado = nivel3;
            }

            // Mostrar el nivel seleccionado antes de pedir la fila y la columna
            String nivelSeleccionado = "Nivel " + nivel + ":\n" + mostrar(ParqueoSeleccionado);
            JOptionPane.showMessageDialog(null, nivelSeleccionado);

            int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila en la que desea reservar el espacio")) - 1;
            int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna en la que desea reservar el espacio")) - 1;

            // Verificar si la fila y columna están dentro del rango del nivel seleccionado
            if (fila < 0 || fila >= ParqueoSeleccionado.length || columna < 0 || columna >= ParqueoSeleccionado[0].length) {
                JOptionPane.showMessageDialog(null, "Fila o columna fuera de rango. Intente nuevamente.");
                continue;
            }

            String estado = ParqueoSeleccionado[fila][columna];
            if (estado.equals("O")) {
                ParqueoSeleccionado[fila][columna] = "P"; // para reservar el espacio
                JOptionPane.showMessageDialog(null, "Reserva exitosa");
            } else if (estado.equals("D") || estado.equals("E")) {
                JOptionPane.showMessageDialog(null, "No se puede reservar en este espacio");
            } else {
                JOptionPane.showMessageDialog(null, "El espacio seleccionado no está disponible");
            }

            /// Preguntar si desea hacer otra reserva
        String OtroEspacio = JOptionPane.showInputDialog("¿Desea reservar otro espacio?");
            if (!OtroEspacio.equalsIgnoreCase("Si")) {
                continuar = false;
                JOptionPane.showMessageDialog(null, "¡Gracias por usar el sistema de reservas!");
            }
        }
    }

}
