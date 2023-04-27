
public class LinkedListOfIntegerDoubleCurrent {

    // Classe interna Node
    private class Node {
        public Integer element;
        public Node next;

        public Node(Integer element) {
            this.element = element;
            next = null;
        }

        public Node(Integer element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    // Referência para o primeiro elemento da lista encadeada.
    private Node head;
    // Referência para o último elemento da lista encadeada.
    private Node tail;
    // Contador para a quantidade de elementos que a lista contem.
    private int count;
    // Contador para quantidade de vezes que o aux = aux.next foi executado
    private int countAux;
    // Ultimo elemento acessado na lista
    private Node current;
    // Penultimo elemento acessado na lista
    private Node current2;
    // Indice do ultimo elemento acessado na lista
    private int currentIndex;
    // Indice do penultimo elemento acessado na lista
    private int currentIndex2;

    /**
     * Construtor da lista.
     */
    public LinkedListOfIntegerDoubleCurrent() {
        head = null;
        tail = null;
        count = 0;
        countAux = 0;
        current = null;
        current2 = null;
        currentIndex = -1;
        currentIndex2 = -1;
    }

    /**
     * Retorna o numero de elementos da lista.
     * 
     * @return o numero de elementos da lista
     */
    public int size() {
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) { // O(1)
        Node n = new Node(element);
        if (head == null) {
            head = n;
        } else {
            tail.next = n;
        }
        tail = n;

        count++;
    }

    ////////////////////////////////////////////////////////////////

    /**
     * Insere um elemento em uma determinada posicao da lista.
     * 
     * @param index   a posicao da lista onde o elemento sera inserido
     * @param element elemento a ser inserido
     * @throws IndexOutOfBoundsException se (index < 0 || index > size())
     */
    public void add(int index, Integer element) { // O(n)
        // Primeiro verifica se index eh valido
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException(); // erro

        // Depois cria o nodo e incrementa count
        Node n = new Node(element);
        count++;

        // "Encadear" o nodo criado na lista
        if (index == 0) { // Insercao no inicio
            if (head == null) { // se a lista estava vazia
                tail = n;
            } else {
                n.next = head;
            }
            head = n;
        } else if (index == count) { // Insercao no fim
            tail.next = n;
            tail = n;
        } else { // Insercao no meio
            Node ant = head;
            for (int i = 0; i < index - 1; i++)
                ant = ant.next;
            n.next = ant.next;
            ant.next = n;
        }
        current2 = current;
        current = n;
        currentIndex2 = currentIndex;
        currentIndex = index;
    }

    /**
     * Remove o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento que foi removido da lista
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public Integer removeByIndex(int index) {
        // Primeiro verifica se index eh valido
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException(); // erro

        // Se remocao do primeiro elemento da lista
        if (index == 0) {
            Integer elem = head.element;
            head = head.next;
            if (count == 1) // se tinha apenas 1 elemento na lista
                tail = null;
            count--; // atualiza o contador
            current2 = current;
            current = head;
            currentIndex2 = currentIndex;
            currentIndex = 0;
            return elem;
        }

        // Se remocao do ultimo ou do meio
        Node aux;
        Node ant = null;
        if (index > currentIndex2 && current2 != null) {
            aux = current2;
            for (int i = currentIndex2; i < index; i++) {
                ant = aux;
                aux = aux.next == null ? head : aux.next;
                countAux++;
            }
        } else if (index > currentIndex && current != null) { // buscar a partir do nó atual
            aux = current;
            for (int i = currentIndex; i < index; i++) {
                ant = aux;
                aux = aux.next == null ? head : aux.next;
                countAux++;
            }
        } else { // buscar a partir da cabeça da lista
            aux = head;
            for (int i = 0; i < index; i++) {
                ant = aux;
                aux = aux.next;
                countAux++;
            }
            // atualiza o nó atual e o índice atual
        }
        if (aux == tail) { // se remocao do ultimo
            tail = ant;
            tail.next = null;
        } else { // remocao do meio
            ant.next = aux.next;
        }
        count--;
        current2 = current;
        current = ant;
        currentIndex2 = currentIndex;
        currentIndex = index - 1;
        return aux.element;
    }

    /**
     * Retorna o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     * lista nao contem o elemento.
     * 
     * @param element o elemento a ser buscado
     * @return o indice da primeira ocorrencia do elemento na lista, ou -1 se a
     *         lista nao contem o elemento
     */
    public int indexOf(Integer element) {
        Node aux = head;
        for (int i = 0; i < count; i++) {
            if (aux.element.equals(element)) {
                current2 = current;
                current = aux;
                currentIndex2 = currentIndex;
                currentIndex = i;
                return i;
            }
            aux = aux.equals(tail) ? head : aux.next;
            countAux++;
        }
        return -1;
    }

    public String getCountAux() {
        return "countAux: " + countAux;
    }

    public void setCurrentMiddle() {
        current = head;
        for (int i = 0; i < count / 2; i++) {
            current = current.next;
        }
    }
}
