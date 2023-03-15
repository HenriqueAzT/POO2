public class Program {

	public static void main(String[] args) {
		//NÚMERO 1
		ContaDePoupanca.modifiqueTaxaDeJuros(6);
		
		ContaDePoupanca poupador1 = new ContaDePoupanca(3000);
		
		ContaDePoupanca poupador2 = new ContaDePoupanca(6000);
		
		//System.out.println(poupador1.toString());
		//System.out.println(poupador2.toString());
		
		poupador1.calculeRendimentoMensal();
		poupador2.calculeRendimentoMensal();
		
		//System.out.println(poupador1.toString());
		//System.out.println(poupador2.toString());
		
		ContaDePoupanca.modifiqueTaxaDeJuros(8);
		
		poupador1.calculeRendimentoMensal();
		poupador2.calculeRendimentoMensal();
		
		//System.out.println(poupador1.toString());
		//System.out.println(poupador2.toString());
		
		//------------------------------------------------------------//
		//NÚMERO 2
		
		Contato contato1 = new Contato("Jonas", "jonas@gmail.com");
		Contato contato2 = new Contato("Carla", "carla@gmail.com");
		Contato contato3 = new Contato("Vitor", "vitor@gmail.com");
		
		Agenda agenda = new Agenda(3);
		
		agenda.adicionarContato(contato1);
		
		agenda.adicionarContato(contato2);
		
		agenda.adicionarContato(contato3);
		
		System.out.println(agenda.toString());
		
		agenda.buscarContato("Vitor");
		
		agenda.excluirContato("Jonas");
		
		System.out.println(agenda.toString());
	}
}