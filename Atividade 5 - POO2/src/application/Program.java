package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.Aluno;
import jdbc.AlunoJDBC;

public class Program {

    public static void main(String[] args) {

        try {

            int opcao = 0;
            Scanner console = new Scanner(System.in);

            do {
                System.out.println("\n####### Menu #######\n"
                                    + "\n1 - Cadastrar"
                                    + "\n2 - Listar"
                                    + "\n3 - Alterar"
                                    + "\n4 - Excluir"
                                    + "\n5 - Sair");
                System.out.println("\n\tOp��o:");
                opcao = Integer.parseInt(console.nextLine());

                if (opcao == 1) {

                    Aluno a = new Aluno();
                    AlunoJDBC acao = new AlunoJDBC();

                    System.out.println("\n ### Cadastrar Aluno ### \n\r");

                    System.out.print("Nome: ");
                    a.setNome(console.nextLine());

                    System.out.print("Sexo: ");
                    a.setSexo(console.nextLine());

                    System.out.print("Data de Nascimento (dd-mm-aaaa): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));

                    acao.salvar(a);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }
                
                if (opcao == 2) {
                    AlunoJDBC acao2 = new AlunoJDBC();
                    System.out.println("\n ### Listar Alunos ### \n");
                    System.out.printf("| %-3s | %-30s | %-7s | %-12s |\n", "ID", "NOME", "SEXO", "DT. NASC.");
                    for (Aluno aluno : acao2.listar()) {
                        System.out.printf("| %-3d | %-30s | %-7s | %-12s |\n", aluno.getId(), aluno.getNome(),
                                aluno.getSexo(), aluno.getDt_nasc());
                    }
                }
                
                if (opcao == 3) {
                    AlunoJDBC acao3 = new AlunoJDBC();
                    System.out.println("\n ### Alterar Aluno ### \n");
                    System.out.print("ID do Aluno: ");
                    int id = Integer.parseInt(console.nextLine());
                    Aluno a = new Aluno();
                    a.setId(id);
                    System.out.print("Novo Nome: ");
                    a.setNome(console.nextLine());
                    System.out.print("Novo Sexo: ");
                    a.setSexo(console.nextLine());
                    System.out.print("Nova Data de Nascimento (dd-mm-aaaa): ");
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    a.setDt_nasc(LocalDate.parse(console.nextLine(), formato));
                    acao3.alterar(a);
                    console.nextLine();
                    System.out.println("\n\n\n\n");
                }

                
                if (opcao == 4) {
                	//Irei fazer a exclusão comm base no ID
                    System.out.println("\n ### Excluir Aluno ### \n\r");
                    System.out.print("ID do aluno: ");
                    int id = Integer.parseInt(console.nextLine());

                    AlunoJDBC acao4 = new AlunoJDBC();
                    acao4.apagar(id);
                    System.out.println("\nAluno excluído com sucesso!\n");
                }
                
            } while (opcao != 5);

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}
