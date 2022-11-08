package comm;

class Processor {
    private static Processor processor;
    private final String name;
    private final String processorVersion;
    private final int numberOfCores;
    private final float cpuClockSpeed;
    private final float wifiVersion;
    private final float bluetoothVersion;
    private final String usbType;
    protected Antenna antenna;
    protected Camera primaryCamera;
    protected Camera secondaryCamera;
    protected Microphone mic;
    protected Speaker speaker;
    protected TouchScreen screen;
    protected Speaker earPiece;
    protected Battery battery;
    public Processor(String name, String processorVersion, int numberOfCores, float cpuClockSpeed, float wifiVersion, float bluetoothVersion, String usbType, Antenna antenna, Camera primaryCamera, Camera secondaryCamera, Microphone mic, Speaker speaker,TouchScreen screen, Speaker earPiece,Battery battery) {
        this.name = name;
        this.processorVersion = processorVersion;
        this.numberOfCores = numberOfCores;
        this.cpuClockSpeed = cpuClockSpeed;
        this.wifiVersion = wifiVersion;
        this.bluetoothVersion = bluetoothVersion;
        this.usbType = usbType;
        this.antenna = antenna;
        this.primaryCamera = primaryCamera;
        this.secondaryCamera = secondaryCamera;
        this.mic = mic;
        this.speaker = speaker;
        this.screen = screen;
        this.earPiece = earPiece;
        this.battery = battery;
    }

    protected void processData(String data)
    {

    }

}
