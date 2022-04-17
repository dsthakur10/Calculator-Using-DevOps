package calculator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Scanner;
import java.util.InputMismatchException;


public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public Calculator() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;

        while(true){
            while (true) {
                try {
                    int choice;
                    System.out.println("\nCALCULATOR");
                    System.out.println("Here is your calculator menu:");
                    System.out.print(
                            "1. Power\n" +
                            "2. Factorial\n" +
                            "3. Natural Logarithm\n" +
                            "4. Square root\n" +
                            "0. Exit\n\n" +
                            "Enter your choice: "
                    );

                    choice = scanner.nextInt();

                    switch (choice) {

                        case 1: // Calculate num1 ^ num2
                            System.out.println("Enter 2 numbers : ");
                            num1 = scanner.nextDouble();
                            num2 = scanner.nextDouble();

                            System.out.println(num1 + " ^ " + num2 + " = " + calculator.power(num1, num2));
                            System.out.println("\n");
                            break;

                        case 2: // Calculate num1!
                            int num;
                            System.out.print("Enter your number to find its factorial: ");
                            num = scanner.nextInt();

                            System.out.println("Factorial of " + num + " = " + calculator.factorial(num));
                            System.out.println("\n");
                            break;

                        case 3: // Calculate loge(num1)
                            System.out.print("Enter your number to find its logarithm : ");
                            num1 = scanner.nextDouble();

                            System.out.println("Natural log of " + num1 + " = " + calculator.logE(num1));
                            System.out.println("\n");
                            break;

                        case 4: // Calculate sqroot(num1)
                            System.out.print("Enter your number to find its square root : ");
                            num1 = scanner.nextDouble();

                            System.out.println("Square root of " + num1 + " = " + calculator.squareRoot(num1));
                            System.out.println("\n");
                            break;

                        case 0:
                            System.out.println("That's all from my side...\n Exiting....");
                            return;

                        default:
                            System.out.println("\nWRONG CHOICE.... ENTER AGAIN");
                    }

                } catch (Exception e) {
                    System.out.println("\nError occurred : " + e);
                    System.out.println("TRY AGAIN");
                    scanner.next();
                    //You need to discard the previous input from the stream by calling sc.next()
                    // in your catch block. Sadly, the scanner does not do this automatically when
                    // the input fails.
                    break;
                }
            }
        }

    }


    public double factorial(double num1) {
        logger.info("[FACTORIAL] - " + num1);
        double result = 1;

        try {
            if (num1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of Negative number");
            }

            else{
                for(int i = 1; i <= num1; i++)
                    result *= i;
            }
        }

        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - FACTORIAL] - Cannot find factorial : " + error.getLocalizedMessage());
        }

        logger.info("[RESULT - FACTORIAL] - " + result);
        return result;
    }

    public double squareRoot(double num1) {
        logger.info("[SQUARE ROOT] - " + num1);
        double result = Double.NaN;

        try {
            if (num1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of Negative number");
            }
            else
                result = Math.sqrt(num1);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - SQUARE ROOT] - Cannot find square-root : " + error.getLocalizedMessage());
        }

        logger.info("[RESULT - SQUARE ROOT] - " + result);
        return result;
    }

    public double power(double num1, double num2) {
        logger.info("[POWER - " + num1 + " RAISED TO] " + num2);
        double result = Math.pow(num1,num2);
        logger.info("[RESULT - POWER] - " + result);
        return result;
    }

    public double logE(double num1) {
        logger.info("[NATURAL LOG] - " + num1);
        double result = 0;

        try {
            if (num1 < 0) {
                result = Double.NaN;
                throw new ArithmeticException("Case of Negative number");
            }
            else
                result = Math.log(num1);
        }
        catch (ArithmeticException error) {
            System.out.println("[EXCEPTION - LOG] - Cannot find log : " + error.getLocalizedMessage());
        }
        logger.info("[RESULT - NATURAL LOG] - " + result);
        return result;
    }
}
