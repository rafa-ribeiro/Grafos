/**
 * Classe No representa um n� do grafo.
 * 
 * @author Rafael Ribeiro
 *
 */
public class No {
	Adjacencia info; //objeto da classe Adjacencia, armazena um v�rtice adjacente, sua marca e o custo da aresta
	No proximo; //objeto da classe No que armazena o n� seguinte
	
	
	//Cria um n�
	void criarNo(Adjacencia info, No proximo){
		this.info = info;
		this.proximo = proximo;
	}
	
	//Atribui ao campo info o valor de adj
	void alterarInfo(Adjacencia adj){
		info = adj;
	}
	
	//Devolve o campo info do n�
	Adjacencia obterInfo(){
		return info;
	}
	
	//Atribui ao pr�ximo o n� p
	void alterarProximo(No p){
		proximo = p;
	}
	
	//Devolve o endere�o do pr�ximo n�.
	//Deolve null caso n�o haja seguinte
	No obterProximoNo(){
		return proximo;
	}
	
	/*
	 * Devolve o v�rtice contido em No
	 */
	int obterVerticeNo(){
		return info.obterVertice();
	}
}
