package proceso;

public class Rusa {

    private int multiplicando;
    private int multiplicador;

    public Rusa() {
        this.multiplicador = 0;
        this.multiplicando = 0;
    }

    public Rusa(int n1, int n2) {
        this.multiplicador = n1;
        this.multiplicando = n2;
    }

    public int obtenerResultado() {
        int n1 = this.multiplicando;
        int n2 = this.multiplicador;

        int r = 0;

        while (n1 > 0) {
            if (n1 % 2 != 0) {
                r += n2;
            }
            n1 = n1 / 2;
            n2 = n2 * 2;

        }
        return r;
    }
}
