package comm;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Clock extends Application {
    Scanner s = new Scanner(System.in);
    LocalDateTime dateTime = LocalDateTime.now();

    public Clock(String appName, double initialAppSize) {
        super(appName, initialAppSize);
    }

    @Override
    protected void display(){
       boolean loopBreaker = true;
       while(loopBreaker)
       {
           System.out.println("1.Show Time\n2.Show Date\n3.Timer\n4.StopWatch\n0.Quit");
           String choice = s.next();
           switch(choice) {
               case "1":
                   showDateTime(true);
                   break;
               case "2":
                   showDateTime(false);
                   break;
               case "3":
                   timer();
                   break;
               case "4":
                   stopWatch();
                   break;
               case "0":
                   loopBreaker = false;
                   break;
               default:
                   System.out.println("ERROR:NOT FOUND!");
           }
       }

    }

    private void showDateTime(boolean isTimeToBeShown)
    {
        if (isTimeToBeShown)
        {
            DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
            System.out.println("Current local time is"+time.format(dateTime));
        }
        else//Date to be shown
        {
            DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DayOfWeek day = dateTime.getDayOfWeek();
            String dayFormatted = String.valueOf(day).toLowerCase();
            dayFormatted = Character.toUpperCase(dayFormatted.charAt(0))+""+dayFormatted.substring(1);
            System.out.println("Today's date: "+date.format(dateTime)+"\nToday is "+dayFormatted);
        }
    }

    private void timer()
    {
//        System.out.println("Enter the time in the format (HH:MM:SS):");
//        String timer = s.next();
//        String []time = timer.split(":");
//        System.out.println(Arrays.toString(time));
//        System.out.println("TIME UP");
    }

    private void stopWatch()
    {

    }


}
