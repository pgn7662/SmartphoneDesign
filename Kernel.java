package comm;

public class Kernel {
    private final String name;
    private final String kernelVersion;
    private RAM ram;
    private Memory internalMemory;
    protected Antenna antenna;
    protected Camera primaryCamera;
    protected Camera secondaryCamera;
    protected Microphone mic;
    protected Speaker speaker;
    protected Speaker earPiece;
    protected TouchScreen screen;


    public Kernel(String name, String kernelVersion, Antenna antenna, Camera primaryCamera, Camera secondaryCamera, Microphone mic, Speaker speaker,TouchScreen screen, Speaker earPiece,Memory internalMemory,RAM ram) {
        this.name = name;
        this.kernelVersion = kernelVersion;
        this.antenna = antenna;
        this.primaryCamera = primaryCamera;
        this.secondaryCamera = secondaryCamera;
        this.mic = mic;
        this.speaker = speaker;
        this.screen = screen;
        this.earPiece = earPiece;
        this.internalMemory = internalMemory;
        this.ram = ram;
    }

    protected void allocateRam(double totalAppSize)
    {
        ram.setAvailableRAM(ram.getAvailableRAM()-totalAppSize);
    }

    protected void deAllocateRam(double totalAppSize)
    {
        ram.setAvailableRAM(ram.getAvailableRAM()+totalAppSize);
    }

    protected void saveFile(double fileSize)
    {
        internalMemory.setAvailableSpace(internalMemory.getAvailableSpace()-fileSize);
    }

}
