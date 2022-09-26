package rh.controller;

import java.util.ArrayList;

import rh.model.Colaborador;
import rh.repository.ColaboradorRepository;

public class ColaboradorController implements ColaboradorRepository{

	private ArrayList<Colaborador> listacolaboradors = new ArrayList<Colaborador>();
	
	public ColaboradorController() {
		this.listacolaboradors = new ArrayList<Colaborador>();
	}
	
	@Override
	public void cadastrar(Colaborador colaborador) {
		colaborador.setId(gerarId());
		listacolaboradors.add(colaborador);
		System.out.println("\nFuncionário código: " + colaborador.getId() + " foi criado com sucesso!");
	}

	@Override
	public void listarTodos() {
		for (Colaborador colaborador : listacolaboradors) {
			colaborador.visualizar();
		}
	}
	
	@Override
	public void buscarPorId(int id) {
		
		Colaborador colaborador = procurarPorId(id);
		
		if (colaborador != null)
			colaborador.visualizar();
		else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
		
	}
	
	@Override
	public void atualizar(Colaborador colaborador) {

		Colaborador buscacolaborador = procurarPorId(colaborador.getId());
		
		if (buscacolaborador != null) {
			listacolaboradors.set(listacolaboradors.indexOf(buscacolaborador), colaborador);
			System.out.println("\nFuncionário código: " + colaborador.getId() + " atualizado com sucesso!");
		}else
			System.out.println("\nFuncionário código: " + colaborador.getId() + " não encontrado!");
	}
	
	@Override
	public void deletar(int id) {
		
		Colaborador colaborador = procurarPorId(id);
		
		if (colaborador != null) {
			if(listacolaboradors.remove(colaborador) == true)
				System.out.println("\nFuncionário código: " + id + " deletado com sucesso!");
		}else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
		
	}
	
	public void calcularAumento(int id, float percentual) {
		
		Colaborador colaborador = procurarPorId(id);
		
		if (colaborador != null) {
			colaborador.aumentarSalario(percentual);
			System.out.println("\nO novo salário do Funcionário código: " + id 
					+ " é: R$ " + colaborador.getSalario());
		}else
			System.out.println("\nFuncionário código: " + id + " não encontrado!");
	}
	
	@Override
	public Colaborador procurarPorId(int id) {
			
		for (Colaborador colaborador : listacolaboradors) {
			if (colaborador.getId() == id) {
				return colaborador;
			}
		}
		
		return null;
		
	}
	
	public int gerarId() {
		return listacolaboradors.size() + 1;
	}
	
}

