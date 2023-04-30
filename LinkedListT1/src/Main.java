// Nomes: Francisco Borba e Matheus Magri

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();

        // Adicionando 100.000 elementos em cada uma das listas das 3 etapas
        LinkedListOfInteger lista1 = new LinkedListOfInteger();
        for (int i = 0; i < 100000; i++) {
            lista1.add(rand.nextInt(1000));
        }

        LinkedListOfIntegerCurrent lista2 = new LinkedListOfIntegerCurrent();
        for (int i = 0; i < 100000; i++) {
            lista2.add(rand.nextInt(1000));
        }

        // Colocando 100 currents espalhados pela lista 3
        LinkedListOfIntegerMultiCurrent lista3 = new LinkedListOfIntegerMultiCurrent(100);
        for (int i = 0; i < 100000; i++) {
            lista3.add(rand.nextInt(1000));
        }
        // Distribuindo os currents pela lista
        lista3.spreedCurrents();

        // Gerando 10.000 operacoes aleatorias de add, indexOf e removeByIndex
        // aleatoriamente
        for (int i = 0; i < 10000; i++) {
            // A cada 100 operacoes, atualiza o current para o meio da lista
            if (i % 100 == 0) {
                lista2.setCurrentMiddle();
            }

            // Gera um numero que define qual operacao sera executada
            int op = rand.nextInt(3);
            // Gera um indice aleatorio
            int index = rand.nextInt(lista1.size());
            // Gera um elemento aleatorio
            int element = rand.nextInt(1000);

            // Escolhe qual operacao sera executada usando o numero gerado "op"
            switch (op) {
                case 0:
                    lista1.add(index, element);
                    lista2.add(index, element);
                    lista3.add(index, element);
                    break;
                case 1:
                    lista1.indexOf(element);
                    lista2.indexOf(element);
                    lista3.indexOf(element);
                    break;
                case 2:
                    lista1.removeByIndex(index);
                    lista2.removeByIndex(index);
                    lista3.removeByIndex(index);
                    break;
            }
        }

        // Imprime os resultados das 3 etapas
        System.out.println("\n----- Etapa 1 -----");
        System.out.println(lista1.getCountAux());
        System.out.println("-------------------");

        System.out.println("\n----- Etapa 2 -----");
        System.out.println(lista2.getCountAux());
        System.out.println("-------------------");

        System.out.println("\n----- Etapa 3 -----");
        System.out.println(lista3.getCountAux());
        System.out.println("-------------------");
    }
}