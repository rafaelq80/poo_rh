package rh.repository;

import rh.model.Colaborador;

public interface ColaboradorRepository {

	public Colaborador procurarPorId(int id);
	public void listarTodos();
	public void buscarPorId(int posicao);
	public void cadastrar(Colaborador funcionario);
	public void atualizar(Colaborador funcionario);
	public void deletar(int numero);

}

