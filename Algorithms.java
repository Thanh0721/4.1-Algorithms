import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Algorithms {
    private static File f;
    private static Scanner s;

    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");

        int odds = odds();
        int evens = evens();
        int twoDigitNumbers = countTwoDigitNumbers();
        int numbersGreaterThan500 = countGreaterThan500();
        int greatestNumber = findGreatestNumber();
        int leastNumber = findLeastNumber();
        long sumOfNumbers = calculateSum();
        double meanOfNumbers = calculateMean();
        int modeOfNumbers = calculateMode();

        System.out.println("Total odd numbers: " + odds);
        System.out.println("Total even numbers: " + evens);
        System.out.println("Total two digit numbers: " + twoDigitNumbers);
        System.out.println("Total numbers greater than 500: " + numbersGreaterThan500);
        System.out.println("Greatest number: " + greatestNumber);
        System.out.println("Least number: " + leastNumber);
        System.out.println("Sum: " + sumOfNumbers);
        System.out.println("Mean: " + meanOfNumbers);
        System.out.println("Mode: " + modeOfNumbers);

        s.close();
    }

    public static int odds() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNextInt()) {
            if (s.nextInt() % 2 != 0)
                count++;
        }
        return count;
    }

    public static int evens() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNextInt()) {
            if (s.nextInt() % 2 == 0)
                count++;
        }
        return count;
    }

    public static int countTwoDigitNumbers() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNextInt()) {
            int num = s.nextInt();
            if (num >= 10 && num <= 99)
                count++;
        }
        return count;
    }

    public static int countGreaterThan500() throws FileNotFoundException {
        s = new Scanner(f);
        int count = 0;
        while (s.hasNextInt()) {
            if (s.nextInt() > 500)
                count++;
        }
        return count;
    }

    public static int findGreatestNumber() throws FileNotFoundException {
        s = new Scanner(f);
        int max = Integer.MIN_VALUE;
        while (s.hasNextInt()) {
            int num = s.nextInt();
            if (num > max)
                max = num;
        }
        return max;
    }

    public static int findLeastNumber() throws FileNotFoundException {
        s = new Scanner(f);
        int min = Integer.MAX_VALUE;
        while (s.hasNextInt()) {
            int num = s.nextInt();
            if (num < min)
                min = num;
        }
        return min;
    }

    public static long calculateSum() throws FileNotFoundException {
        s = new Scanner(f);
        long sum = 0;
        while (s.hasNextInt()) {
            sum += s.nextInt();
        }
        return sum;
    }

    public static double calculateMean() throws FileNotFoundException {
        s = new Scanner(f);
        long sum = 0;
        int count = 0;
        while (s.hasNextInt()) {
            sum += s.nextInt();
            count++;
        }
        return Math.round((double) sum / count * 1000.0) / 1000.0;
    }

    public static int calculateMode() throws FileNotFoundException {
        s = new Scanner(f);
    
        int mode = 0;
        int maxFrequency = 0;
    
        while (s.hasNextInt()) {
            int current = s.nextInt();
            int frequency = 0;
    
            Scanner innerScanner = new Scanner(f);
            while (innerScanner.hasNextInt()) {
                if (innerScanner.nextInt() == current) {
                    frequency++;
                }
            }
            innerScanner.close();
    
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mode = current;
            }
        }
    
        return mode;
    }
}
