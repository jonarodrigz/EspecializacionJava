
package java01s2;

import java.util.Scanner;


public class Factorial {
    public static void main(String[] args) {
        int n,f;
        Scanner in = new Scanner(System.in);
        System.out.println("Digite un numero: ");
        n = in.nextInt();
        f = 1;
//        int i = 1;
//        
//        while (i <= n) {            
//            f = f*i;
//            i++;
//        }
        
//        for (int i=1; i<=n; i++){
//            f = f * i;
//        }
        int i =1;
        do {            
            f=f*i;
            i++;
        } while (i<=n);
        
        System.out.println("el factorial de " + n + " es: " + f);
    }
}
