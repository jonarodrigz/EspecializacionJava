package fm2ejerciciopracticos1;

public class Libro extends Publicacion implements Prestable{
    
    private boolean estadoPrestamo;
    

    public Libro(int codigo, String titulo, int anioPublicacion) {
        super(codigo, titulo, anioPublicacion);
    }

    @Override
    public int getTipoPublicacion() {
        return 2;
    }

    @Override
    public void prestar() {
        
    }

    @Override
    public void devolver() {
        
    }

    @Override
    public boolean prestado() {
        
        return this.estadoPrestamo; 
    }
    
}
