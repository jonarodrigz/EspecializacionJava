package fm2ejerciciopracticos1;

public class Revista extends Publicacion{
    
    private int numeroRevista;

    public Revista(int codigo, String titulo, int anioPublicacion, int numeroRevista) {
        super(codigo, titulo, anioPublicacion);
        this.numeroRevista = numeroRevista;
    }

    @Override
    public int getTipoPublicacion() {
        return 1;
    }
    
}
