
/**
 * Classe que representa uma estrutura de dados do tipo ListaLigada.
 * 
 * @author Rafael Ribeiro
 *
 */

public class ListaLigada {
	No inicio;    // - Objeto da classe No, que armazena o primeiro n� da lista ligada. 
	No fim;       // - Objeto da classo No, que armazena o �ltimo n� da lista ligada.
	No corrente;  // - Objeto da classe No, que armazena o n� corrente da lista ligada.
	private int tamanho;  // - N�meiro inteiro que representa o tamanho da lista ligada.
	
	
	void criarLista() {
		tamanho = 0;
		inicio = null;
		corrente = null;
		fim = null;
		
	}
	
	//Devolve true se a lista � vazia, false, caso contr�rio.
	boolean estarVazia(){
		boolean vazia = false;
		if (tamanho == 0)
			vazia = true;
		
		return vazia;
	}
	
	//Devolve o tamanho da lista
	int obterTamanho(){
		return tamanho;
	}
	
	//Devolve o endere�o do primeiro n�, deixando corrente apontado para o mesmo. Se a lista � vazia, devolve null
	No obterPrimeiroNo(){
		corrente = inicio;
		return inicio;
	}
	
	//Devolve o endere�o do n� seguinte ao apontado pelo corrente. Caso corrente aponte o �ltimo n�, devolve valor null. Caso corrente tenha o valor null, devolve o primeiro n�. Caso a lista seja vazia, devolve null
	No obterProximoNo(){
		No aux = null;
		
		if (tamanho > 0) {
			if (corrente == null) {
				aux = inicio;
				corrente = aux; //o valor de corrente � alterado, para que sempre que o m�todo obterProximoNo for chamado, ele acompanha a mudan�a na lista, caso n�o seja alterado, sempre retornar� o mesmo valor que est� armazenado em corrente.
			} else {
				aux = corrente.proximo;
				corrente = aux;
			}
		}
		return aux;
	}
	
	//Insere um objeto vadj no �nicio da lista, deixando corrente no primeiro n�
	boolean inserirNoInicio(Adjacencia vadj){
		boolean ok = false;
		
		
		if (vadj != null) {
			No aux = new No();
			aux.criarNo(vadj, null);
		
			if (tamanho == 0) {
				fim = aux;
			} else {
				aux.alterarProximo(inicio);	
			}
			inicio = aux;
			corrente = aux;
			tamanho++;
			ok = true;
		}
		return ok;
	}
	
	//Insere um objeto vadj no final da lista, deixando corrente no primeiro n�. 
	boolean inserirNoFim(Adjacencia vadj){
		boolean ok = false;
		
		if (vadj != null){
			No aux = new No();
			aux.criarNo(vadj, null);
			
			if (tamanho == 0){
				inicio = aux;
			} else {
				fim.alterarProximo(aux);
			}
			fim = aux;
			corrente = inicio;
			tamanho++;
			ok = true;
		}
		return ok;
	}
	
	//Remove o n� que cont�m o v�rtice referenciado por vadj. Se a lista � vazia, devolve false, caso contr�rio, devolve true.
	boolean remover(Adjacencia vadj){
		boolean ok = false; boolean achou = false;
		
		
		if (tamanho > 0){
			No ant = null;
			No aux = inicio;
			
			Adjacencia vaux;
			
			while((achou == false) && (aux != null )) {
				vaux = aux.info;   // Objeto Adjacencia contido no No auxiliar
				if (vaux.vertice == vadj.vertice) {
					achou = true;
				}else{
					ant = aux;
					aux = aux.obterProximoNo(); //No auxiliar
				}
			}
			if (achou == true) {
				//Ao sair do loop, no objeto ant, teremos o No anterior ao no que ser� removido.
				//aux cont�m o no a ser removido
				if (ant == null) { //caso ant seja igual a null, o no a ser removido � o primeiro da lista
					inicio = aux.obterProximoNo();
				} else {
					ant.proximo = aux.obterProximoNo();
				}
				ok = true;
				tamanho--;
			}
		}
		
		return ok;
	}
	
	//Realiza uma busca em rela��o ao campo v�rtice. Devolve null se n�o encontrar, caso contr�rio devolve o n� encontrado apotando corrente para o mesmo
	No buscar(Adjacencia vadj){
		No noproc;
		No aux = null;
		boolean achou = false;
		
		if (tamanho > 0) {
			aux = inicio;
			Adjacencia vaux;
			
			while ((achou == false) && (aux != null)) { // cont <= tamanho -> Pode-se tbm verificar por um contador que compara o tamanho da lista ligada
				vaux = aux.info;
				
				if (vaux.vertice == vadj.vertice){
					achou = true;
				} else {
					aux = aux.obterProximoNo();
				}
			}
			if (achou == true) {
				corrente = aux;
			}	
		}
		noproc = aux;
		return noproc;
	}


	//Realiza uma busca em rela��o ao campo v�rtice. Devolve false se n�o encontrar, e true caso encontre o v�rtice.
	boolean buscarAdj(Adjacencia vadj){
		No aux = null;
		boolean achou = false;
		
		if (tamanho > 0) {
			aux = inicio;
			Adjacencia vaux;
			
			while ((achou == false) && (aux != null)) { // cont <= tamanho -> Pode-se tbm verificar por um contador que compara o tamanho da lista ligada
				vaux = aux.info;
				
				if (vaux.vertice == vadj.vertice){
					achou = true;
				} else {
					aux = aux.obterProximoNo();
				}
			}
		}
		return achou;
	}
	
	
	//Realiza uma busca em rela��o ao campo v�rtice, caso encontre, devolve false e corrente aponta para o n� encontrado. Caso N�O encontre, um novo n� � inserido no fim, devolve true e aponta corrente para o mesmo.
	boolean buscarInserir(Adjacencia vadj){
		boolean inseriu = false;
		No aux = null;
		No novo;
		
		if (tamanho == 0) {
			novo = new No();
			novo.criarNo(vadj, null);
			inicio = novo;
			fim = novo;
			corrente = novo;
			tamanho = 1;
			inseriu = true;
		} else {
			aux = inicio;
			Adjacencia vaux;
			boolean achou = false;

			while ((achou == false) && (aux != null)) {
				vaux = aux.info;
				if (vaux.vertice == vadj.vertice){
					achou = true;
				} else {
					aux = aux.obterProximoNo();
				}
			}
			
			if (achou == true) {
				corrente = aux;
			} else {
				//COMO n�o est� explicito na assinatura, escolhi inserir o n� no fim.
				novo = new No();
				novo.criarNo(vadj, null);
				fim.alterarProximo(novo);
				fim = novo;
				tamanho++;
				inseriu = true;
			}
		}
		return inseriu;
	}
	
	
	//Exibe os dados da lista ligada na lista, deixando corrente com valor null.
	void mostrarLista(){
		No aux;
		Adjacencia vaux;
		
		if (tamanho > 0) {
			aux = inicio;
			
			while (aux != null) {
				vaux = aux.info;
				aux = aux.obterProximoNo();
			}
			corrente = null;
		}
	}
	
}
