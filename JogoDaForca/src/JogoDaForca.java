import java.util.Scanner;
public class JogoDaForca {
	
	static String[][] palavras = new String[51][51];  
	
	// palavras[linhas][0] armazenar� os temas cadastradas
	// palavras[linhas][colunas>0] armazenar� as palavras cadastradas
	
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
				System.out.print("\nATEN��O DIGITE UM NUMERO ENTRE 11 E 4\n");
				DisplayMenu();
				break;
			}
		}while(option != 4);
             
	}
    static int DisplayMenu() {
    	Scanner read = new Scanner(System.in);
    	int option;
    	
    	System.out.print("\nDigite a op��o desejada (1-4)\n");
    	System.out.print("(1) Gerenciar Temas\n");
    	System.out.print("(2) Gerenciar palavras\n");
    	System.out.print("(3) Jogar\n");
    	System.out.print("(4) Sair\n");
    	option = read.nextInt();
    	return option;
        
    }
    static void GerenciarTemas() {
    	
    	/*  O programa dever� ser capaz de armazenar at� 50 diferentes temas.
		(a) Cadastro: o usu�rio poder� cadastrar temas no programa. N�o poder�o existir temas com
			nomes iguais.
		(b) Exclus�o: o usu�rio poder� excluir temas desde que n�o existam palavras associadas a ele.
			Caso n�o seja poss�vel realizar exclus�o, o programa dever� exibir e mensagem �N�o foi
			poss�vel excluir o tema. Verifique se existem palavras cadastradas nesse tema.�
		(c) Busca: o usu�rio poder� buscar por temas cadastrados no sistema.
    	  
    	 * */
    	
    	int option;
    	int index;
    	boolean temaRepetido = false;
    	String temaCadastro;
    	Scanner read = new Scanner(System.in);
    	
    	do {
    		
    		System.out.print("\nDigite a op��o desejada (1-4)\n");
    		System.out.print("(1) Cadastrar Tema\n");
    		System.out.print("(2) Excluir Tema\n");
    		System.out.print("(3) Buscar por um tema\n");
    		System.out.print("(4) Voltar ao menu principal\n");
    		option = read.nextInt();
    	    
    		switch (option) {
    		
    		case 1:
    			System.out.print("Digite o tema que deseja cadastrar:\n");
    			read.nextLine();
    			temaCadastro = read.nextLine().toString();
    			temaRepetido = false;
    			
    			for( index = 0; index <= 50; index++) {
    				if(temaCadastro.equals(palavras[index][0]) ){
    					temaRepetido = true;
    				    break;
    				}
       			}
    			
    			if(temaRepetido) {
    				System.out.print("\ntema j� cadastrado por favor digite outro\n");
    			}else{
    				for(index = 0; index<50 ;index++) {
    					if(palavras[index][0] == null){
    						palavras[index][0] = temaCadastro;
    	    				System.out.print("\ntema:"+palavras[index][0]+" cadastrado com sucesso\n");
    	    				break;
    					}
    				}	
    			}
    			break;
    		case 2:
    			
    		}
    	
    	}while(option != 4);        
    }  
    
	private static String String(String teste) {
		// TODO Auto-generated method stub
		return null;
	}
	static void GerenciarPalavras() {
    	System.out.println("escolha: gerenciar palavras");
    	
    }
    static void Jogar() {
    	System.out.println("escolha: jogar");
    }
    static void Sair() {
    	System.out.print("\nvoce saiu!\nObrigado por jogar!\n");
    }
    
}
