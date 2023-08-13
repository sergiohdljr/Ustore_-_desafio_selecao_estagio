
public class Poligono {
    protected int numLados;
    protected double tamanhoLado;

    public Poligono(int numLados, double tamanhoLado) {
        this.numLados = numLados;
        this.tamanhoLado = tamanhoLado;
    }



    public double calcularArea() {
        if (numLados == 3) {
            return (Math.sqrt(3) / 4) * tamanhoLado * tamanhoLado;
        } else if (numLados == 4) {
            return tamanhoLado * tamanhoLado;
        } else {
            return 0;
        }
    }

}
