
public class Poligono {
    private int numLados;
    private double tamanhoLado;

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

    public int getNumLados() {
        return numLados;
    }

    public double getTamanhoLado() {
        return tamanhoLado;
    }

    public void setNumLados(int numLados) {
        this.numLados = numLados;
    }

    public void setTamanhoLado(double tamanhoLado) {
        this.tamanhoLado = tamanhoLado;
    }

}
