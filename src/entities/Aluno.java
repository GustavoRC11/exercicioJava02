package entities;

public class Aluno {

	private Integer id;
	private String nome;
	private String matricula;
	private String cpf;

	public Aluno() {

	}

	public Aluno(Integer id, String nome, String matricula, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.cpf = cpf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
