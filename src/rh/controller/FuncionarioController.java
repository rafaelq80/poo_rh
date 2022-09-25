package rh.controller;

import java.util.ArrayList;

import rh.model.Funcionario;
import rh.repository.FuncionarioRepository;

public class FuncionarioController implements FuncionarioRepository{

	private ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	
	public FuncionarioController() {
		this.listaFuncionarios = new ArrayList<Funcionario>();
	}
	
	@Override
	public void cadastrar(Funcionario funcionario) {
		funcionario.setId(gerarId());
		listaFuncionarios.add(funcionario);
		System.out.println("\nFuncionário código: " + funcionario.getId() + " foi criado com sucesso!");
	}

	@Override
	public void listarTodos() {
		for (Funcionario funcionario : listaFuncionarios) {
			funcionario.visualizar();
		}
	}
	
	@Override
	public void buscarPorId(int id) {
		
		Funcionario funcionario = procurarPorId(id);
		
		if (funcionario != null)
			funcionario.visualizar();
		else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
		
	}
	
	@Override
	public void atualizar(Funcionario funcionario) {

		Funcionario buscaFuncionario = procurarPorId(funcionario.getId());
		
		if (buscaFuncionario != null) {
			listaFuncionarios.set(listaFuncionarios.indexOf(buscaFuncionario), funcionario);
			System.out.println("\nFuncionário código: " + funcionario.getId() + " atualizado com sucesso!");
		}else
			System.out.println("\nFuncionário código: " + funcionario.getId() + " não encontrado!");
	}
	
	@Override
	public void deletar(int id) {
		
		Funcionario funcionario = procurarPorId(id);
		
		if (funcionario != null) {
			if(listaFuncionarios.remove(funcionario) == true)
				System.out.println("\nFuncionário código: " + id + " deletado com sucesso!");
		}else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
		
	}
	
	@Override
	public Funcionario procurarPorId(int id) {
			
		for (Funcionario funcionario : listaFuncionarios) {
			if (funcionario.getId() == id) {
				return funcionario;
			}
		}
		
		return null;
		
	}
	
	public int gerarId() {
		return listaFuncionarios.size() + 1;
	}
	
	public void calcularAumento(int id, float percentual) {
		
		Funcionario funcionario = procurarPorId(id);
		
		if (funcionario != null) {
			funcionario.aumentarSalario(percentual);
			System.out.println("\nO novo salário do Funcionário código: " + id 
					+ " é: R$ " + funcionario.getSalario());
		}else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
	}
}

