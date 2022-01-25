import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {
	
	static String[][] palavras = new String[51][51];  
	
	// palavras[0<=linhas<50][0] armazenará os temas cadastradas 
	// palavras[0<=linhas<50][0<colunas<50] armazenará as palavras cadastradas
	
	public static void main(String[] args) {
		int option;
		CadastroAutomatico();
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
				DisplayTabela();			
				break;
	
			case 5:
				Sair();
				break;
			default:
				System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 6\n");
				break;
			}
		}while(option != 5);
             
	}
    static int DisplayMenu() {
    	Scanner read = new Scanner(System.in);
    	int option;
    	
    	System.out.print("\nDigite a opção desejada (1-5)\n");
    	System.out.print("(1) Gerenciar Temas\n");
    	System.out.print("(2) Gerenciar palavras\n");
    	System.out.print("(3) Jogar\n"); 	
    	System.out.print("(4) Mostrar tabela de temas e palavras cadastradas\n");
    	System.out.print("(5) Sair\n");
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
    			read.nextLine();
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
    			
    		    //procurar pelo tema digitado
    		    for( indexLinha = 0; indexLinha <= 50; indexLinha++) {	
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    					
    					// garantir que o tema não possui nenhuma palavra cadastrada
    					if(palavras[indexLinha][1] == null){ 
    				    	
    						//substitui o tema desejada pela posterior para evitar nulls no meio da matiz
    						for(indexLinha = indexLinha;indexLinha<=50;indexLinha++) {
    				    		for(indexColuna=0;indexColuna<=50;indexColuna++) {
    							
    				    		if(indexLinha < 50 ) {
    				    			palavras[indexLinha][indexColuna] = palavras[indexLinha+1][indexColuna];  
    				    		}else {
    				    			palavras[indexLinha][0] = null;  
    				    		}
    				    	
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
    		    
    		    //procurar pelo tema digitado
    		    for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    		    	if(temaDigitado.equals(palavras[indexLinha][0]) ){
    		    		temaRepetido = true;
    		    		System.out.print("tema: "+palavras[indexLinha][0]+" palavras: ");
    		    		
    		    		//printar as palavras cadastrada ao tema
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
    		
    		case 4: //voltar ao menu
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
    			
    			 //procurar pelo tema digitado
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    				    break;
    				}
       			}
    			
    			if(temaRepetido) {
    				//verificar se a palavra é repetida
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
    			
    			//registrar palavra na matriz
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
    			
    			 //procurar pelo tema digitado
    			for( indexLinha = 0; indexLinha <= 50; indexLinha++) {
    				if(temaDigitado.equals(palavras[indexLinha][0]) ){
    					temaRepetido = true;
    				    break;
    				}
       			}
    			
    			if(temaRepetido) {
    				//procurar por palavra digitada
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
    				System.out.print("Palavra excluida com sucesso\n");
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
    						System.out.print("palavra encontrada no tema: "+palavras[indexLinha][0]+"\n");
    					}
    				}
    			}
    			if(palavraRepetida == false)System.out.print("palavra nao encontrada\n");
    			break;
    		
    		case 4: //busca
    			
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
    		case 5://voltara ao menu
    			break;
    		default:
    			System.out.print("\nATENÇÃO DIGITE UM NUMERO ENTRE 1 E 5\n");
    			break;
    		}	
    	}while(option != 5);  
    }
    static void Jogar(){
    	/*	(1) Seleção de tema: antes de iniciar um jogo, o usuário deverá selecionar um tema onde será
				buscada a palavra.
			(2) Jogo:
				i. Em cada rodada, o usuário deve escolher uma letra.
				ii. Caso a letra já tenha sido tentada, o programa deverá mostrar a mensagem: “Tente
				outra letra!”
				iii. Para cada letra tentada pelo usuário e não presente na palavra, deverá ser contabilizado
				um erro.
			
				iv. O usuário poderá ter no máximo cinco erro. Após a quinta tentativa errada, o programa
				deverá mostrar a mensagem “Você perdeu! Deseja Deseja jogar novamente?”. Não é
				necessário mostrar a palavra no final da partida.
				v. Caso o usuário acerte a palavra, o programa deverá mostrar a mensagem: “Parabéns!
				Você acertou a palavra! Deseja jogar novamente?”.
			(3) Jogar novamente: caso o usuário, ao final de um jogo, decida jogar novamente, deve ser
				mostrada novamente a opção de escolha de tema. Depois disso, um novo jogo é iniciado.
			(4) Sair: caso o usuário decida não jogar novamente, o programa deve mostrar o menu inicial.

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
	    	for(int i = 0;i<=50;i++) {
	    		if(palavras[i][0] != null) {
	    		System.out.print("'"+palavras[i][0]+"'");
	    		}else break;
	    	}
	    	temaDigitado = read.nextLine();
	    	
	    	// indentificar o tema desejado
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
	    	
	    	if(temaRepetido){ 
	    		
	    		// defeni a palavra que deve ser adivinhada de forma aleatoria
	    		palavraJogo = palavras[indexLinha][(int) generateRandomIntIntRange(1,(indexColuna-1) )];
	    	    
	    	    if(palavraJogo != null) {
	            	
	        		boolean fimJogo = false;
	        		boolean acertouPalavra = false;
	        		boolean letraRepetida = false;
	        		int acertouLetra = 0;
	        		int letrasAcertadas = 0;
	        		int indexLetraDigitada = 1;
	        		int erros = 0;
	        		String[] letrasDigitadas = new String[palavraJogo.length()+6];
	                String letraDigitada;
	                
	                //letrasPalavra possui os caracteres da palavra misterio          
	                char[] letrasPalavra = palavraJogo.toCharArray();
	                
	                /* mostra a palavra misterio antes do jogo começar
	                 * for(int aux=0;aux<letrasPalavra.length;aux++){
	                	System.out.print("|"+letrasPalavra[aux]); 	
	                }
	                System.out.print("\n");*/
	             
	                //inciar os caracter " " e "" para o uzario não precisar contabiliza-los para ganhar o jogo e evitar erros de digitação
	                
	                
	                letrasDigitadas[0]=" ";
	                for(int aux=0;aux<palavraJogo.length();aux++){
                		if(" ".equals( String.valueOf(letrasPalavra[aux]) )){
                			acertouLetra++;
                			letrasAcertadas++;
                		}
                	}	
	                System.out.print("O JOGO COMEÇOU!! A PALAVRA MISTERIO POSSUI "+letrasPalavra.length+" CARACTERES\n");
	                do { 
	                	// inicia o jogo
	                	
	                	
	                	acertouLetra = 0;
	                	palavraRepetida = false;
	                	
	                	System.out.print("Digite uma letra: ");
	                	letraDigitada = read.nextLine();
	                	
	                	// confere se a letra já foi digitada ------------------------------------------------
	                	for(int aux = 0;aux<(palavraJogo.length()+6);aux++) {
	                		if(letraDigitada.equals(letrasDigitadas[aux])){
	                			palavraRepetida = true;
	                		}
	                	}
	                	if(palavraRepetida){
	                		System.out.print("tente outra letra\n");
	                		continue;
	                	}else{
	                		letrasDigitadas[indexLetraDigitada] = letraDigitada.toLowerCase();
	                	}
	                	
	                	//confere se a letra digitada pertence a palavra misterio ------------------------------
	                	for(int aux=0;aux<palavraJogo.length();aux++){
	                		if(letraDigitada.equals( String.valueOf(letrasPalavra[aux]) )){
	                			acertouLetra++;
	                			letrasAcertadas++;
	                		}
	                	}
	                	
	                	// contabiliza os erros e/ou acertos ------------------------------------------------------------
	                	if(acertouLetra>0) { 
	                		//System.out.print("a letra'"+letrasDigitadas[indexLetraDigitada].toUpperCase()+"' pertence a palavra\n");
	                	}else { 
	                		//System.out.print("a letra'"+letrasDigitadas[indexLetraDigitada].toUpperCase()+"' nao pertence a palavra\n");
	                		erros++;
	                	}
	                	
	                	//verifica as condiçoes do jogo
	                	StatusJogo(letrasDigitadas,letrasPalavra,erros);
	                	if(letrasAcertadas == palavraJogo.length()) {
	                		acertouPalavra = true;
	                	}
	                	if(acertouPalavra){
	                		System.out.print("\nvoce acertou a palavra: "+palavraJogo+"!!!!! fim de jogo\n");
	                		fimJogo = true;
	                	}
	                	if(erros>=5) {
	                		System.out.print("\nvoce errou 5 vezes!!! fim de jogo\n");
	                		fimJogo = true;
	                	}
	                	indexLetraDigitada++;
	                	
	                }while(fimJogo == false);
	                	
	            }else 
	            	System.out.print("palavra não selecionada\n");
	            	        
	    	}else
	    		System.out.print("Tema não encontrado\n");
	    	
	    	System.out.print("deseja jogar novamente?'sim' ou 'nao' \n");
	    	
            if(read.nextLine().toLowerCase().equals("sim")){
            	jogarNovamente = true;
            }
		}while(jogarNovamente);
    }
    static void StatusJogo(String[]letrasDigitadas, char[]letrasPalavra , int erros){
    	    /* mostra para o usuario o status do jogo apresentado a palvra isterio com '****' e 
    	     * quando ele digitar uma letra correta substui o caracter * pela letra correspodente
    	     * 
    	     * */
    			boolean aparece = false;
    			System.out.print("misterio: ");
    			for(int j = 0;j<letrasPalavra.length;j++) {
    				aparece = false;
    				for(int i = 0 ; i<letrasDigitadas.length;i++) {
    					if(letrasDigitadas[i] != null){
    						if(letrasDigitadas[i].equals(String.valueOf(letrasPalavra[j]) )){
    							aparece = true;	   						
    						}		  
    					}
    				}
    				if(aparece) {
    					System.out.print(" "+letrasPalavra[j] );
    				}else System.out.print(" *");
    			}
    			System.out.print("   chances: "+(5-erros));
    			System.out.print("   letras digitas: ");
    			for(int i = 0 ; i<letrasDigitadas.length;i++) {
    				if(letrasDigitadas[i] != null){
    					System.out.print(" "+letrasDigitadas[i]);
    				}
    			}
    			System.out.print("\n");
    }
    static void Sair() {
    	  System.out.print("Você saiu. Obrigado por jogar!!\n");       
    }
    static void DisplayTabela() {
    	/* printa a matriz que contem todos os temas e palavras cadastradas 
    	 * */
    	
    	if(palavras[0][0] != null){
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
    	}else System.out.print("nenhuma plavra cadastrada\n");
    }
    static void CadastroAutomatico() {
    	/*castrada autamenticamente temas e palavras previamente selecionados.
          porém sobreecreve qualquer palavra ou tema anteriomente cadastradas.    	
    	*/
    	
    	// cadastroAuto deve ter tamanho [5][11];
    	String[][] cadastroAuto = 	{{"animal","girafa","elefante","macaco","tubarao","formiga","abelha","rinocerante","minhoca","esponja do mar","agua viva"},
							    	 {"comida","macarrao","arroz","feijao","tiramisu","pizza","lasanha","pao de queijo","paella","stronoff","ovo frito"},
							    	 {"objeto","caneta","lapis","borracha","caderno","computador","celular","carteira","esmalte","lampada","oculos"},
							    	 {"pais","brasil","grecia","turquia","china","russia","roma","australia","filipinas","nova zelandia","nepal"},
							    	 {"filme","procurando nemo","mulan","senhor dos aneis","clube da luta","the joker","bastardos inglorios","django livre","o fabuloso destino de amelie poulain","memento","o estranho mundo de jack"} };
							    								    	
    			for(int linha = 0;linha<5;linha++){
					for(int coluna = 0;coluna<11;coluna++){
						palavras[linha][coluna] = cadastroAuto[linha][coluna];
						}
    				}
    	
    }
    public static int generateRandomIntIntRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
