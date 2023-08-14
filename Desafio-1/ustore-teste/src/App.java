import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        List<Poligono> poligonos = new ArrayList<>();
        double areaTotal = 0;

        try {
            while (true) {
                System.out.print("Informe o número de lados do polígono (3 para triângulo, 4 para quadrado): ");
                int numLados = scanner.nextInt();

                if (numLados == 3 || numLados == 4) {
                    System.out.print("Informe o tamanho do lado do polígono (em cm): ");
                    double tamanhoLado = scanner.nextDouble();
                    Poligono poligono = new Poligono(numLados, tamanhoLado);
                    poligonos.add(poligono);
                    areaTotal += poligono.calcularArea();
                } else {
                    System.out.println("Número de lados não suportado.");
                }
                System.out.print("Se Deseja inserir outro polígono digite SIM :");
                String continuar = scanner.next();
                if (!continuar.equalsIgnoreCase("SIM")) {
                    break;
                }
            }
            poligonos.forEach(poligono -> {
                String nomePoligono = poligono.numLados == 3 ? "Triângulo" : "Quadrado";
                String areaPoligono = new DecimalFormat("#,##0.00").format(poligono.calcularArea());
                System.out
                        .println(nomePoligono + " de lado " + poligono.tamanhoLado + " cm e área " + areaPoligono
                                + " cm²");
            });

            String areaTotalFormatada = new DecimalFormat("#,##0.00").format(areaTotal);
            System.out.println("Área total " + areaTotalFormatada + " cm²");
        } catch (Exception e) {
            System.out.println("Entrada inválida. Tente novamente.");
        }
    }
}
