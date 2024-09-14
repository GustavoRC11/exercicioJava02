package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Aluno;
import factories.ConnectionFactory;

public class AlunoRepository {

	public void inserir(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("INSERT INTO aluno(id, nome, matricula, cpf) VALUES(?,?,?,?)");

			statement.setObject(1, aluno.getId());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getMatricula());
			statement.setString(4, aluno.getCpf());

			statement.execute();

			connection.close();

			System.out.println("\nALUNO CADASTRADO COM SUCESSO!");

		}

		catch (Exception e) {
			System.out.println("\nFalha ao cadastrar aluno.");
			System.out.println(e.getMessage());

		}
	}

	public void atualizar(Aluno aluno) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("UPDATE aluno SET id=?, nome=?, matricula=?, WHERE cpf=?");

			statement.setInt(1, aluno.getId());
			statement.setString(2, aluno.getNome());
			statement.setString(3, aluno.getMatricula());
			statement.setString(4, aluno.getCpf());

			statement.execute();

			connection.close();

			System.out.println("\nALUNO ATUALIZADO COM SUCESSO.");

		}

		catch (Exception e) {
			System.out.println("\nFalha ao atualizar aluno!");
			System.out.println(e.getMessage());
		}

	}

	public void excluir(Integer id) {

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("DELETE FROM aluno WHERE id=?");
			statement.setObject(1, id);
			statement.execute();

			connection.close();

			System.out.println("\nALUNO EXCLUIDO COM SUCESSO!");

		}

		catch (Exception e) {

			System.out.println("\nFalha ao excluir aluno!");
			System.out.println(e.getMessage());

		}

	}

	public List<Aluno> consultar() {

		var lista = new ArrayList<Aluno>();

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("SELECT id, nome, matricula, cpf FROM aluno ORDER BY nome");

			var result = statement.executeQuery();

			while (result.next()) {

				var aluno = new Aluno();
				aluno.setId(result.getInt("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));

				lista.add(aluno);
			}
			connection.close();
		}

		catch (Exception e) {

			System.out.println("\nFalha ao consultar aluno.");
			System.out.println(e.getMessage());

		}

		return lista;
	}

	public Aluno obterPorId(int id) {

		Aluno aluno = null;

		try {

			var connection = ConnectionFactory.getConnection();

			var statement = connection.prepareStatement("SELECT id,nome, matricula,cpf FROM aluno WHERE id=?");
			statement.setObject(1, id);

			var result = statement.executeQuery();

			if (result.next()) {

				aluno = new Aluno();
				aluno.setId(result.getInt("id"));
				aluno.setNome(result.getString("nome"));
				aluno.setMatricula(result.getString("matricula"));
				aluno.setCpf(result.getString("cpf"));

			}

			connection.close();

		}

		catch (Exception e) {

			System.out.println("\nFalha ao consultar por id.");
			System.out.println(e.getMessage());

		}

		return aluno;

	}

}
