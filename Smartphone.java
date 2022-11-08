package comm;

import java.util.Scanner;

public class Smartphone {
    Scanner s = new Scanner(System.in);
    public final String name;
    public final String modelNumber;
    public final float weight;
    public final float height;
    public final float width;
    public final float thickness;
    public final double price;
    public final int numberOfRearCameras;

    public Smartphone(String name, String modelNumber, float weight, float height, float width, float thickness, double price, int numberOfRearCamereas) {
        this.name = name;
        this.modelNumber = modelNumber;
        this.weight = weight;
        this.height = height;
        this.width = width;
        this.thickness = thickness;
        this.price = price;
        this.numberOfRearCameras = numberOfRearCamereas;
    }

    private final Antenna antenna = new Antenna();
    private Battery battery = new Battery(4500,56, Battery.BatteryStatus.DISCHARGING);
    private final Camera primaryCamera = new Camera(64,10,1.8f,4.71f,false);
    private final Camera frontCamera = new Camera(16,2,2.5f,3.41f,false);
    private final Speaker speaker = new Speaker(10);
    private final Speaker earPiece = new Speaker(12);
    private final Microphone mic = new Microphone(false);
    private final RAM ram = new RAM(6144,3153.92);  //size in megabytes(mb)
    private final Memory internalMemory = new Memory(131072,11264,119808);  //size in megabytes(mb)
    private TouchScreen screen = new TouchScreen(3.2f,6.1f, TouchScreen.DisplayType.AMOLED,false,false);
    private final Processor processor = new Processor("MediaTek","Helio G95",8,2000,5,5.0f,"C",antenna,primaryCamera,frontCamera,mic,speaker,screen,earPiece,battery);
    public final Button powerButton = new PowerButton(processor);
    public final VolumeButton volumeUpButton = new VolumeUpButton(processor);
    public final VolumeButton volumeDownButton = new VolumeDownButton(processor);
    private final OperatingSystem  os = new OperatingSystem("Android",12.0f,processor,powerButton,ram,internalMemory,volumeUpButton,volumeDownButton);

    protected void powerOn()
    {
        System.out.print("Press enter to long press the power button");
        String sc ="";
        sc = s.nextLine();
        if(sc.equals(""))
        {
            if(battery.getBatteryPercentage()==0)
                System.out.println("Power not enough\nCharge smartphone immediately\nShutting down.....");
            else
            {
                powerButton.longPress();
                System.out.println("Power On");
                os.start();
            }
        }
    }

    protected void chargePhone()
    {
        System.out.println(battery.getBatteryPercentage()+"% charging⚡️");
        processor.battery.chargeBattery();
        System.out.println("Charger disconnected charged upto "+battery.getBatteryPercentage()+"%");
    }
}

