public class Program {

	public static void main(String[] args) {
        Estudante estudante1 = new Estudante(1);
        Estudante estudante2 = new Estudante(2);
        try {
            estudante1.setMatricula(-1); 
        } catch (LimiteEstudantesException e) {
            System.out.println(e.getMessage()); 
        }
        
        Orientador orientador1 = new Orientador("Cleber");
        Orientador orientador2 = new Orientador("Laura");
        
        try {
            orientador1.adicionarEstudante();
            orientador1.adicionarEstudante(); 
            //orientador1.adicionarEstudante(); //"Joga" a exception 
        } catch (LimiteOrientadorException e) {
            System.out.println(e.getMessage()); 
        }
        
        Orientador orientador3 = new Orientador("Dory");
        Orientador orientador4 = new Orientador("Sirlon");
        orientador3.adicionarEstudante();
        orientador3.adicionarEstudante();
        try {
            orientador3.adicionarEstudante(); 
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); 
            }
    }
	
}
