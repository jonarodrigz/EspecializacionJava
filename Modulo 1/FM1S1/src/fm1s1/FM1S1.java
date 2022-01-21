package fm1s1;

import javax.swing.JOptionPane;


public class FM1S1 {

 
    public static void main(String[] args) {
    /* ---------------- Ejercicio 1 Hola Mundo---------------------- */
//        System.out.println("Hola Mundo");
        
    /* ---------------- Ejercicio 2 Suma de dos numeros---------------------- */
//        int num1, num2;
//        
//        num1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero"));
//        num2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero"));
//        
//        JOptionPane.showMessageDialog(null, "El Resultado es: " + (num1+num2));
        
    /* ---------------- Ejercicio 3 Dias del Mes---------------------- */
    
    
    /* ---------------- Ejercicio 4 Factorial for & while---------------------- */
    //Factorial For
    int factorial, resultado = 1;
    factorial = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero factorial que desea obtener"));
    
//        for (int i = 1; i <= factorial; i++) {
//            resultado = i * resultado;
//        }
//        
//        JOptionPane.showMessageDialog(null, "El factorial de " + factorial + " es " + resultado);
//    
         int cont = 1;
         while (cont <= factorial) {              
         resultado = cont * resultado;
         cont++;
        }
    
        JOptionPane.showMessageDialog(null, "El factorial de " + factorial + " es " + resultado);
    }
    
}
