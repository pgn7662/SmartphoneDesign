package comm;

import java.util.Scanner;

class Battery {
    private int batteryCapacity;
    private float batteryPercentage;
    private BatteryStatus batteryStatus;//Charging or Discharging
    Scanner s = new Scanner(System.in);


    public int getBatteryPercentage() {
        return (int) batteryPercentage;
    }

    public Battery(int initialBatteryCapacity, int initialBatteryPercentage, BatteryStatus batteryStatus)
    {
        this.batteryCapacity = initialBatteryCapacity;
        this.batteryPercentage = initialBatteryPercentage;
        this.batteryStatus = batteryStatus;
    }

    protected void consumePower()
    {
        batteryStatus = BatteryStatus.DISCHARGING;
        batteryPercentage -= 0.0000067;
    }

    protected void chargeBattery()
    {
        batteryStatus = BatteryStatus.CHARGING;
        while(batteryPercentage <=100)
        {
            System.out.println("Do you want to disconnect charger(Y/N)");
                if(s.next().equals("Y"))
                {
                    batteryStatus = BatteryStatus.DISCHARGING;
                    break;
                }
                else
                {
                    try{
                        Thread.sleep(60000);
                        batteryPercentage +=1.53;
                    }
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                }
            }
        }

    public enum BatteryStatus {
        CHARGING,
        DISCHARGING;
    }
}