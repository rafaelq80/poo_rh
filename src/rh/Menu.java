package rh;

import java.io.IOException;
import java.util.Scanner;

import rh.controller.ColaboradorController;
import rh.model.Gerente;
import rh.model.Vendedor;
import rh.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		Scanner leia = new Scanner(System.in);
		
		ColaboradorController colaboradores = new ColaboradorController();
		
		System.out.println("\nCriar Funcionários\n");
		
		Gerente funcionario1 = new Gerente(0, "Julia Andrews", 
				"julia@email.com.br", 1, 7000.0f, 1000.0f);
		colaboradores.cadastrar(funcionario1);
		
		Vendedor funcionario2 = new Vendedor(0, "Maria Flores", 
				"maria@email.com.br", 2, 2000.0f, 5.0f);
		colaboradores.cadastrar(funcionario2);
		
		Vendedor funcionario3 = new Vendedor(0, "Paulo Antunes", 
				"paulo@email.com.br", 2, 2000.0f, 5.0f);
		colaboradores.cadastrar(funcionario3);
				
		int opcao, id, cargo = 0;
		String nome, email = "";
		float salario, bonificacao, comissao, percentual = 0.0f;
		
		while(true) {

				System.out.println(Cores.TEXT_GREEN + "*********************************************************************" 
													+ Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND 
													+ "                                                                     ");
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND
													+ "                      CADASTRO DE COLABORADORES                      ");
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_BLUE_BACKGROUND 
													+ "                                                                     ");
				System.out.println(Cores.TEXT_RESET + Cores.TEXT_GREEN
													+ "*********************************************************************");
				System.out.println(Cores.TEXT_GREEN + Cores.ANSI_BLUE_BACKGROUND
														 + "                                                                     ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            1 - Inserir novo Colaborador                             ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            2 - Ver os dados de todos os Colaboradores               ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            3 - Ver os dados de um Colaborador                       ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            4 - Atualizar os dados de um Colaborador                 ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            5 - Deletar um Colaborador                               ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            6 - Calcular o novo salário                              ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "            7 - Sair                                                 ");
				System.out.println(Cores.TEXT_GREEN_BOLD + "                                                                     " 
													+ Cores.TEXT_RESET);
				System.out.println(Cores.TEXT_GREEN + "*********************************************************************");
				System.out.println(Cores.TEXT_YELLOW + " Entre com a opção desejada:                         "
													+ Cores.TEXT_RESET);
				opcao = leia.nextInt();
				
				if (opcao == 7) {
					System.out.println(Cores.TEXT_WHITE_BOLD + "\nSistema Finalizado com sucesso!");
					leia.close();
					System.exit(0);
				}
				
				switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_WHITE + "Cadastrar novo Funcionário\n\n");
					
					System.out.println("Digite o Nome do Funcionário: ");
					leia.skip("\\R?");
					nome = leia.nextLine();
					System.out.println("Digite o E-mail do Funcionário: ");
					leia.skip("\\R?");
					email = leia.nextLine();
										
					do {
						System.out.println("Digite o Cargo do Funcionário (1-Gerente/2-vendedor): ");
						cargo = leia.nextInt();
					}while(cargo < 1 && cargo > 2);
						
					System.out.println("Digite o Salário do Funcionário: ");
					salario = leia.nextFloat();
					
					if (cargo == 1) {
						System.out.println("Digite o valor da Bonificação do Gerente (R$): ");
						bonificacao = leia.nextFloat();
						
						colaboradores.cadastrar(new Gerente(0, nome, email, cargo, salario, bonificacao));
						
					}else {
						System.out.println("Digite o percentual da comissão (%): ");
						comissao = leia.nextInt();
						
						colaboradores.cadastrar(new Vendedor(0, nome, email, cargo, salario, comissao));
						
					}
										
					keyPress();
					
					break;
				case 2:
					System.out.println(Cores.TEXT_WHITE + "Visualizar os dados de todos os funcionários\n\n");
					
					colaboradores.listarTodos();
					
					keyPress();
					
					break;
				case 3:
					
					System.out.println(Cores.TEXT_WHITE + "Consultar os dados de um funcionário\n\n");
					
					System.out.println("Digite o id do funcionário: ");
					id = leia.nextInt();
					
					colaboradores.buscarPorId(id);
					
					keyPress();
	
					break;
				case 4:
					System.out.println(Cores.TEXT_WHITE + "Atualizar dados do funcionário\n\n");
					
					System.out.println("Digite o id do funcionário: ");
					id = leia.nextInt();
					
					if (colaboradores.procurarPorId(id) != null) {
						
						System.out.println("Digite o novo Nome do Funcionário: ");
						leia.skip("\\R?");
						nome = leia.nextLine();
						System.out.println("Digite o novo E-mail do Funcionário: ");
						leia.skip("\\R?");
						email = leia.nextLine();
											
						do {
							System.out.println("Digite o novo Cargo do Funcionário (1-Gerente/2-vendedor): ");
							cargo = leia.nextInt();
						}while(cargo < 1 && cargo > 2);
							
						System.out.println("Digite o novo Salário do Funcionário: ");
						salario = leia.nextFloat();
						
						if (cargo == 1) {
							System.out.println("Digite o valor da nova Bonificação do Gerente (R$): ");
							bonificacao = leia.nextFloat();
							
							colaboradores.atualizar(new Gerente(id, nome, email, cargo, salario, bonificacao));
							
						}else {
							System.out.println("Digite o percentual da nova comissão (%): ");
							comissao = leia.nextInt();
							
							colaboradores.cadastrar(new Vendedor(id, nome, email, cargo, salario, comissao));
							
						}
						
						
					}else
						System.out.println("\nFuncionário não encontrado!");
					
					
					keyPress();

					break;
				case 5:
					System.out.println(Cores.TEXT_WHITE + "Deletar funcionário\n\n");
					
					System.out.println("Digite o id do funcionário: ");
					id = leia.nextInt();
					
					colaboradores.deletar(id);
					
					keyPress();
					
					break;
				case 6:
					
					System.out.println(Cores.TEXT_WHITE + "Calcular o aumento de salário do funcionário\n\n");
					
					System.out.println("Digite o id do funcionário: ");
					id = leia.nextInt();
					System.out.println("Digite o percentual do aumento do Funcionário: ");
					percentual = leia.nextFloat();
					
					colaboradores.calcularAumento(id, percentual);
					
					keyPress();
					
					break;
				default:
					
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!");
					keyPress();
					
					break;
			}
		}		
		
	}
	
	public static void keyPress() {
		
		try {
			
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
			
		} catch (IOException e) {
			
			System.out.println("Você pressionou uma tecla diferente de enter!");
			
		}finally {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
		
		}
	}

}

