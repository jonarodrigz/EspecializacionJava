package fm1s4;

import edu.formas.s4.ejemplo.Estudiante;
import javax.swing.JOptionPane;

public class FM1S4 {

    private static int menu() {
        int op = 0;
        String valores;
        valores = "Digite la Opcion \n";
        valores += "1. Agregar Estudiante \n";
        valores += "2.Listar Estudiante \n";
        valores += "3.Salir \n";
        op = Integer.parseInt(JOptionPane.showInputDialog(valores));
        return op;
    }

    private static Estudiante agregarEstudiante() {
        Estudiante est = new Estudiante();
        int cod;
        String nom, ape;
        float n1, n2, n3;
        cod = Integer.parseInt(JOptionPane.showInputDialog("Digite el Codigo: "));
        nom = JOptionPane.showInputDialog("Digite el nombre: ");
        ape = JOptionPane.showInputDialog("Digite el apellido: ");
        n1 = Float.parseFloat(JOptionPane.showInputDialog("Digite la nota 1 : "));
        n2 = Float.parseFloat(JOptionPane.showInputDialog("Digite la nota 2 : "));
        n3 = Float.parseFloat(JOptionPane.showInputDialog("Digite la nota 3 : "));
        est.setCodigo(cod);
        est.setNombre(nom);
        est.setApellido(ape);
        est.setNotas(n1, n2, n3);
        return est;
    }

    private static void mostrarLista(Estudiante lst[], int c) {
        if (c == 0) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
        } else {
            String cad = "Codigo \tNombres \tApellidos \tPromedio\n";
            for (int i = 0; i < c; i++) {
                cad += lst[i].getCodigo() + " \t";
                cad += lst[i].getNombre() + " \t";
                cad += lst[i].getApellido() + " \t";
                cad += lst[i].getPromedio() + " \n";
            }
            JOptionPane.showMessageDialog(null, cad);
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        int TAM = 5;
        int opc;
        Estudiante lista[] = new Estudiante[TAM];
        int cont = 0;

        do {
            opc = menu();
            switch (opc) {
                case 1:
                    //Agregar Estudiantes
                    if (cont < TAM) {
                        lista[cont] = agregarEstudiante();
                        cont++;
                    } else {
                        JOptionPane.showMessageDialog(null, "La lista esta llena");
                    }
                    break;
                case 2:
                    //Mostrar lista
                    mostrarLista(lista, cont);
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Abandonando el Programa");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ERROR, opcion no definida");

                    break;
            }
        } while (opc != 3);
    }

}
