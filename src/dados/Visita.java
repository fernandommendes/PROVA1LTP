package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class Visita {

	private static int sequencia = 0;
	
	private int codVisita;
	private String cpf;
	private GregorianCalendar entrada;
	private GregorianCalendar saida;
	
	public Visita(String cpf) {
		
		codVisita = ++sequencia;
		this.cpf = cpf;
		entrada = new GregorianCalendar();
		saida = null;
	}

	public int getCodVisita() {
		return codVisita;
	}

//	public void setCodVisita(int codVisita) {
//		this.codVisita = codVisita;
//	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public GregorianCalendar getEntrada() {
		return entrada;
	}

	public void setEntrada(GregorianCalendar entrada) {
		this.entrada = entrada;
	}

	public GregorianCalendar getSaida() {
		return saida;
	}

	public void setSaida(GregorianCalendar saida) {
		this.saida = saida;
	}
	
	public String toString(){
		return
				"Código: " + codVisita + "\n" +
				"CPF: " + cpf + "\n" +
				"Hora entrada: " + LtpUtil.formatarData(entrada, "dd/MM/yyyy HH:mm:ss") + "\n" +
				"Hora Saida: " + (saida==null?"Visitante se encontra no local.":LtpUtil.formatarData(saida, "dd/MM/yyyy HH:mm:ss")) + "\n";
	}
	
	
	
	
}
