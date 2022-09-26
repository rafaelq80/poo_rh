package rh.model;

public class Vendedor extends Colaborador{
	
	private float comissao;
	
	public Vendedor(int id, String nome, String email, int cargo, float salario, float comissao) {
		super(id, nome, email, cargo, salario);
		this.comissao = comissao;
	}

	public float getComissao() {
		return comissao;
	}

	public void setComissao(float comissao) {
		this.comissao = comissao;
	}

	public void visualizar() {
		super.visualizar();
		System.out.println("Comissão do vendedor: " + this.comissao);
	}

	@Override
	public void aumentarSalario(float percentual) {
		this.setSalario(this.getSalario() * (1 + percentual / 100));
	}
	
	
}

