package edu.formas.s8.evaluacion;


public class ClientePersonaJuridica extends Cliente{
    private String registro;

    public ClientePersonaJuridica() {
    }

    public ClientePersonaJuridica(int id, String Nombre, String Apellido) {
        super(id, Nombre, "");
    }
    
    public void setNit(String documento) {
        super.documento = documento;
    }
    
    public String getNit() {
        return super.documento;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }
    
     

    @Override
    public int getTipoCliente() {
        return 1;
    }
}
