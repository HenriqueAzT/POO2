package view;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import model.entities.Disciplina;
import model.dao.DisciplinaDAO;
import model.dao.DisciplinaDAOImp;
import model.db.DB;

public class TelaDisciplina {
    
	private static DisciplinaDAO disciplinaDao = new DisciplinaDAOImp(DB.getConexao());




    public static Scanner menuDisciplina(Scanner console) throws ParseException {
        int opcao = 0;
        do {
            System.out.println("\n\n### Menu Disciplina ###");
            System.out.println("    =========================");
            System.out.println("    |     1 - Cadastrar    |");
            System.out.println("    |     2 - Alterar      |");
            System.out.println("    |     3 - Excluir      |");
            System.out.println("    |     4 - Listar       |");
            System.out.println("    |     0 - Voltar       |");
            System.out.println("    =========================");
            System.out.print("    Opção -> ");
            opcao = console.nextInt();
            console.nextLine();

            switch (opcao) {
                case 1:
                    cadastrar(console);
                    break;
                case 2:
                    alterar(console);
                    break;
                case 3:
                    excluir(console);
                    break;
                case 4:
                    listar(console);
                    break;
                case 0:
                    System.out.println("    Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("    Opção Inválida!");
            }
        } while (opcao != 0);
        return console;
    }

    private static void cadastrar(Scanner console) {
        System.out.println("\n\n### Cadastro de Disciplina ###");
        Disciplina disciplina = new Disciplina();

        System.out.print("    Nome da Disciplina: ");
        disciplina.setNomeDisciplina(console.nextLine());

        System.out.print("    Carga Horária: ");
        disciplina.setCargaHoraria(console.nextInt());
        console.nextLine();

        disciplinaDao.insert(disciplina);
        System.out.println("    Disciplina cadastrada com sucesso!");
        console.nextLine();
    }

    private static void alterar(Scanner console) {
        System.out.println("\n\n### Alteração de Disciplina ###");
        System.out.print("    ID da Disciplina: ");
        int id = console.nextInt();
        console.nextLine();

        Disciplina disciplina = disciplinaDao.findById(id);
        if (disciplina != null) {
            System.out.print("    Novo Nome da Disciplina: ");
            disciplina.setNomeDisciplina(console.nextLine());

            System.out.print("    Nova Carga Horária: ");
            disciplina.setCargaHoraria(console.nextInt());
            console.nextLine();

            disciplinaDao.update(disciplina);
            System.out.println("    Disciplina alterada com sucesso!");
        } else {
            System.out.println("    Disciplina não encontrada!");
        }
        console.nextLine();
    }

    private static void excluir(Scanner console) {
        System.out.println("\n\n### Exclusão de Disciplina ###");
        System.out.print("    ID da Disciplina: ");
        int id = console.nextInt();
        console.nextLine();

        Disciplina disciplina = disciplinaDao.findById(id);
        if (disciplina != null) {
            disciplinaDao.deleteById(id);
            System.out.println("    Disciplina excluída com sucesso!");
        } else {
            System.out.println("    Disciplina não encontrada!");
        }
        console.nextLine();
    }

    private static void listar(Scanner console) {
        List<Disciplina> disciplinas = disciplinaDao.findAll();

        System.out.println("\n\n### Listagem de Disciplinas ###");
        System.out.println("    ===============================================");
        System.out.println("    |     ID\tNome\t\t\tCarga Horária");
        for (Disciplina disciplina : disciplinas) {
            String id = String.format("%-5d", disciplina.getIdDisciplina());
            String nome = String.format("%-30s", disciplina.getNomeDisciplina());
            String cargaHoraria = String.format("%-15d", disciplina.getCargaHoraria());
            System.out.println("    |     " + id + nome + cargaHoraria);
        }
        System.out.println("    ===============================================");
        console.nextLine();
    }

}
