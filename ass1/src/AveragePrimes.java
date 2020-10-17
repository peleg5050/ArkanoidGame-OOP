// ID: 208387969

/**
 * The program receives an integer as an argument.
 * The program prints out the average of all prime numbers between 2 and the integer (include).
 * If the input argument is 1 or lower, the program prints “Invalid value”.
 */
public class AveragePrimes {
    /**
     * prints the average of all prime numbers between 2 and the integer (including 2 and the integer).
     *
     * @param args a number from the command line.
     */
    public static void main(String[] args) {
        // argument (integer) that the program receives
        int n = Integer.parseInt(args[0]);
        //count the num of the prime numbers between 2 and the integer (2 already in the count)
        int count = 1;
        // indication that the integer is prime number
        int isPrime = 1;
        // sum of the prime numbers between 2 and the integer (2 already in the sum)
        int sum = 2;
        // average of all prime numbers = sum / count
        double average = 0;
        // If the input argument is 1 or lower the value invalid
        if (n <= 1) {
            System.out.println("Invalid value");
         // If the input argument is more then 1
        } else {
            // running on the odd numbers between 3 and the integer (2 already in the sum)
            for (int i = 3; i <= n; i = i + 2) {
                // for each number (from 3 - integer): check if he is prime number
                for (int j = 3; j * j <= i; j = j + 2) {
                    // if the number not divides only by 1 and by itself - he's not a prime number
                    if (i % j == 0) {
                        isPrime = 0;
                        // go to the next odd number
                        break;
                    }
                    }
                // if the number is prime
                if (isPrime == 1) {
                    //add the number to the sum
                    sum = sum + i;
                    count++;
                }
                isPrime = 1;
            }
            // average = sum / count
            average = (double) sum / count;
            // print the average
            System.out.println(average);
        }
    }
}