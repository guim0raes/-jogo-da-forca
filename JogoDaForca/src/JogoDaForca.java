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
				System.out.print("\nATEN��O DIGITE UM NUMERO ENTRE 1 E 4\n");
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
		(1) Cadastro: o usu�rio poder� cadastrar temas no programa. N�o poder�o existir temas com
			nomes iguais.
		(2) Exclus�o: o usu�rio poder� excluir temas desde que n�o existam palavras associadas a ele.
			Caso n�o seja poss�vel realizar exclus�o, o programa dever� exibir e mensagem �N�o foi
			poss�vel excluir o tema. Verifique se existem palavras cadastradas nesse tema.�
		(3) Busca: o usu�rio poder� buscar por temas cadastrados no sistema.
    	  
    	 * */
    	
    	int option;
    	int indexLinha;
    	int indexColuna;
    	boolean temaRepetido = false;
    	String temaDigitado;
    	Scanner read = new Scanner(System.in);
    	
    	do {
    		System.out.print("\nVoc� esta em 'Gerenciar temas'\n");
    		System.out.print("Digite a op��o desejada (1-4)\n");
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
    				System.out.print("\ntema\'"+temaDigitado+"\' j� cadastrado por favor digite outro\n");
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
    		
    		case 4:
    			break;
    		default:
    			System.out.print("\nATEN��O DIGITE UM NUMERO ENTRE 1 E 4\n");
    			break;
    		}	
    	}while(option != 4);        
    }  
    

	static void GerenciarPalavras() {
    	/* 	o programa dever� ser capaz de armazenar at� 50 palavras para cada um dos temas cadastrados.
			
			(1) Cadastro: o usu�rio poder� cadastrar palavras no programa. Para tanto, ele deve escolher
				um tema e s� ent�o realizar o cadastro. Aten��o! n�o poder�o existir palavras iguais dentro
				de um mesmo tema.
			(2) Exclus�o: o usu�rio poder� excluir palavras cadastradas no programa.
			(3) Busca: o usu�rio deve ser capaz de buscar por uma palavra no conjunto de todas as palavras
				cadastradas no programa. Caso uma palavra n�o seja encontrada, deve ser retornada a
				mensagem �Palavra n�o encontrada�, caso contr�rio a mensagem a ser retornada � �Palavra
				encontrada no tema XYZ�, onde XYZ � o tema em que a palavra est�.
			(4) Listagem: o
			*/
		int option;
    	int indexLinha;
    	int indexColuna;
    	boolean palavraRepetida = false;
    	boolean temaRepetido = false;
    	String palavraDigitada;
    	String temaDigitado;
    	Scanner read = new Scanner(System.in);
    	
    	do {
    		System.out.print("\nVoc� esta em 'Gerenciar palavras'\n");
    		System.out.print("Digite a op��o desejada (1-4)\n");
    		System.out.print("(1) Cadastrar palavra\n");
    		System.out.print("(2) Excluir palavra\n");
    		System.out.print("(3) Buscar por um palavra\n");
    		System.out.print("(4) Voltar ao menu principal\n");
    		option = read.nextInt();
    	    
    		switch (option) {
    		
    		case 1: // cadastro
    			System.out.print("Digite a palavra que deseja cadastrar:\n");
    			read.nextLine();
    			palavraDigitada = read.nextLine().toLowerCase();
    			System.out.print("Digite o tema em que deseja cadastrar a palavra:\n");
    			
    			temaDigitado = read.nextLine().toLowerCase();
    			palavraRepetida = false;
    			temaRepetido = false;
    			
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    				    break;
    				}
       			}
    			
    			if(temaRepetido) {
    				for(indexColuna = 1; indexColuna<=50 ;indexColuna++) {
    					if(palavras[indexLinha][indexColuna] == null) {
    						
    					}else if( palavraDigitada.equals(palavras[indexLinha][indexColuna])){
    						palavraRepetida = true;
    	    				System.out.print("\npalavra\' "+palavraDigitada+"\' j� cadastrada\n");
    	    				break;
    					}
    				}
    			}else{
    				System.out.print("tema n�o encontrado por favor digite um tema j� cadastrado\n");	
    			}
    			
    			if(palavraRepetida != true && temaRepetido) {
    				for(indexColuna = 1; indexColuna<=50;indexColuna++) {
    					if(palavras[indexLinha][indexColuna] == null ) {
    						palavras[indexLinha][indexColuna] = palavraDigitada;
    						break;
    					}
    				}
    				System.out.print("a palavra'"+palavraDigitada+"' foi cadastrada com sucesso ");
    			}
    			break;
    		
    		case 2: // excluir
    			
    		
    		case 3: //busca
    			
    		
    		case 4:
    			break;
    		default:
    			System.out.print("\nATEN��O DIGITE UM NUMERO ENTRE 1 E 4\n");
    			break;
    		}	
    	}while(option != 4);  
    }
    static void Jogar() {
    	System.out.println("escolha: jogar");
    }
    static void Sair() {
    	System.out.print("\nvoce saiu!\nObrigado por jogar!\n");
    }
    
}
