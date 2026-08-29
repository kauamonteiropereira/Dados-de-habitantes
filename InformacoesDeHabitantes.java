import java.util.ArrayList;
import java.util.Scanner;

public class InformacoesDeHabitantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int idade;
        char sexo;
        double salario;

        double somaSalarios = 0;
        int quantidadePessoas = 0;

        int maiorIdade = Integer.MIN_VALUE;
        int menorIdade = Integer.MAX_VALUE;

        int mulheresAte1500 = 0;

        double menorSalario = Double.MAX_VALUE;
        int idadeMenorSalario = 0;
        char sexoMenorSalario = ' ';

        ArrayList<Pessoa> pessoas = new ArrayList<>();

        while (true) {
            System.out.print("Idade: ");
            idade = sc.nextInt();
            if (idade < 0) {
                break;
            }
            System.out.print("Sexo (M/F): ");
            sexo = sc.next().charAt(0);
            sexo = Character.toUpperCase(sexo);

            System.out.print("Salario: ");
            salario = sc.nextDouble();

            somaSalarios += salario;
            quantidadePessoas++;
            pessoas.add(new Pessoa(idade, sexo, salario));

            if (idade > maiorIdade) {
                maiorIdade = idade;
            }
            if (idade < menorIdade) {
                menorIdade = idade;
            }
            if (sexo == 'F' && salario <= 1500.0) {
                mulheresAte1500++;
            }
            if (salario < menorSalario) {
                menorSalario = salario;
                idadeMenorSalario = idade;
                sexoMenorSalario = sexo;
            }
        }

        System.out.println("\n=== Resultados ===");

        if (quantidadePessoas == 0) {
            System.out.println("Nenhum dado foi informado.");
        } else {
            double media = somaSalarios / quantidadePessoas;

            System.out.printf("Media dos salarios: R$ %.2f%n", media);
            System.out.println("Maior idade: " + maiorIdade);
            System.out.println("Menor idade: " + menorIdade);
            System.out.println("Mulheres com salario ate R$ 1500,00: " + mulheresAte1500);
            System.out.printf("Pessoa com menor salario: %d anos, sexo %c (R$ %.2f)%n",
                    idadeMenorSalario, sexoMenorSalario, menorSalario);
        }

        System.out.println("\n=== Lista de Pessoas Cadastradas ===");

        for (Pessoa p : pessoas) {
            System.out.printf("Idade: %d | Sexo: %c | Salario: R$ %.2f%n",
                    p.idade, p.sexo, p.salario);
        }
    }
}

class Pessoa {
    int idade;
    char sexo;
    double salario;

    Pessoa(int idade, char sexo, double salario) {
        this.idade = idade;
        this.sexo = sexo;
        this.salario = salario;
    }
}