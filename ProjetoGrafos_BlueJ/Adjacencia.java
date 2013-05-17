/**
 * Classe que representa uma adjacencia no grafo.
 * 
 * @author Rafael Ribeiro
 *
 */

public class Adjacencia {
	
	int vertice;
	int marcaAresta;
	float custoAresta;
	
	
	void criarAdjacencia(int v) {
		vertice = v;
		marcaAresta = 0;
		custoAresta = 0;
	}
	
	void criarAdjacencia(int v, int marca){
		vertice = v;
		marcaAresta = marca;
		custoAresta = 0;
	}
	
	void criarAdjacencia(int v, int marca, float custo){
		vertice = v;
		marcaAresta = marca;
		custoAresta = custo;
	}
	
	//Atribui ao campo v�rtice o valor w
	void alterarVertice(int w) {
		vertice = w;
	}
	
	//Devolve o valor do campo v�rtice
	int obterVertice(){
		return vertice;
	}
	
	//Atribui ao campo marcaAresta o valor marca
	void alterarMarca(int marca) {
		marcaAresta = marca;
	}
	
	//Devolve o valor do campo marcaAresta
	int obterMarca(){
		return marcaAresta;
	}
	
	//Atribui ao campo custoAresta o valor p
	void alterarCusto(float p){
		custoAresta = p;
	}
	
	//Devolve o valor do campo custoAresta
	float obterCusto(){
		return custoAresta;
	}
	
	//Compara campo v�rtice: se menor do que o de adj, devolve o valor negativo -1, se igual, devolve o valor zero e se maior, devolve o valor positivo +1
	int compararVertice(Adjacencia adj){
		int val;
		
		if (this.vertice < adj.vertice)
			val = -1;
		else if (this.vertice == adj.vertice)
			      val = 0;
			 else val = 1;
		
		return val;
	}
	
}
