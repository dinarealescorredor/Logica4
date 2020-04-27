import javax.swing.*;
import java.util.*;

/**
 * funcionalidad basica de arrays
 */
public class Vector {
    int[] vectorX;
    int tam = 0;

    /**
     * Constructor de la clase vector
     */
    public Vector() {
        this.main();
    }

    private void main() {
        // ACA INICIALIZO LOS METODOS
        setup();
        init_array();
        intercambiarPos();
        inverter();
    }

    private void setup() {
        // manejo de errores
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del vector:");
        if(input == null){
            JOptionPane.showMessageDialog(null, "Adios");
            System.exit(0);
        }
        try {
            if (validate(input)) {
                this.tam = Integer.parseInt(input);
                this.vectorX = new int[this.tam];
            } else {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido entero");
                this.setup();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese un número valido entero");
            this.setup();
        }
    }

    private void init_array() {
        int seleccion = JOptionPane.showOptionDialog(
                null,
                "¿Quiere llenar el vector?",
                "Logica",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,    // null para icono por defecto.
                new Object[]{"Si", "No"},   // null para YES, NO y CANCEL
                "Si");

        if (seleccion == 0) {
            for (int i = 0; i < this.vectorX.length; i++) {
                String inputValue = JOptionPane.showInputDialog("Ingrese el valor de la posicion " + i);
                if (!inputValue.isBlank() && inputValue.matches("-?\\d+")) {
                    this.vectorX[i] = Integer.parseInt(inputValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    i = i - 1;
                }

                if (i + 1 < this.vectorX.length) {
                    int options = JOptionPane.showOptionDialog(
                            null,
                            "¿Quiere llenar el vector?",
                            "Logica",
                            JOptionPane.YES_NO_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,    // null para icono por defecto.
                            new Object[]{"Si", "No"},   // null para YES, NO y CANCEL
                            "Si");

                    if (options == 1) {
                        for (int j = i + 1; j < this.vectorX.length; j++) {
                            this.vectorX[j] = 0;
                        }
                        break;
                    }
                }
            }
            pintarVector( "vector ::::");
        } else if (seleccion == 1) {
            Random rnd = new Random();
            int hasta = 100;
            int desde = 0;

            for (int i = 0; i < this.vectorX.length; i++) {
                int numAleatorio = rnd.nextInt(hasta - desde + 1) + desde;
                this.vectorX[i] = numAleatorio;
            }
            pintarVector("vector :::");
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione si o no");
            this.init_array();
        }
    }


    private void pintarVector (String msg ) {
        System.out.println("\n");
        System.out.println(msg);
        for (int i = 0; i < vectorX.length; i++) {
            int pos = i + 1;
            System.out.println("El vector de la posicion " + pos + " tiene el valor de " + vectorX[i]);
        }
    }

    private void intercambiarPos() {
        String inputA = JOptionPane.showInputDialog("Ingrese el valor de la posición: A");
        String inputB = JOptionPane.showInputDialog("Ingrese el valor de la posición: B");

        if (validate(inputA) && validate(inputB)) {
            int x = Integer.parseInt(inputA) - 1;
            int y = Integer.parseInt(inputB) - 1;
            int posFinal = this.vectorX.length;

            if (x < posFinal && y < posFinal) {
                int dato;
                dato = this.vectorX[x];
                this.vectorX[x] = this.vectorX[y];
                this.vectorX[y] = dato;
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un número entre  1 y  " + posFinal);
                this.intercambiarPos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un número valido");
            this.intercambiarPos();
        }
        pintarVector("Intercambiar Posiciones :::");
    }

    private void inverter(){
        for(int i=0; i<this.vectorX.length/2; i++){
            int temp = vectorX[i];
            vectorX[i] = vectorX[vectorX.length -i -1];
            vectorX[vectorX.length -i -1] = temp;
        }
        pintarVector("Vector invertido :::");
    }

    private boolean validate(String input) {
        return !input.isBlank() && input.matches("-?[0-9]{0,10}");
    }
}
