package java01s2;

import java.util.Scanner;


public class Dias {
    public static void main(String[] args) {
        int mes, annio;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite el mes: ");
        mes = in.nextInt();
        System.out.println("Digite el annio ");
        annio = in.nextInt();
        int dias;
        
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dias = 30;
                break;
            case 2:
                if((annio%4==0 && annio%100!=0) || (annio%4==0 && annio%400==0)){
                    dias = 29;
                }else {
                    dias = 28;
                }
            break;
            
            default:
                dias = 0;
                break;
        }
        System.out.println("El mes "+ mes + " tiene " + dias + " dias");
    }
}
