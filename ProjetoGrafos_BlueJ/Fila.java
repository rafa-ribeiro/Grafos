import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa uma estrutura de dados do tipo Fila .
 * 
 * @author Rafael Ribeiro
 *
 */

public class Fila {
	//int fila[];
	List <Integer> fila = new ArrayList <Integer>();	//array de n�meros inteiros positivos
	int primeiro;										// indicador do primeiro da fila
	int ultimo;											//indicador do �ltimo elemento da fila
	int nElementos;										//n�mero de elemetnos contido na fila
	int tamanhoMax;										//tamanho m�ximo da fila
	
	/*
	 * Cria uma fila vazia
	 */
	public void criarFila() {
		nElementos = 0;
		primeiro = -1;
		ultimo = -1;
	}
	
	
	/*
	 * Devolve true se a fila est� vazia
	 */
	public boolean estarVazia() {
		boolean vazia = false;
		
		if (nElementos == 0) vazia = true;
		
		return vazia;
	}
	
	
	/*
	 * Coloca o valor v na fila e devolve true. Caso n�o seja poss�vel, devolve false.
	 */
	public boolean colocar(int v){
		boolean ok = false;
		if (nElementos < tamanhoMax) {
			fila.add(v);
			
			if (nElementos == 0) { //Se nElementos for igual a 0, � porque a fila estava vazia, sendo assim, temos um �nico elemento na fila que � o primeiro e o �ltimo ao mesmo tempo.
				primeiro = 0;
				ultimo = 0;
			} else {
				ultimo++;
			}
			nElementos++;
		}
		return ok;
	}
	
	
	/*
	 * Devolve o primeiro elemento da fila e o retira da fila. 
	 * Caso a fila seja vazia, devolve o valor -1. 
	 */
	public int retirar(){
		int item = -1;
		
		if (nElementos > 0) {
			item = fila.get(0);
			fila.remove(0);
			nElementos--;
			ultimo--;
			if (nElementos == 0) {
				primeiro = -1;
				ultimo = -1;
			}
		}
		return item;
	}
	
	
	/*
	 * Devolve o primeiro elemento da fila. Caso a fila seja vazia, devolve o valor -1.
	 */
	public int acessarPrimeiro(){
		int inicio = -1;
		
		if (nElementos > 0) {
			inicio =  fila.get(0);
		}
		return inicio;
	}
	
	
	/*
	 * Devolve o �ltimo elemento da fila. Caso a fila seja vazia, devolve o valor -1.
	 */
	public int acessarUltimo(){
		int fim = -1;
		
		if (nElementos > 0) {
			fim = fila.get(ultimo);
		}
		return fim;
	}
	
}
