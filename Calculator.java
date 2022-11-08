package comm;

import java.util.Scanner;

class Calculator extends Application {
    public Calculator(String appName, double initialAppSize) {
        super(appName, initialAppSize);
    }

    @Override
    protected void display()
    {
        boolean loopBreaker = true;
        while (loopBreaker) {
            System.out.print("1.Add\n2.Subtract\n3.Multiply\n4.Divide\n0.Quit\nEnter your choice:");
            Scanner s = new Scanner(System.in);
            String choice = s.next();
            System.out.println("Enter 2 numbers:");
            double num1 = s.nextDouble();
            double num2 = s.nextDouble();
            switch (choice) {
                case "1":
                    processor.processData("calculation");
                    System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
                    break;
                case "2":
                    processor.processData("calculation");
                    System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
                    break;
                case "3":
                    processor.processData("calculation");
                    System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
                    break;
                case "4":
                    processor.processData("calculation");
                    System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
                    break;
                case "0":
                    loopBreaker = false;
                    break;
                default:
                    System.out.println("ERROR! NOT FOUND");
            }

        }
    }
}