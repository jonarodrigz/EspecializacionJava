package fm1s3;

public class FM1S3 {


    public static void main(String[] args) {
        Fecha ob1;
        ob1 = new Fecha();
        ob1.asignarFecha(10, 10, 2021);
        
        System.out.println("Fecha" + ob1.obtenerFecha());
    }
    
}
