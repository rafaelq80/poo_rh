package rh.repository;

import rh.model.Funcionario;

public interface FuncionarioRepository {

	public Funcionario procurarPorId(int id);
	public void listarTodos();
	public void buscarPorId(int posicao);
	public void cadastrar(Funcionario funcionario);
	public void atualizar(Funcionario funcionario);
	public void deletar(int numero);

}

