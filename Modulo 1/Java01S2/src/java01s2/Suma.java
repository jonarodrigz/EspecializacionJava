
package java01s2;

import java.util.Scanner;


public class Suma {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1, n2;
        
        System.out.println("Digite el primer numero: ");
        n1 = in.nextInt();
        System.out.println("Dige el segundo numero: ");
        n2 = in.nextInt();
        
        System.out.println("La suma es: " + (n1+n2));
    }
}
