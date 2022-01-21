import java.util.Scanner;
import java.io.IOException;
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
			case 5:
				DisplayTabela();
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
    	System.out.print("(5) Tabela\n");
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
    		read.hasNextLine();
    		option = read.nextInt();
    	    
    		switch (option) {
    		
    		case 1: // cadastro
    			System.out.print("Digite o tema que deseja cadastrar:\n");
    			read.nextLine();
    			temaDigitado = read.nextLine().toLowerCase();
    			temaRepetido = false;
    			
    			// localizar se o tema j� est� cadastrado
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
    		    int nullsRepetidos = 0;
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {	
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    					if(palavras[indexLinha][1] == null){
    				    	
    						//substitui a palavra desejada pela posterior para evitar nulls no meio da matiz
    						for(indexLinha = indexLinha;indexLinha<=50;indexLinha++) {
    				    		if(nullsRepetidos >=2) break;
    				    		if(palavras[indexLinha][0]== null)nullsRepetidos++;	
    				    		if(indexLinha < 50 && nullsRepetidos < 2) {
    				    			palavras[indexLinha][0] = palavras[indexLinha+1][0];  
    				    		}else {
    				    			palavras[indexLinha][0] = null;  
    				    		}
    				    	}
    						
    						   
    				        System.out.println("tema\'"+temaDigitado+"\' excluido\n");
    					}else{
    				    	System.out.println("impossivel excluir o tema\'"+temaDigitado+"\' possui palavras cadastradas\n"); 	
    				    }
    				    break;
    				}
       			}
    			if(temaRepetido == false) {
    				System.out.println("tema\'"+temaDigitado+"\' nao encotrado\n");
    			}
    			break;
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
    		    			if(palavras[indexLinha][indexColuna] == null) break;
    		    			System.out.print("'"+palavras[indexLinha][indexColuna]+"' ");
    		    		}
    		    		break;
    		    	}
    		    	
    		    }
    		    System.out.print("\n");
    		    if(temaRepetido == false) {
    		    	System.out.println("tema\'"+temaDigitado+"\' nao encotrado\n");
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
			(4) Listagem: ousu�rio poder� selecionar um tema e ver todas as palavras cadastrada naquele tema.

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
    		System.out.print("(4) Listar palavras\n");
    		System.out.print("(5) Voltar ao menu principal\n");
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
    			System.out.print("Digite a PALAVRA que deseja excluir:\n");
    			read.nextLine();
    			palavraDigitada = read.nextLine().toLowerCase();
    			System.out.print("Digite o TEMA em que deseja excluir a palavra:\n");
    			int nullConta = 0;
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
    						break;
    					}else if(palavraDigitada.equals(palavras[indexLinha][indexColuna])){
    						palavraRepetida = true;
    						
    						//substitui a palavra desejada pela posterior para evitar nulls no meio da matiz
    						for(indexColuna = indexColuna; indexColuna<=50 ;indexColuna++){
    							if(nullConta >= 2) break;
    							if (palavras[indexLinha][indexColuna] == null) nullConta++;
    							if(indexColuna <50 && nullConta<2) {
    								palavras[indexLinha][indexColuna] = palavras[indexLinha][indexColuna + 1];
    							}else palavras[indexLinha][indexColuna] = null;
    							}				
    	    				break;
    					}
    				}
    			}else{
    				System.out.print("tema n�o encontrado por favor digite um tema j� cadastrado\n");	
    			}
    			
    			if(palavraRepetida != true && temaRepetido) {
    				System.out.print("palavra n�o encontrada\n");
    			}
    			break;
    		
    		case 3: //busca
    			System.out.print("Digite a PALAVRA que deseja buscar:\n");
    			read.nextLine();
    			palavraDigitada = read.nextLine().toLowerCase();
    			palavraRepetida = false;
    			for(indexLinha = 0;indexLinha<=50;indexLinha++){
    				for(indexColuna = 1;indexColuna<=50;indexColuna++){
    					if(palavraDigitada.equals(palavras[indexLinha][indexColuna])) {
    						palavraRepetida = true;
    						System.out.print("palavra encontrada no tema :"+palavras[indexLinha][0]+"\n");
    					}
    				}
    			}
    			if(palavraRepetida == false)System.out.print("palavra nao encontrada\n");
    			break;
    		
    		case 4:
    			System.out.print("Digite o tema que deseja buscar:\n");
    			read.nextLine();
    			temaDigitado = read.nextLine().toLowerCase();
    			temaRepetido = false;
		    
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    					System.out.print("tema: "+palavras[indexLinha][0]+" palavras: ");
    					for(indexColuna = 1;indexColuna<=50;indexColuna++) {
    						if(palavras[indexLinha][indexColuna] == null) break;
    						System.out.print("'"+palavras[indexLinha][indexColuna]+"' ");
    					}
    					break;
    				}
    				
    			}
    			System.out.print("\n");
    			if(temaRepetido == false) {
    				System.out.println("tema\'"+temaDigitado+"\' nao encotrado\n");
    			}
    			break;
    		case 5:
    			break;
    		default:
    			System.out.print("\nATEN��O DIGITE UM NUMERO ENTRE 1 E 4\n");
    			break;
    		}	
    	}while(option != 4);  
    }
    static void Jogar(){
    	/*	(1) Sele��o de tema: antes de iniciar um jogo, o usu�rio dever� selecionar um tema onde ser�
				buscada a palavra.
			(2) Jogo:
				i. Em cada rodada, o usu�rio deve escolher uma letra.
				ii. Caso a letra j� tenha sido tentada, o programa dever� mostrar a mensagem: �Tente
				outra letra!�
				iii. Para cada letra tentada pelo usu�rio e n�o presente na palavra, dever� ser contabilizado
				um erro.
			
				iv. O usu�rio poder� ter no m�ximo cinco erro. Ap�s a quinta tentativa errada, o programa
				dever� mostrar a mensagem �Voc� perdeu! Deseja Deseja jogar novamente?�. N�o �
				necess�rio mostrar a palavra no final da partida.
				v. Caso o usu�rio acerte a palavra, o programa dever� mostrar a mensagem: �Parab�ns!
				Voc� acertou a palavra! Deseja jogar novamente?�.
			(3) Jogar novamente: caso o usu�rio, ao final de um jogo, decida jogar novamente, deve ser
				mostrada novamente a op��o de escolha de tema. Depois disso, um novo jogo � iniciado.
			(4) Sair: caso o usu�rio decida n�o jogar novamente, o programa deve mostrar o menu inicial.

    	 * */
    	int indexLinha=0;
    	int indexColuna=0;
    	
    	boolean palavraRepetida = false;
    	boolean temaRepetido = false;
    	boolean jogarNovamente = false;
    	String palavraDigitada;
    	String temaDigitado;
    	String palavraJogo;
    	
    	Scanner read = new Scanner(System.in);
    	
		do {
			jogarNovamente = false;
			temaRepetido = false;
	    	System.out.print("Digite um tema para jogar\n");
	    	temaDigitado = read.nextLine();
	    	
	    	for(indexLinha=0;indexLinha<=50;indexLinha++){
	    		if(temaDigitado.equals(palavras[indexLinha][0])){
	    			temaRepetido = true;
	    			for(indexColuna = 1;indexColuna<=50;indexColuna++) {
	    				if(palavras[indexLinha][indexColuna] == null){				
	    					break;
	    				}
	    			}
	    		break;
	    		}
	    	}
	    	
	    	if(temaRepetido){ // iniciar jogo
	    		
	    		read.nextLine();
	    		System.out.print("Digite um numero de 1 a "+(indexColuna - 1)+"para jogar\n");
	    		
	    		palavraJogo = palavras[indexLinha][read.nextInt()];
	    	    System.out.print("palavraJogo ="+palavraJogo);
	    		
	    	    
	           
	    	    if(palavraJogo != null) {
	            	
	        		boolean fimJogo = false;
	        		boolean acertouPalavra = false;
	        		boolean letraRepetida = false;
	        		int acertouLetra = 0;
	        		int letrasAcertadas = 0;
	        		int indexLetraDigitada = 0;
	        		int erros = 0;
	        		String[] letrasDigitadas = new String[palavraJogo.length()+6];
	        		char[] letrasPalavra = palavraJogo.toCharArray();
	                String letraDigitada;
	               
	                for(int aux=0;aux<palavraJogo.length();aux++){
	                	System.out.print("|"+letrasPalavra[aux]); 	
	                }
	                System.out.print("\n");
	                
	                
	                	do {
	                	acertouLetra = 0;
	                	palavraRepetida = false;
	                	read.nextLine();
	                	System.out.print("Digite uma letra: ");
	 
	                	letraDigitada = read.nextLine();
	                	
	                	for(int aux = 0;aux<(palavraJogo.length()+6);aux++) {
	                		if(letraDigitada.equals(letrasDigitadas[aux])){
	                			palavraRepetida = true;
	                		}
	                	}
	                	if(palavraRepetida){
	                		System.out.print("tente outra letra\n");
	                		continue;
	                	}else {
	                		letrasDigitadas[indexLetraDigitada] = letraDigitada;
	                	
	                	}
	                	
	                	for(int aux=0;aux<palavraJogo.length();aux++){
	                		if(letraDigitada.equals( String.valueOf(letrasPalavra[aux]) )){
	                			
	                			acertouLetra++;
	                			letrasAcertadas++;
	                			
	                		}
	                	}
	                	
	                	if(acertouLetra>0) { 
	                		System.out.print("a letra'"+letrasDigitadas[indexLetraDigitada].toUpperCase()+"' aparece "+acertouLetra+" vezes na palavra\n");
	                	}else { 
	                		System.out.print("a letra'"+letrasDigitadas[indexLetraDigitada].toUpperCase()+"' nao pertence a palavra ");
	                		erros++;
	                		System.out.print("voce ainda tem "+(6-erros)+" chances\n");
	                	}
	                	
	                	indexLetraDigitada++;
	                	if(letrasAcertadas == palavraJogo.length()) {
	                		acertouPalavra = true;
	                	}
	                	if(acertouPalavra){
	                		System.out.print("voce acertou a palavra fim de jogo\n");
	                		fimJogo = true;
	                	}
	                	if(erros>5) {
	                		System.out.print("voce errou 6 vezes fim de jogo\n");
	                		fimJogo = true;
	                	}
	                }while(fimJogo == false);
	                	System.out.print("deseja jogar novamente? \n");
	                    if(read.nextLine().toLowerCase().equals("sim")){
	                    	jogarNovamente = true;
	                    }
	                
	            
	            }else 
	            	System.out.print("palavra n�o selecionada\n");
	            	        
	    	}else
	    		System.out.print("Tema n�o encontrado\n");
    }while(jogarNovamente);
    }
   
	static void Sair() {
    	
    	
            
    }
    static void DisplayTabela() {
    	for(int linha=0;linha<=50;linha++) {
    		if(palavras[linha][0] != null) {
    		System.out.print("\n"+palavras[linha][0]+": ");
    		}
    		for(int coluna=1; coluna<=50;coluna++) {
    			if(palavras[linha][coluna] != null) {
    			System.out.print("'"+palavras[linha][coluna]+"' ");
    			}
    		}
    		
    	}
    }
    
     
}
