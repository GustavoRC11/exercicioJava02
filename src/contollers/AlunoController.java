package contollers;

import java.util.Scanner;

import entities.Aluno;
import repositories.AlunoRepository;

public class AlunoController {

	private Scanner scanner = new Scanner(System.in);

	public void cadastrarAluno() {

		try {

			System.out.println("\nCADASTRAR ALUNO: \n");

			System.out.println("\nID do aluno.......:\n");
			var id = Integer.parseInt(scanner.nextLine());

			System.out.println("\nNome do aluno......:");
			var nome = scanner.nextLine();

			System.out.println("\nMatrícula do aluno.....:");
			var matricula = scanner.nextLine();

			System.out.println("\nCPF do aluno...........:");
			var cpf = scanner.nextLine();

			var aluno = new Aluno(id, nome, matricula, cpf);

			var alunoRepository = new AlunoRepository();
			alunoRepository.inserir(aluno);

		}

		catch (Exception e) {
			System.out.println("\nFalha ao cadastrar aluno!");
			System.out.println(e.getMessage());

		}

	}

	public void atualizarAluno() {

		try {

			System.out.println("\nATUALIZAR ALUNO:\n");

			System.out.println("Informe o ID do aluno:.");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {

				System.out.println("\nDADOS DO ALUNO:");
				System.out.println("ID......:" + aluno.getId());
				System.out.println("NOME....:" + aluno.getNome());
				System.out.println("MATRÍCULA.....:" + aluno.getMatricula());
				System.out.println("CPF.....:" + aluno.getCpf());

				System.out.print("ALTERE O NOME.........: ");
				aluno.setNome(scanner.nextLine());
				System.out.print("ALTERE A MATRICULA........: ");
				aluno.setMatricula(scanner.nextLine());
				System.out.print("ALTERE O CPF...: ");
				aluno.setCpf(scanner.nextLine());

				alunoRepository.atualizar(aluno);

			}

			else {

				System.out.println("\nAluno não encontrado. Verifique o ID informado.");

			}

		}

		catch (Exception e) {
			System.out.println("\nFalha ao atualizar o aluno!");
			System.out.println(e.getMessage());

		}
	}

	public void excluirAluno() {

		try {

			System.out.println("\nEXCLUSÂO DE ALUNOS:\n");

			System.out.print("INFORME O ID DO ALUNO.: ");
			var id = Integer.parseInt(scanner.nextLine());

			var alunoRepository = new AlunoRepository();
			var aluno = alunoRepository.obterPorId(id);

			if (aluno != null) {
				System.out.println("\nDADOS DO PRODUTO:");
				System.out.println("ID........: " + aluno.getId());
				System.out.println("NOME......: " + aluno.getNome());
				System.out.println("MATRÍCULA.....: " + aluno.getMatricula());
				System.out.println("CPF: " + aluno.getCpf());
				System.out.println("");

				alunoRepository.excluir(aluno.getId());

			} else {
				System.out.println("\nAluno não encontrado. Verifique o ID informado.");

			}

		}
		catch (Exception e) {
			System.out.println("\nFalha ao excluir o aluno!");
			System.out.println(e.getMessage());

		}
	}
	
	public void consultarAluno() {
		
		try {
			
			System.out.println("\nCONSULTA DE ALUNOS:");
			
			var alunoRepository = new AlunoRepository();
			
			var lista = alunoRepository.consultar();
			
			for(Aluno aluno : lista) {
				
				System.out.println("ID.......:" + aluno.getId());
				System.out.println("NOME.....:" +aluno.getNome());
				System.out.println("MATRÍCULA......:" + aluno.getMatricula());
				System.out.println("CPF......:" + aluno.getCpf());
				
			}
			
		}
		
		catch(Exception e) {
			System.out.println("\nFalha ao consultar alunos!");
			System.out.println(e.getMessage());
			
			
		}
	}

}
