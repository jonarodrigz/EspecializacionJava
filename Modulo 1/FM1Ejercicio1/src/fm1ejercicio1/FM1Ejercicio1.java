
package fm1ejercicio1;

import edu.formas.s5.ejercicio.Trabajador;
import javax.swing.JOptionPane;


public class FM1Ejercicio1 {

     private static int menu() {
        int op = 0;
        String valores;
        valores = "Digite la Opcion \n";
        valores += "1. Agregar Trabajador a la Lista \n";
        valores += "2.Mostrar Planilla \n";
        valores += "3.Salir \n";
        op = Integer.parseInt(JOptionPane.showInputDialog(valores));
        return op;
    }
      private static Trabajador agregarTrabajador() {
          Trabajador trab = new Trabajador();
          int cod;
         String nom, ape;
         float sueldoMensual;
          cod = Integer.parseInt(JOptionPane.showInputDialog("Digite el Codigo: "));
        nom = JOptionPane.showInputDialog("Digite el nombre: ");
        ape = JOptionPane.showInputDialog("Digite el apellido: ");
        sueldoMensual = Float.parseFloat(JOptionPane.showInputDialog("Digite su sueldo Mensual"));
        
        trab.setCodigo(cod);
        trab.setNombre(nom);
        trab.setApellido(ape);
        trab.setSueldoMensual(sueldoMensual);
       
          return trab;
      }
      
        private static void mostrarLista(Trabajador lst[], int c) {
        if (c == 0) {
            JOptionPane.showMessageDialog(null, "La Lista esta vacia");
        } else {
            String cad = "Codigo | Nombres | Apellidos | SueldoMensual | DescuentoISSS | DescuentoAFP | DescuentoISR | TotalDescuento | TotalAPagar\n";
            for (int i = 0; i < c; i++) {
              cad += lst[i].getCodigo()+" | ";
              cad += lst[i].getNombre()+" | ";
              cad += lst[i].getApellido()+" | ";
              cad += lst[i].getSueldoMensual()+" | ";
              cad += lst[i].getDescuentoIsss()+" | ";
              cad += lst[i].getDescuentoAfp()+" | ";
              cad += lst[i].getDescuentoIsr()+" | ";
              cad += lst[i].getTotalDescuento()+" | ";
              cad += lst[i].getTotalPagar()+"\n ";
            }
            JOptionPane.showMessageDialog(null, cad);
        }
    }
      
    public static void main(String[] args) {
        // TODO code application logic here
        int TAM = 5;
        int opc;
        Trabajador lista[] = new Trabajador[TAM];
        int cont = 0;
        
         do {
            opc = menu();
            switch (opc) {
                case 1:
                    //Agregar Trabajador
                    if (cont < TAM) {
                        lista[cont] = agregarTrabajador();
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
