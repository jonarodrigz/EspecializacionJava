package java01s2;

import java.util.Scanner;

public class ISR {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double sueldo;
        System.out.println("Digite el sueldo: ");
        sueldo = s.nextDouble();
        double descuentos, isss, afp;
        if (sueldo < 1000) {
            isss = sueldo * 0.03;
        } else {
            isss = 30;
        }

        afp = sueldo * 0.0725;

        descuentos = afp + isss;

        double sueldoGravado = sueldo - descuentos;

        double isr;

        if (sueldoGravado >= 0.01 && sueldoGravado <= 472) {
            isr = 0;
        } else if (sueldoGravado >= 472.01 && sueldoGravado <= 895.24) {
            isr = (sueldoGravado - 472) * 0.1 + 17.67;
        } else if (sueldoGravado >= 895.25 && sueldoGravado <= 2038.10) {
            isr = (sueldoGravado - 895.24) * 0.2 + 60;
        } else {
            isr = (sueldoGravado - 2038.1) * 0.3 + 288.57;
        }
        System.out.printf("Sueldo: $ %.2f %s  \n", sueldo, "bruto");
        System.out.printf("Descuentos: $ %.2f \n", descuentos);
        System.out.printf("Sueldo Gravado: $ %.2f \n", sueldoGravado);
        System.out.printf("ISR: $ %.2f \n", isr);

    }
}
