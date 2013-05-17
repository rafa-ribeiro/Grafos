import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa uma estrutura de dados do tipo Pilha.
 * 
 * @author Rafael Ribeiro
 *
 */

public class Pilha {
	//int pilha[];		// array de n�meros inteiros positivos
	List <Integer> pilha = new ArrayList <Integer>();		// array de n�meros inteiros positivos
	int topo;											// indicador de topo da pilha
	int nElementos;										// n�mero de elementos contido na pilha
	int tamanhoMax;										//tamanho m�ximo da pilha
	
    /*
	 * Cria uma pilha vazia;
	 */
	void criarPilha() {
		nElementos = 0;
		topo = -1;
	}
	
	
	/*
	 * Define um valor para o atributo tamanhoMax 
	 */
	public void alterarTamanhoMax(int qtd){
		tamanhoMax = qtd;
	}
	
	
	/*
	 * Devolve true se a pilha estiver vazia
	 */
	public boolean estarVazia(){
		boolean vazia = false;
		
		if (nElementos == 0) vazia = true;
		
		return vazia;
	}
	
	
	/*
	 * Colocar o valor v na pilha e devolve true, Caso n�o seja poss�vel, devolve false.
	 */
	public boolean colocar(int v){
		boolean ok = false;
		
		if (topo < tamanhoMax - 1) {
			pilha.add(v);
			topo++;
			ok = true;
			nElementos++;
		}
		
		return ok;
	}
	
	
	/*
	 * Devolve o elemento do topo da pilha e o retira da pilha. Caso a pilha seja vazia, devolve o valor zero.
	 */
	public int retirar() {
		int top = -1;
		
		if (topo > -1) {
			top = pilha.get(topo); //semelhante ao, pilha[topo]
			topo--;
			nElementos--;
		}
		
		return top;
	}
	
	
	/*
	 * Devolve o elemento do topo da pilha. Caso a pilha seja vazia, devolve o valor zero.
	 */
	int acessarTopo() {
		int item = -1;
		
		if (topo > - 1) {
			item = pilha.get(topo);
		}
		return item;
	}
	
}
