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
                    if (tamanhoLado < 0) {
                        throw new Exception("Valores negativos não são suportados.");
                    }
                    Poligono poligono = new Poligono(numLados, tamanhoLado);
                    poligonos.add(poligono);
                    areaTotal += poligono.calcularArea();
                    System.out.println("Polígono adicionado com sucesso.\n");
                } else {
                    throw new Exception("Valor não suportado.");
                }
                System.out.print(
                        "Deseja inserir outro polígono ? \nS - Inserir novo polígono. \nN - Calcular areas. \n(S/N): ");
                String continuar = scanner.next();
                if (continuar.equalsIgnoreCase("N")) {
                    break;
                } else if (continuar.equalsIgnoreCase("S")) {
                    System.out.println("\nAdicione outro Poligono:");
                } else {
                    throw new Exception("Apenas S/N");
                }
            }
            poligonos.forEach(poligono -> {
                String nomePoligono = poligono.getNumLados() == 3 ? "Triângulo" : "Quadrado";
                String areaPoligono = new DecimalFormat("#,##0.00").format(poligono.calcularArea());
                System.out.println(
                        nomePoligono + " de lado " + poligono.getTamanhoLado() + " cm e área " + areaPoligono + " cm²");
            });

            String areaTotalFormatada = new DecimalFormat("#,##0.00").format(areaTotal);
            System.out.println("Área total: " + areaTotalFormatada + " cm²");
        } catch (Exception e) {
            System.out.println("Entrada inválida. " + (e.getMessage() != null ? e.getMessage() : ' ' ));
        }
    }
}
