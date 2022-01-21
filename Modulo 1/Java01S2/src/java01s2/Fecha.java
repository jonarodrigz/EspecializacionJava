package java01s2;

import java.util.Scanner;


public class Fecha {
    public static void main(String[] args) {
        String cad1= "Hola";
        String cad2 = "hola";
        if (cad1.equals(cad2)){
        }
        char c = 'a';
        if (c == 'a') {
            System.out.println("Es igual");
        }
        
        Scanner in = new Scanner(System.in);
        int d, m, a, ndias;
        System.out.println("Digite el dia");
        d = in.nextInt();
        System.out.println("Digite el mes");
        m = in.nextInt();
        System.out.println("Digite el año");
        a = in.nextInt();
        System.out.println("Digite cantidad de dias ");
        ndias = in.nextInt();
        
        for(int i=0;i<ndias;i++){
            d++;
            if(d>getDiasPorMes(m, a)){
                m++;
                d=1;
            }
            if(m>12){
                a++;
                m=1;
            }
        }
        System.out.printf("La nueva fecha es %d/ %d/ %d/", d,m,a);
    }

    private static int getDiasPorMes(int mes, int annio) {
          switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
               return 31;
              
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
                
            case 2:
                if((annio%4==0 && annio%100!=0) || (annio%4==0 && annio%400==0)){
                    return 29;
                }else {
                    return 28;
                }
          
            
            default:
                return 0;
             
        }
      
    }
}
