package comm;

import java.util.Scanner;

class OperatingSystem {
    Scanner s = new Scanner(System.in);
    private String name;
    private float osVersion;
    private Processor processor;
    private Button powerButton;
    private RAM ram;
    private Memory internalMemory;
    private VolumeButton volumeUpButton;
    private VolumeButton volumeDownButton;
    private HomeScreen homeScreen;
    private Kernel kernel;

    public OperatingSystem(String name, float osVersion,Processor processor,Button powerButton,RAM ram,Memory internalMemory,VolumeButton volumeUpButton,VolumeButton volumeDownButton) {
        this.name = name;
        this.osVersion = osVersion;
        this.processor = processor;
        this.powerButton = powerButton;
        this.ram = ram;
        this.internalMemory = internalMemory;
        this.volumeDownButton = volumeDownButton;
        this.volumeUpButton = volumeUpButton;
        kernel = new Kernel("Linux","4.14.186", processor.antenna,processor.primaryCamera,processor.secondaryCamera,processor.mic,processor.speaker,processor.screen,processor.earPiece,internalMemory,ram);
        homeScreen = new HomeScreen(processor,powerButton,volumeUpButton,volumeDownButton,kernel);
    }

    protected void start()
    {
        homeScreen.displayHomeScreen();
    }

}