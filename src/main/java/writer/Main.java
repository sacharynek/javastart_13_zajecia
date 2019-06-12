package writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Product p1 = new Product("Samochod", "VW", 100000);
        Product p2 = new Product("Długopis", "Pentel", 10.0);
        Product p3 = new Product("Laptop", "Lenovo", 18000);

        Product[] tab = new Product[3];
        tab[0] = p1;
        tab[1] = p2;
        tab[2] = p3;

        FileWriter fw = new FileWriter("pliczek.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        for (int i = 0; i < tab.length; i++) {
            bw.write(tab[i].toString());

            bw.newLine();

        }
        bw.flush();

        Product[] tab2 = parseProductFile("pliczek.txt");
        System.out.println(Arrays.toString(tab2));
    }


    private static Product[] parseProductFile(String fileName) {
        File file = new File(fileName);
        Product[] produkty = new Product[3];
        int counter = 0;

        try (Scanner sc = new Scanner(file);) {
            while (sc.hasNextLine()) {
                produkty[counter] = Product.parseProduct(sc.nextLine());
                counter++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("plik nie istnieje");
        }
        return produkty;
    }


}
