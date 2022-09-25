package rh.model;

public abstract class Funcionario {
	
	private int id;
	private String nome;
	private String email;
	private int cargo;
	private float salario;
	
	public Funcionario(int id, String nome, String email, int cargo, float salario) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public Funcionario() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public void visualizar() {
		System.out.println("\n*************************************************************");
		System.out.println("Dados do funcionário");
		System.out.println("*************************************************************");
		System.out.println("Código do funcionário: " + this.id);
		System.out.println("Nome do funcionário: " + this.nome);
		System.out.println("E-mail do funcionário: " + this.email);
		System.out.println("Cargo do funcionário: " + this.cargo);
		System.out.println("Salário do funcionário: " + this.salario);
	}
	
	public abstract void aumentarSalario(float percentual);
	
}

