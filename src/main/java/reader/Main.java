package reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //readFileWithScanner("plik.txt");
        //readFileWithReader("plik.txt");

        //fileStatistics("plik.txt");
        int[] stats = new int[100];

        String numbers = parseLotteryFile("numbers.csv");
        System.out.println(numbers);
        String[] splittedNumbers = numbers.split(" ");
        System.out.println(Arrays.toString(splittedNumbers));
        for (int i = 0; i < splittedNumbers.length; i++) {
            int a = Integer.parseInt(splittedNumbers[i]);
            stats[a]++;

        }
        System.out.println(Arrays.toString(stats));

        int max = getMax(stats);

        System.out.println("1 element najbardziej liczny to: " + max + " i pojawia się tyle razy: " + stats[max]);
        stats[max] = 0;

        max = getMax(stats);
        System.out.println("2 element najbardziej liczny to: " + max + " i pojawia się tyle razy: " + stats[max]);
        stats[max] = 0;

        max = getMax(stats);
        System.out.println("3 element najbardziej liczny to: " + max + " i pojawia się tyle razy: " + stats[max]);
        stats[max] = 0;

        max = getMax(stats);
        System.out.println("4 element najbardziej liczny to: " + max + " i pojawia się tyle razy: " + stats[max]);
        stats[max] = 0;

        max = getMax(stats);
        System.out.println("5 element najbardziej liczny to: " + max + " i pojawia się tyle razy: " + stats[max]);
        stats[max] = 0;
    }

    private static int getMax(int[] stats) {
        int max = 0;
        for (int i = 0; i < stats.length; i++) {
            if (stats[max] < stats[i]) {
                max = i;
            }
        }
        return max;
    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    //swap elements
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }


    private static String parseLotteryFile(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(file);) {
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splittedLine = line.split(",");

                sb.append(splittedLine[1]);
                sb.append(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("plik nie istnieje");
        }
        return sb.toString();
    }

    private static void fileStatistics(String fileName) {
        String element = readFileToString(fileName);
        System.out.println(element);
        String[] wyrazy = element.split("\\s+");
        System.out.println("ilość wyrazów: " + wyrazy.length);
        System.out.println("ilośc wszystkich znaków: " + element.length());

        long countWhiteSpace = element.chars().filter(ch -> Character.isWhitespace(ch)).count();
        System.out.println("ilość białych znaków: " + countWhiteSpace);

        long countBlackSpace = element.chars().filter(ch -> Character.isAlphabetic(ch)).count();
        System.out.println("countBlackSpace = " + countBlackSpace);
        System.out.println("sprawdzenie: " + (element.length() - countWhiteSpace));
    }

    private static String readFileToString(String fileName) {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();

        try (Scanner sc = new Scanner(file);) {
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
                sb.append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("plik nie istnieje");
        }
        return sb.toString();
    }

    private static void readFileWithScanner(String fileName) {
        File file = new File(fileName);

        try (Scanner sc = new Scanner(file);) {
            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                System.out.println("nextLine = " + nextLine);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("plik nie istnieje");
        }
    }

    private static void readFileWithReader(String filename) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BufferedReader bfr = new BufferedReader(fileReader);
        String line = null;

        while (true) {
            try {
                line = bfr.readLine();
                if (line != null) {

                    System.out.println(line);
                } else {
                    break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
