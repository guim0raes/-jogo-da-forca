import java.util.Scanner;
public class JogoDaForca {
	
	static String[][] palavras = new String[51][51];  
	
	// palavras[linhas][0] armazenará os temas cadastradas
	// palavras[linhas][colunas>0] armazenará as palavras cadastradas
	
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
				System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 11 E 4\n");
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
    	
    	/*  O programa deverá ser capaz de armazenar até 50 diferentes temas.
		(1) Cadastro: o usuário poderá cadastrar temas no programa. Não poderão existir temas com
			nomes iguais.
		(2) Exclusão: o usuário poderá excluir temas desde que não existam palavras associadas a ele.
			Caso não seja possível realizar exclusão, o programa deverá exibir e mensagem “Não foi
			possível excluir o tema. Verifique se existem palavras cadastradas nesse tema.”
		(3) Busca: o usuário poderá buscar por temas cadastrados no sistema.
    	  
    	 * */
    	
    	int option;
    	int indexLinha;
    	int indexColuna;
    	boolean temaRepetido = false;
    	String temaDigitado;
    	Scanner read = new Scanner(System.in);
    	
    	do {
    		System.out.print("\nVocê esta em 'Gerenciar temas'\n");
    		System.out.print("Digite a opção desejada (1-4)\n");
    		System.out.print("(1) Cadastrar Tema\n");
    		System.out.print("(2) Excluir Tema\n");
    		System.out.print("(3) Buscar por um tema\n");
    		System.out.print("(4) Voltar ao menu principal\n");
    		option = read.nextInt();
    	    
    		switch (option) {
    		
    		case 1: // cadastro
    			System.out.print("Digite o tema que deseja cadastrar:\n");
    			read.nextLine().toLowerCase();
    			temaDigitado = read.nextLine().toLowerCase();
    			temaRepetido = false;
    			
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    				    break;
    				}
       			}
    			
    			if(temaRepetido) {
    				System.out.print("\ntema\'"+temaDigitado+"\' já cadastrado por favor digite outro\n");
    			}else{
    				for(indexLinha = 0; indexLinha<50 ;indexLinha++) {
    					if(palavras[indexLinha][0] == null){
    						palavras[indexLinha][0] = temaDigitado;
    	    				System.out.print("\ntema\' "+temaDigitado+"\' cadastrado com sucesso\n");
    	    				break;
    					}
    				}	
    			}
    			break;
    		
    		case 2: // excluir
    			System.out.print("Digite o tema que deseja excluir:\n");
    			read.nextLine();
    			temaDigitado = read.nextLine().toLowerCase();
    		    temaRepetido = false;
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {	
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    					if(palavras[indexLinha][1] == null) {
    				    	palavras[indexLinha][0] = null;     
    				        System.out.println("tema\'"+temaDigitado+"\' excluido\n");
    					}else{
    				    	System.out.println("impossivel excluir o tema\'"+temaDigitado+"\' possui palavras cadastradas\n"); 	
    				    }
    				    break;
    				}
       			}
    			if(temaRepetido == false) {
    				System.out.println("tema\'"+temaDigitado+"\' encotrado\n");
    			}
    		
    		case 3: //busca
    			System.out.print("Digite o tema que deseja buscar:\n");
    			read.nextLine();
    			temaDigitado = read.nextLine().toLowerCase();
    		    temaRepetido = false;
    		    
    		    for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    		    	if(temaDigitado.equals(palavras[indexLinha][0]) ){
    		    		temaRepetido = true;
    		    		System.out.print("tema: "+palavras[indexLinha][0]+" palavras: ");
    		    		for(indexColuna = 1;indexColuna<=50;indexColuna++) {
    		    			System.out.print(palavras[indexLinha][indexColuna]+"|");
    		    		}
    		    		break;
    		    	}
    		    	
    		    }
    		    System.out.print("\n");
    		    if(temaRepetido == false) {
    		    	System.out.println("tema\'"+temaDigitado+"\' encotrado\n");
    		    }
    			break;
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
