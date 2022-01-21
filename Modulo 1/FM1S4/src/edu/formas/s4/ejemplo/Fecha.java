package edu.formas.s4.ejemplo;

public class Fecha {

    private int dia;
    private int mes;
    private int anio;

    public void asignarFecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anio = a;
    }

    public String obtenerFecha() {
        return this.dia + "/" + this.mes + "/" + this.anio;
    }

    public boolean esValida() {
        boolean esValida = false;
        if (this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) {
            if (this.dia > 0 && this.dia <= 30) {
                esValida = true;
            }
        } else {
            if (this.mes == 2) {
                //bisiesto
                if ((this.anio % 4 == 0 && this.anio % 100 != 0) || (this.anio % 4 == 0 && this.anio % 400 == 0)) {
                    if (this.dia > 0 && this.dia <= 29) {
                        esValida = true;
                    }
                } else {
                    if (this.dia > 0 && this.dia <= 28) {
                        esValida = true;
                    }
                }
            } else {
                if (this.mes > 0 && this.mes <= 12) {
                    if (this.dia > 0 && this.dia <= 31) {
                        esValida = true;
                    }
                }
            }
        }

        return esValida;
    }
}
