package java01s2;

import java.util.Scanner;

public class Rusa {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a,b;
        
        System.out.println("Digite el primer numero: ");
        a = in.nextInt();
        System.out.println("Digite el segundo numero: ");
        b = in.nextInt();
        
        int s = 0;
        
        while (a!=0) {            
            if (a%2 != 0){
                s = s+b;
            }
            a = a/2;
            b = b*2;
        }
        System.out.println("El resultado es: " + s);
    }
}
