import java.util.ArrayList;
import java.util.List;


/**
 * Classe que representa um Grafo.
 * 
 * @author Rafael Ribeiro
 *
 */

public class Grafos {
    List <ListaLigada> adj;
    int nVertices;
    
    
    /*
     * Cria um grafo totalmente desconexo com n v�rtices
     * 
     */
    public void criarGrafo(int n) {
        adj = new ArrayList <ListaLigada>();
        nVertices = n;
        int i;
        
        for (i = 0; i < n; i++){
            ListaLigada lista = new ListaLigada();
            lista.criarLista();
            adj.add(lista);
        }
    }
    
    
    /*
     * Cria um grafo totalmente completo com n v�rtices
     */
    void criarCompleto(int n) {
        adj = new ArrayList <ListaLigada>();
        nVertices = n;
        int i, k;
        
        for (i = 0; i < n; i++){
            ListaLigada lista = new ListaLigada();
            lista.criarLista();
            adj.add(lista);
            //adj.add(lista.criarLista());
        }
        
        for (i = 0; i < n; i++) {
            for (k = 0; k < n; k++){
                if (i != k) {
                    Adjacencia adjacente = new Adjacencia();
                    adjacente.criarAdjacencia(k);
                    
                    adj.get(i).inserirNoFim(adjacente);
                }
            }   
        }   
    }
    
    
    /*
     * Devolve o n�mero de v�rtices de um grafo Simples
     */
    int obterNumVertices() {
        return nVertices;
    }
    
    /*
     * Devolve o n�mero de arestas do grafo
     */
    int obterNumArestas(){
        int qtdArestas = 0;
        int i;
    
        for (i = 0; i < nVertices; i++){
            qtdArestas = qtdArestas + adj.get(i).obterTamanho();
        }
        
        qtdArestas = qtdArestas / 2;
        return qtdArestas;
    }
    
    /*
     * Acrescenta um v�rtice ao grafo.
     */
    void acrescentarVertice() {
        ListaLigada lista = new ListaLigada();
        lista.criarLista();
        
        adj.add(lista);
        nVertices++;    
    }
    
    /*
     * Acrescenta a aresta (a,b) a um grafo simples.
     */
    void inserirAresta(int a, int b){
        int tam;
        boolean arestaOk;
        
        if (((a >= 0) && (a < nVertices)) && ((b >= 0) && (b < nVertices))) {
            tam = adj.get(a).obterTamanho();
            Adjacencia adIn;
            Adjacencia adOut;
            adIn = new Adjacencia();
            adIn.criarAdjacencia(b);
            adOut = new Adjacencia();
            adOut.criarAdjacencia(a);
            
            if (tam == 0) { //se igual a 0, ainda n�o h� nenhuma adjacencia, portanto, basta criar a nova adjacencia.
                adj.get(a).inserirNoFim(adIn);
                adj.get(b).inserirNoFim(adOut);
            } else {
                arestaOk = adj.get(a).buscarInserir(adIn);
                if (arestaOk == true) adj.get(b).inserirNoFim(adOut);   
                
            }
        }
        
    }
    
    /*
     * Remove a aresta (a,b) de um grafo simples
     */
    void removerAresta(int a, int b){
        boolean existeAresta;
        Adjacencia adA, adB;
        
        if (((a >= 0) && (a < nVertices)) && ((b >= 0) && (b < nVertices))) {
            adB = new Adjacencia();
            adB.criarAdjacencia(b);
        
            existeAresta = adj.get(a).buscarAdj(adB);
            if (existeAresta == true) {
                adA = new Adjacencia();
                adA.criarAdjacencia(a);
                
                adj.get(a).remover(adB);
                adj.get(b).remover(adA);
                
            }
        }
    }
    
    
    /*
     * Devolve o grau do v�rtice v.
     */
    int obterGrau(int v) {
        int grau = 0;
        
        
        if ((v >= 0) && (v < nVertices)) {
            grau = adj.get(v).obterTamanho();
        }
        
        return grau;
    }
    
    
    /*
     * Devolve o primeiro v�rtice adjacente ao v�rtice v. Devolve o valor -1 caso grau de v seja zero.
     * 
     */
    int obterPrimeiroAdj(int v){
        int priAdj = -1;
        
        if ((v >= 0) && (v < nVertices)) {
            if (adj.get(v).obterTamanho() > 0){
                priAdj = adj.get(v).obterPrimeiroNo().obterVerticeNo();
            }
        }
        
        return priAdj;
    }
    
    /*
     * Devolve o pr�ximo v�rtice adjacente ao v�rtice v. Devolve o valor -1 se n�o existir um proximo.
     */
    int obterProximoAdj(int v) {
        int proxAdj = -1;
        No aux;
        if ((v >= 0) && (v < nVertices)) {
            aux = new No();
            if (adj.get(v).obterTamanho() > 0){
                //proxAdj = adj.get(v).obterProximoNo().obterVerticeNo();
                aux = adj.get(v).obterProximoNo();
                if (aux != null) {
                    proxAdj = aux.obterVerticeNo();
                } else {
                    proxAdj = -1;
                }
            }
        }
        return proxAdj;
    }
    
    /*
     * Marca todas as arestas do grafo com o valor de marca.
     */
    void inicializarMarcaAresta(int marca){
        int i;
        Adjacencia aux;
        No no;
        
        for (i = 0; i < nVertices; i++) {
            if (adj.get(i).obterTamanho() > 0) {
                no = adj.get(i).obterPrimeiroNo();
                
                while (no != null) {
                    aux = no.obterInfo(); //recebe o objeto da classe adjacencia contida em No
                    aux.alterarMarca(marca);
                    
                    no = adj.get(i).obterProximoNo();                   
                }
            }
        }
            
    }
    
    
    /*
     * Marca a aresta (a,b) de um grafo simples, com o valor de marca.
     */
    void marcarAresta(int a, int b, int marca) {
        No no;
        Adjacencia aux, adA, adB;
        
        if (((a >= 0) && (a < nVertices)) && ((b >= 0) && (b < nVertices))) { //verifica se a aresta (a,b) faz parte do grafo.
            adA = new Adjacencia();
            adA.criarAdjacencia(a);
            adB = new Adjacencia();
            adB.criarAdjacencia(b);
            
            no = adj.get(a).buscar(adB);
            
            if (no != null) { //se no != null, existe a aresta (a,b) no grafo, logo podemos marca-la
                aux = no.obterInfo();
                aux.alterarMarca(marca);
                
                no = adj.get(b).buscar(adA); //n�o � necess�rio verificar novamente se no != null, pois num grafo simples, se existe a aresta (a,b) tamb�m existe a aresta (b,a)
                aux = no.obterInfo();
                aux.alterarMarca(marca);    
            }
        }
    }
    
    /*
     * Devolve o valor da marca da aresta (a,b).
     */
    int obterMarcaAresta(int a, int b) {
        int marca = 0;
        
        No no;
        Adjacencia aux, adB;
        
        if (((a >= 0) && (a < nVertices)) && ((b >= 0) && (b < nVertices))) {
            adB = new Adjacencia();
            adB.criarAdjacencia(b);
            
            no = adj.get(a).buscar(adB);
            if (no != null) {
                aux = no.obterInfo();
                marca = aux.obterMarca();
            }
        }
        return marca;
    }
    
    /*
     * Verifica se existe a aresta (a,b). Se existir devolve TRUE, caso contr�rio, devolve FALSE.
     */
    boolean existirAresta(int a, int b) {
        boolean existe = false;
        No no;
        Adjacencia adB;
        
        if (((a >= 0) && (a < nVertices)) && ((b >= 0) && (b < nVertices))) {
            adB = new Adjacencia();
            adB.criarAdjacencia(b);
            
            no = adj.get(a).buscar(adB);
            if (no != null) {
                existe = true;
            }
        }
        
        return existe;
    }
    
}
