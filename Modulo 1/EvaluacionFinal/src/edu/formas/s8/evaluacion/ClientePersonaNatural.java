package edu.formas.s8.evaluacion;


public class ClientePersonaNatural extends Cliente{
    private String ocupacion;

    public ClientePersonaNatural() {
    }

    public ClientePersonaNatural(int id, String Nombre, String Apellido) {
        super(id, Nombre, Apellido);
    }
    
    public void setNumeroDui(String documento){
        super.documento = documento;
    }
    
    public String getDui(){
        return super.documento;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }
    
    
    @Override
    public int getTipoCliente() {
    return 2;
    }
    
}
