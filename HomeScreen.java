package comm;

import java.util.Scanner;

class HomeScreen{

    private Button powerButton;
    private Processor processor;
    private VolumeButton volumeUpButton;
    private VolumeButton volumeDownButton;
    private Kernel kernel;
    private Application phone;
    private Application cameraApp;
    private Application calculator;
    private Application music;
    private Application clock;


    protected HomeScreen(Processor processor,Button powerButton,VolumeButton volumeUpButton,VolumeButton volumeDownButton,Kernel kernel)
    {
        this.processor = processor;
        this.powerButton = powerButton;
        this.volumeDownButton = volumeDownButton;
        this.volumeUpButton = volumeUpButton;
        this.kernel = kernel;
        phone = new Phone("Phone", 85.5);
        cameraApp = new CameraApp("Camera", 20.7);
        clock = new Clock("Clock", 24.5);
        music = new Music("Music", 36.7);
        calculator = new Calculator("Calculator",8.9);
    }

    protected void displayHomeScreen(){
        Scanner s = new Scanner(System.in);
        boolean loopBreaker = true;
        while(loopBreaker)
        {
            System.out.print("1.Phone \n2.Camera \n3.Clock \n4.Calculator\n5.Music\n0.ScreenOFF\nPress Enter to Shutdown\nEnter your choice:");
            String choice = s.nextLine();
            switch (choice)
            {
                case "1":
                    System.out.println("\nPhone\n");
                    kernel.allocateRam(phone.getTotalAppSize());
                    phone.run(processor,kernel,volumeUpButton,volumeDownButton);
                    kernel.deAllocateRam(phone.getTotalAppSize());
                    break;
                case "2":
                    System.out.println("\nCamera\n");
                    kernel.allocateRam(cameraApp.getTotalAppSize());
                    cameraApp.run(processor,kernel,volumeUpButton,volumeDownButton);
                    kernel.deAllocateRam(cameraApp.getTotalAppSize());
                    break;
                case "3":
                    System.out.println("\nClock\n");
                    kernel.allocateRam(clock.getTotalAppSize());
                    clock.run(processor,kernel,volumeUpButton,volumeDownButton);
                    kernel.deAllocateRam(clock.getTotalAppSize());
                    break;
                case "4":
                    System.out.println("\nCalculator\n");
                    kernel.allocateRam(calculator.getTotalAppSize());
                    calculator.run(processor,kernel,volumeUpButton,volumeDownButton);
                    kernel.deAllocateRam(calculator.getTotalAppSize());
                    break;
                case "5":
                    System.out.println("\nMusic Player\n");
                    kernel.allocateRam(music.getTotalAppSize());
                    music.run(processor,kernel,volumeUpButton,volumeDownButton);
                    kernel.deAllocateRam(music.getTotalAppSize());
                    break;
                case "0":
                    processor.screen.setScreenCondition(false);
                    powerButton.press();
                    System.out.println("Enter 0 to turn screen on");
                    if(s.next().equals("0"))
                    {
                        processor.screen.setScreenCondition(true);
                        powerButton.press();
                        displayHomeScreen();
                    }
                    break;
                default:
                    System.out.println("Shutting down.............");
                    powerButton.longPress();
                    loopBreaker = false;
            }
        }
    }
}
