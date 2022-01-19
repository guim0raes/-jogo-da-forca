import java.util.Scanner;
public class JogoDaForca {

	public static void main(String[] args) {
		int option;
		
		do {
		option = DisplayMenu();
			switch (option){
			case 1: 
				GerenciarTemas();
				break;
			case 2:
				GerenciarPalavras();
				break;
			case 3:
				Jogar();
				break;
			case 4:
				Sair();
				break;
			default:
				System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 4\n");
				DisplayMenu();
				break;
			}
		}while(option != 4);
             
	}
    static int DisplayMenu() {
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
    static void GerenciarTemas() {
    	System.out.print("escolha: gerenciar temas");
    }
    static void GerenciarPalavras() {
    	System.out.print("escolha: gerenciar palavras");
    }
    static void Jogar() {
    	System.out.print("escolha: jogar");
    }
    static void Sair() {
    	System.out.print("\nvoce saiu!\nObrigado por jogar!\n");
    }
    
}
