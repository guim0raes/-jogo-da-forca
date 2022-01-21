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
			case 5:
				DisplayTabela();
				break;
			default:
				System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 4\n");
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
    	System.out.print("(5) Tabela\n");
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
    		read.hasNextLine();
    		option = read.nextInt();
    	    
    		switch (option) {
    		
    		case 1: // cadastro
    			System.out.print("Digite o tema que deseja cadastrar:\n");
    			read.nextLine().toLowerCase();
    			temaDigitado = read.nextLine().toLowerCase();
    			temaRepetido = false;
    			
    			// localizar se o tema já está cadastrado
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
    			System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 4\n");
    			break;
    		}	
    	}while(option != 4);        
    }  
    

	static void GerenciarPalavras() {
    	/* 	o programa deverá ser capaz de armazenar até 50 palavras para cada um dos temas cadastrados.
			
			(1) Cadastro: o usuário poderá cadastrar palavras no programa. Para tanto, ele deve escolher
				um tema e só então realizar o cadastro. Atenção! não poderão existir palavras iguais dentro
				de um mesmo tema.
			(2) Exclusão: o usuário poderá excluir palavras cadastradas no programa.
			(3) Busca: o usuário deve ser capaz de buscar por uma palavra no conjunto de todas as palavras
				cadastradas no programa. Caso uma palavra não seja encontrada, deve ser retornada a
				mensagem “Palavra não encontrada”, caso contrário a mensagem a ser retornada é “Palavra
				encontrada no tema XYZ”, onde XYZ é o tema em que a palavra está.
			(4) Listagem: ousuário poderá selecionar um tema e ver todas as palavras cadastrada naquele tema.

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
    		System.out.print("\nVocê esta em 'Gerenciar palavras'\n");
    		System.out.print("Digite a opção desejada (1-4)\n");
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
    	    				System.out.print("\npalavra\' "+palavraDigitada+"\' já cadastrada\n");
    	    				break;
    					}
    				}
    			}else{
    				System.out.print("tema não encontrado por favor digite um tema já cadastrado\n");	
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
    				System.out.print("tema não encontrado por favor digite um tema já cadastrado\n");	
    			}
    			
    			if(palavraRepetida != true && temaRepetido) {
    				System.out.print("palavra não encontrada\n");
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
    		case 4:// voltar ao menu principal
    			break;
    		default:
    			System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 4\n");
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
