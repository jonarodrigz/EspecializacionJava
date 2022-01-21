package edu.formas.s5.ejercicio;


public class Trabajador extends Persona{
    
   private float sueldoMensual;
   private float descuentoIsss;
   private float descuentoAfp;
   private float descuentoIsr;
   private float totalDescuento;
  private  float totalPagar;

    public Trabajador() {
    }

    public float getSueldoMensual() {
        return sueldoMensual;
    }

    public void setSueldoMensual(float sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
        
        //Descuento Iss
        if(this.sueldoMensual<1000)
            this.descuentoIsss = this.sueldoMensual*0.03f;
        else
            this.descuentoIsss = 30;
        //Descuento AFP
        this.descuentoAfp = this.sueldoMensual * 0.0725f;
        
        //Descuento ISR
        float sueldoGravado = this.sueldoMensual - (this.descuentoIsss+this.descuentoAfp);
        
         if (sueldoGravado >= 0.01 && sueldoGravado <= 472) {
            this.descuentoIsr = 0;
        } else if (sueldoGravado >= 472.01 && sueldoGravado <= 895.24) {
            this.descuentoIsr = (sueldoGravado - 472f) * 0.1f + 17.67f;
        } else if (sueldoGravado >= 895.25 && sueldoGravado <= 2038.10) {
            this.descuentoIsr = (sueldoGravado - 895.24f) * 0.2f + 60f;
        } else {
            this.descuentoIsr = (sueldoGravado - 2038.1f) * 0.3f + 288.57f;
        }
        
         this.totalDescuento = this.descuentoIsss+this.descuentoAfp+this.descuentoIsr;
         this.totalPagar = this.sueldoMensual - this.totalDescuento;
    }

    public float getDescuentoIsss() {
        return descuentoIsss;
    }

    public float getDescuentoAfp() {
        return descuentoAfp;
    }

    public float getDescuentoIsr() {
        return descuentoIsr;
    }

    public float getTotalDescuento() {
        return totalDescuento;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

       
}
