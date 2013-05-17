/**
 * Classe que representa uma estrutura de dados do tipo Tabela.
 * 
 * @author Rafael Ribeiro
 *
 */

public class Tabela {
    int vetor[]; //array de n�meros inteiros
    int nElementos; //armazena o n�mero de elementos da tabela
    int tamanhoMax; //armazena o tamanho m�ximo da tabela
    int marca; //Valor definido para inicializar uma tabela vazia.
    
    /*
     * Cria uma tabela vazia (nElementos = 0) ?????????
     */
    void criarTabela(int tam) {
        nElementos = 0;
        tamanhoMax = tam;
        vetor = new int[tamanhoMax];
        nElementos = 0;
    }
    
    
    
    /*
     * Cria uma tabela com n� de elementos igual a nVezes, com valor w.
     */
    void inicializarTabela(int nVezes, int w){
        int i;
        marca = w;
        tamanhoMax = nVezes;
        vetor = new int[tamanhoMax];
        nElementos = nVezes;
        
        for (i=0; i < tamanhoMax; i++){
            vetor[i] = marca;
        }
        
    }
    
    /*
     * Devolve o n�mero de elementos da tabela
     */
    int obterNumElementos(){
        return nElementos;
    }
    
    /*
     * Devolve true se a tabela � vazia
     */
    boolean estarVazia(){
        boolean vazia = false;
        
        if (nElementos == 0) vazia = true;
        
        return vazia;
    }
    
    
    /*
     * Atribui o valor novoValor na posi��o indicada por pos
     */
    void alterarValor(int pos, int novoValor){
        
        if (pos < nElementos)  vetor[pos] = novoValor;
    }
    
    /*
     * Devolve o valor registrado na posi��o indicada por pos
     */
    int obterValor(int pos) {
        int valor = -1;
        
        if (pos < nElementos) {
            valor = vetor[pos];
        }
        
        return valor;
    }
    
    /*
     * Insere no final da tabela o valor novo
     */
    boolean inserirNoFim(int novo){
        boolean ok = false;
        
        if (nElementos < tamanhoMax){
            vetor[nElementos] = novo;
            nElementos++;
            ok = true;
        }
        
        return ok;
    }
    
    /*
     * Busca na tabela o valor item e devolve a posi��o encontrada. 
     * Caso n�o encontre, devolve o valor -1. 
     */
    int buscar(int item){
        int pos = -1;
        int k = 0;
        
        while ((k < tamanhoMax) && (pos == -1)) {
            if (item == vetor[k]) 
                pos = k;
            k++;
        }
        
        return pos;
    }
    
    
    /*
     * Busca o valor novo na tabela, devolvendo a posi��o encontrada,
     * caso n�o encontre, insere no final da tabela;
     * devolve o valor -1 somente se n�o � poss�vel inserir.
     */
    int buscarInserir(int novo){
        int pos = -1;
        int k = 0;
        
        
        while ((k < tamanhoMax) && (pos == -1)) {
            if (novo == vetor[k]) 
                pos = k;
            k++;
        }
        
        if (pos == -1) {
            if (nElementos < tamanhoMax){
                vetor[nElementos] = novo;
                nElementos++;
            }
        }
        
        return pos;
    }
    
    
    /*
     * Remove da tabela o valor que se encontra na posi��o pos.
     */
    boolean remover(int pos) {
        boolean removido = false;
        
        if (nElementos > 0) {
            vetor[pos] = marca;
            removido = true;
            nElementos--;
        }
        
        return removido;
    }
    
    /*
     * Busca na tabela o valor item, removendo se o encontrar.
     * Devolve false somente se n�o encontrar o item.
     */
    boolean buscarRemover(int item) {
        boolean removido = false;
        int j = 0;
        
        while ((j < tamanhoMax) && (removido == false)) {
            if (item == vetor[j]) {
                vetor[j] = marca;
                removido = true;
                nElementos--;
            }
            j++;
        }
        
        return removido;
    }
    
    /*
     * Devolve a posi��o do menor elemento da tabela. Caso a tabela seja vazia, devolve 0.
     */
    int obterMenor() {
        int pos = 0;
        int menor;
        int k; int j=0;
        
        if (nElementos > 0) {
            while ((j < tamanhoMax) && (vetor[j] == marca)) {
                j++;
            }
            if (j < tamanhoMax) {
                menor = vetor[j];
                for (k = j+1; k < tamanhoMax; k++){
                    if ((vetor[k] != marca) && (vetor[k] < menor)) {
                        menor = vetor[k];
                        pos = k;
                    }
                }
            }
        }
        return pos;
    }
    
    
    /*
     * Devolve a posi��o do maior elemento da tabela. Caso a tabela seja vazia, devolve 0. 
     */
    int obterMaior() {
        int pos = 0;
        int maior;
        int k; int j=0;
        
        if (nElementos > 0) {
            while ((j < tamanhoMax) && (vetor[j] == marca)) {
                j++;
            }
            if (j < tamanhoMax) {
                maior = vetor[j];
                for (k = j+1; k < tamanhoMax; k++){
                    if ((vetor[k] != marca) && (vetor[k] > maior)) {
                        maior = vetor[k];
                        pos = k;
                    }
                }
            }
        }
        
        return pos;
    }
    
    /*
     * Ordena os elementos da tabela em ordem crescente (ou n�o decrescente)
     */
    void ordenarCrescente() {
        int inicio, fim;
        inicio = 0;
        fim = tamanhoMax - 1;
        quicksort(vetor, inicio, fim);
    }
    
    
    private static void quicksort(int v[], int ini, int fim) {
        int meio;
        
        if (ini < fim) {
            meio = separarLista( v, ini, fim);
            quicksort(v, ini, fim -1);
            quicksort( v, meio + 1, fim);
        }
    }
    
    private static int separarLista(int v[], int ini, int fim) {
        int meio;
        int aux;
        int i;
        
        i = ini;
        meio = fim + 1;
        while (i < meio) {
            do { 
                i= i + 1;
            } while ((v[i] < v[ini]) && (i != fim));
            
            do {
                meio = meio - 1;
            } while (v[meio] > v[ini]);
            
            if (i < meio) {
                aux = v[i];
                v[i] = v[meio];
                v[meio] = aux;
            }
        }
        aux = v[ini];
        v[ini] = v[meio];
        v[meio] = aux;
        
        return meio;
    }
    
}
