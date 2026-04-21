package controle;
import java.util.Locale; // Import para garantir o uso do ponto (.)
import java.util.Scanner;

public class DesafioWhile {

    public static void main(String[] args) {
        
        // Use Locale.US para aceitar 7.5 em vez de 7,5
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);
        
        int quantidadeDeNotas = 0;
        double nota = 0;
        double total = 0;
        
        while(nota != -1) {
            System.out.print("Informe a nota (ou -1 para sair): ");
            nota = entrada.nextDouble();
            
            if (nota <= 10 && nota >= 0) {
                total += nota;
                quantidadeDeNotas++;
            } else if(nota != -1) {
                System.out.println("Nota inválida! Digite valores entre 0 e 10.");
            }
        }
        
        // Evita erro de divisão por zero
        if (quantidadeDeNotas > 0) {
            double media = total / quantidadeDeNotas;
            System.out.printf("Média de %d nota(s) = %.2f%n", quantidadeDeNotas, media);
        } else {
            System.out.println("Nenhuma nota válida foi digitada.");
        }
        
        entrada.close();        
    }
}