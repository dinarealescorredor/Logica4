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
        //intercambiarPos();
        intercambiar();
    }

    private void setup() {
        // manejo de errores
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del vector:");
        try {
            if(!input.isBlank()  && input.matches("-?[0-9]{0,10}")) {
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
                new Object[] { "Si", "No"},   // null para YES, NO y CANCEL
                "Si");

        if (seleccion  == 0) {
            for (int i = 0; i < this.vectorX.length; i++) {
                String inputValue = JOptionPane.showInputDialog("Ingrese el valor de la posicion "+ i);
                if(!inputValue.isBlank()  && inputValue.matches("-?\\d+")) {
                    this.vectorX[i] =  Integer.parseInt(inputValue);
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    i =  i -1;
                }

                if(i+1 < this.vectorX.length) {
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
            pintarVector();
         } else if (seleccion == 1) {
            Random rnd = new Random();
            int hasta = 100;
            int desde = 0;

            for (int i = 0; i < this.vectorX.length; i++) {
                int numAleatorio = rnd.nextInt(hasta - desde + 1) + desde;
                this.vectorX[i] = numAleatorio;
            }
            pintarVector();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione si o no");
            this.init_array();
        }
    }


    private void pintarVector() {
        for (int i = 0; i < vectorX.length; i++) {
            System.out.println("El vector de la posicion " + i + " tiene el valor de " + vectorX[i]);
        }
    }

    private void intercambiar(){
       // String m = JOptionPane.showInputDialog("Anyone there?");
        //System.out.println(m);


    }

    private void intercambiarPos(){
        int posFinal = vectorX.length + 1;
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese el numero de la posicion 1: ");
        while (!in.hasNextInt()) {
            System.out.println("Ingrese un número valido");
            System.out.println("Ingrese el numero de la posicion 1: ");
            in.nextLine();
        }

        Scanner in2 = new Scanner(System.in);
        System.out.println("Ingrese el numero de la posicion 2: ");
        while (!in2.hasNextInt()) {
            System.out.println("Ingrese un número valido");
            System.out.println("Ingrese el numero de la posicion 2: ");
        }

        int pos1 = in.nextInt();
        int pos2 = in2.nextInt();
        if ( pos1 <= posFinal && pos1>0 && pos2 <= posFinal && pos2>0){
            System.out.println("estoy bien");
        } else {
            System.out.printf("Por favor ingrese un numero entre 1 y "+ posFinal);
            in.nextLine();
        }




       /* int dato;
        dato = this.vectorX[x];
        this.vectorX[x] =  this.vectorX[y];
        this.vectorX[y] = dato;*/
    }


}
