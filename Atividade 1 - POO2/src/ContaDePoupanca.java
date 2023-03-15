public class ContaDePoupanca {
	private static double taxaDeJurosAnual = 0;
	public double saldoDaPoupanca;
	
	public ContaDePoupanca(double saldoDaPoupanca) {
		this.saldoDaPoupanca = saldoDaPoupanca;
	}
	public void calculeRendimentoMensal() {
		saldoDaPoupanca +=(saldoDaPoupanca * (taxaDeJurosAnual/100)) / 12;
	}
	public static void modifiqueTaxaDeJuros(double value) {
		taxaDeJurosAnual = value;
	}
	@Override
	public String toString() {
		return "ContaDePoupanca [saldoDaPoupanca=" + saldoDaPoupanca + "]";
	}
}
