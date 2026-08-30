# 👥 Pesquisa de Habitantes
 
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen?style=for-the-badge)
![License](https://img.shields.io/badge/licen%C3%A7a-MIT-blue?style=for-the-badge)
![Nível](https://img.shields.io/badge/n%C3%ADvel-iniciante-orange?style=for-the-badge)
 
Programa em Java que lê dados de habitantes de uma região (idade, sexo e salário) e calcula estatísticas sobre o grupo, como média salarial, faixa etária e a pessoa com o menor salário.
 
---
 
## 📋 Descrição
 
O programa lê, para cada habitante, três informações — idade, sexo (`M` ou `F`) e salário — repetindo a leitura indefinidamente até que uma **idade negativa** seja digitada, o que encerra a entrada de dados.
 
Cada pessoa lida é armazenada como um objeto da classe `Pessoa` dentro de uma `ArrayList<Pessoa>`, permitindo exibir a lista completa de habitantes cadastrados ao final da execução.
 
Ao final, o programa calcula e exibe:
- A **média dos salários** do grupo
- A **maior** e a **menor idade** do grupo
- A **quantidade de mulheres** com salário até R$ 1.500,00
- A **idade e o sexo** da pessoa com o **menor salário**
- A **lista completa** de todas as pessoas cadastradas
## 💻 Código
 
```java
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
```
 
## ▶️ Como executar
 
```bash
javac InformacoesDeHabitantes.java
java InformacoesDeHabitantes
```
 
Digite a idade, o sexo e o salário de cada pessoa, um de cada vez. Para encerrar a entrada de dados, digite **qualquer idade negativa** (ex: `-1`).
 
## 📤 Exemplo de saída
 
Com a entrada:
```
Idade: 13
Sexo (M/F): M
Salario: 600
Idade: 21
Sexo (M/F): M
Salario: 1700
Idade: -1
```
 
O programa mostra:
```
=== Resultados ===
Media dos salarios: R$ 1150,00
Maior idade: 21
Menor idade: 13
Mulheres com salario ate R$ 1500,00: 0
Pessoa com menor salario: 13 anos, sexo M (R$ 600,00)
 
=== Lista de Pessoas Cadastradas ===
Idade: 13 | Sexo: M | Salario: R$ 600,00
Idade: 21 | Sexo: M | Salario: R$ 1700,00
```
 
## 🧠 Conceitos praticados
 
- Laços de repetição com condição de parada (`while (true)` + `break`)
- Leitura de dados com `Scanner` (`nextInt`, `next`, `nextDouble`)
- Criação de classes próprias e construtores (`this`)
- Coleções genéricas (`ArrayList<Pessoa>`)
- Laço `for-each` para percorrer listas de objetos
- Formatação de saída com `printf` (`%d`, `%c`, `%.2f`, `%n`)
- Acumuladores e comparações para achar máximo/mínimo
## 🚀 Possíveis melhorias
 
- Tratar entradas inválidas (ex: letras no campo de idade ou salário) com `try/catch`.
- Permitir listar também o homem com maior salário, ou outras combinações.
- Ordenar a lista de pessoas por idade ou salário antes de exibir.
---
 
<p align="center">Feito com ☕ e Java</p>
 
