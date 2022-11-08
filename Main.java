package comm;

import java.util.Scanner;

public class Main{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        Smartphone realme8 = new Smartphone("Realme 8","RMX3085",180,6.5f,3.2f,8,15999.00,1);
        boolean loopBreaker = true;
        while(loopBreaker)
        {
            System.out.print("Enter 1 to Power On\nEnter 2 to charge phone\nEnter your choice:");
            switch (s.next())
            {
                case "1":
                    realme8.powerOn();
                    break;
                case "2":
                    realme8.chargePhone();
                    break;
                default:
                    loopBreaker = false;
            }
        }
    }
}
