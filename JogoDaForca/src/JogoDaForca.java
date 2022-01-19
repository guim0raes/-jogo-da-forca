import java.util.Scanner;
public class JogoDaForca {
	
	String[][] palavras = new String[51][51];
	
	public static void main(String[] args) {
		int option;
		JogoDaForca game = new JogoDaForca();
		
		do {
		option = game.DisplayMenu();
			switch (option){
			case 1: 
				game.GerenciarTemas();
				break;
			case 2:
				game.GerenciarPalavras();
				break;
			case 3:
				game.Jogar();
				break;
			case 4:
				game.Sair();
				break;
			default:
				System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 4\n");
				game.DisplayMenu();
				break;
			}
		}while(option != 4);
             
	}
    public int DisplayMenu() {
    	Scanner read = new Scanner(System.in);
    	int option;
    	
    	System.out.print("\nDigite a opção desejada (1-4)\n");
    	System.out.print("(1) Gerenciar Temas\n");
    	System.out.print("(2) Gerenciar palavras\n");
    	System.out.print("(3) Jogar\n");
    	System.out.print("(4) Sair\n");
    	option = read.nextInt();
    	return option;
        
    }
    public void GerenciarTemas() {
    	System.out.println("escolha: gerenciar temas");
        
    }
    public void GerenciarPalavras() {
    	System.out.println("escolha: gerenciar palavras");
    	
    }
    public void Jogar() {
    	System.out.println("escolha: jogar");
    }
    public void Sair() {
    	System.out.print("\nvoce saiu!\nObrigado por jogar!\n");
    }
    
}
