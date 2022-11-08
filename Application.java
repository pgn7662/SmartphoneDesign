package comm;

public abstract class Application {
    private final String appName;
    private double initialAppSize;

    protected Processor processor;
    protected Kernel kernel;
    private double appData;
    private double totalAppSize;
    protected VolumeButton volumeUpButton;
    protected VolumeButton volumeDownButton;

    protected void addAppData(double appData) {
        this.appData += appData;
        totalAppSize += appData;
    }


    public double getTotalAppSize() {
        return totalAppSize;
    }

    public Application(String appName,double initialAppSize)
    {
        this.appName = appName;
        this.initialAppSize = initialAppSize;
        totalAppSize = appData + initialAppSize;
    }

    protected void run(Processor processor,Kernel kernel,VolumeButton volumeUpButton,VolumeButton volumeDownButton)
    {
        this.processor = processor;
        this.kernel = kernel;
        this.volumeDownButton = volumeDownButton;
        this.volumeUpButton = volumeUpButton;
        processor.battery.consumePower();
        this.display();
    }
    protected abstract void display();

}
