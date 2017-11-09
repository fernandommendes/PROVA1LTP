package dados;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CadVisitas {

	public static ArrayList<Visita> listarVisitas = new ArrayList<Visita>();
	
	public static void incluirVisita (Visita obj){
		listarVisitas.add(obj);
	}
	
	public static Visita pesqCodVisita(int codVisita){
		for (Visita obj : listarVisitas){
			if (obj.getCodVisita()==codVisita){
				return obj;
			}
		}
		return null;
	}
	
	public static Visita pesqCpf(String cpf){
		for (Visita obj:listarVisitas){
			if (obj.getCpf()==cpf){
				return obj;
			}
		}
		return null;
	}
	
	public static void excluirVisita(Visita obj){
		listarVisitas.remove(obj);
	}
	
//	public static void encerrarVisita (GregorianCalendar saida){
//		for (Visita obj : listarVisitas){
//			if(obj.setSaida(saida)==null){
//				
//			}
//		}
//	}
	
	public static ArrayList<Visita> pesqVisitasCpf(String cpf){
		 ArrayList<Visita> resposta = new ArrayList<Visita>();
		 for (Visita obj : listarVisitas){
			 if (obj.getCpf()==cpf){
				 resposta.add(obj);
			 }
		 }
		 return resposta;
	}
	
	public static ArrayList<Visita> pesqVisitasAndamento(){
		 ArrayList<Visita> resposta = new ArrayList<Visita>();
		 for (Visita obj : listarVisitas){
			 if (obj.getSaida()==null){
				 resposta.add(obj);
			 }
		 }
		 return resposta;
	}
	
	
}