package rh.model;

public class Gerente extends Colaborador{
	
	private float bonificacao;

	public Gerente(int id, String nome, String email, int cargo, float salario, float bonificacao) {
		super(id, nome, email, cargo, salario);
		this.bonificacao = bonificacao;
	}

	public float getBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(float bonificacao) {
		this.bonificacao = bonificacao;
	}
	
	public void visualizar() {
		super.visualizar();
		System.out.println("Bonificação do gerente: " + this.bonificacao);
	}
	
	@Override
	public void aumentarSalario(float percentual) {
 		float bonus = 5.0f;
		this.setSalario(this.getSalario() * (1 + ((percentual + bonus) / 100)));
	}
	
}

