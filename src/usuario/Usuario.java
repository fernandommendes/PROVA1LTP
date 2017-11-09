package usuario;
import java.util.ArrayList;

import dados.Visita;
import dados.CadVisitas;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class Usuario {

	public static void main(String[] args) {

		menu();
		System.out.println("\nFInal do programa.");
		System.exit(0);
	}

	private static void menu() {
		int opcao = 0;
		do{
			System.out.println("\nMenu do programa.");
			System.out.println("\n1 - Cadastrar uma nova visita.");
			System.out.println("\n2 - Excluir uma visita pelo código.");
			System.out.println("\n3 - Consultar uma vista pelo código.");
			System.out.println("\n4 - Encerrar uma visita em andamento.");
			System.out.println("\n5 - Listar todas visitas pelo CPF.");
			System.out.println("\n6 - Listar todas visitas que estão no estabelecimento.");
			System.out.println("\n0 - Sair do Programa.");
			opcao = Console.readInt("Digite uma opção: ");
			
			switch (opcao) {
			case 1:
				registro();
				break;
			case 2:
				excluirVisitaCod();
				break;
			case 3:
				consultarCod();
				break;
			case 4:
				encerrarVisita();
				break;
			case 5:
				listarVisitasCpf();
				break;
			case 6:
				listaVisitasAndamento();
				break;
			case 0: break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		}while (opcao!=0);
		
		
	}

	private static void listaVisitasAndamento() {
		System.out.println("\nLista de Visita em Andamento\n");
		ArrayList<Visita> resp = CadVisitas.pesqVisitasAndamento();
		for ( Visita obj : resp) System.out.println(obj.toString());		
		
	}

	private static void listarVisitasCpf() {
		System.out.println("\nLista de Visita pelo CPF\n");
		String cpf = Console.readLine("Digite o CPF: ");
		ArrayList<Visita> resp = CadVisitas.pesqCpf(cpf);
		while (true){
			if (!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido.");
				continue;
			}else if(resp.isEmpty()){
				System.out.println("Não existe cadastro com este CPF.");
				break;
			}else{
				for (Visita obj : resp) System.out.println(obj.toString());
				break;
			}
		}
		
	}

	private static void encerrarVisita() {
		
		
	}

	private static void consultarCod() {
		System.out.println("Consultar visita pelo código.");
		int cod = 0;
		Visita obj;
		while (true){
			obj = CadVisitas.pesqCodVisita(cod);
			if(obj == null){
				System.out.println("Código não encontrado.");
				continue;
			}else{
				
				break;
			}
		}
		CadVisitas.pesqCodVisita(cod);
		System.out.println("Pesquisa Finalizada.");
	}

	private static void excluirVisitaCod() {
		System.out.println("Excluir visita pelo código.");
		int cod;
		Visita obj;
		while (true){
			cod = Console.readInt("Digite o código da visita: ");
			obj = CadVisitas.pesqCodVisita(cod);
			if(obj == null){
				System.out.println("Código não encontrado.");
				continue;
			}else{
				break;
			}
		}
		CadVisitas.excluirVisita(obj);
		System.out.println("Cadastro excluido!");
	}

	private static void registro() {
		System.out.println("\nCadastro de Visita\n");
		String cpf;
		while (true){
			cpf = Console.readLine("Digite o CPF: ");
			if (!LtpUtil.validarCPF(cpf)){
				System.out.println("CPF inválido.");
				continue;
			}
			Visita obj = CadVisitas.pesqCpf(cpf);
			if (obj.getSaida()==null){
				System.out.println("Visitante ainda com vistação em aberto.");
			}else break;
		}
		CadVisitas.incluirVisita(new Visita(cpf));
		System.out.println("Cadastro realizado!");
	}

}
