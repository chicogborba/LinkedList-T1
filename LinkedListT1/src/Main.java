import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            if (i % 1000 == 0)
                System.out.println("Mais 1000...");
            lista.add(rand.nextInt(1000));
        }
        System.out.println("A lista tem " + lista.size() + " elementos.");
        System.out.println(lista.toString());
    }
}