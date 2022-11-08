package comm;

public class VolumeDownButton extends VolumeButton{
    Processor processor;
    public VolumeDownButton(Processor processor)
    {
        this.processor = processor;
    }
    @Override
    public void press()
    {
        if(isSpeakerOn)
            processor.speaker.volumeDown();
        else
            processor.earPiece.volumeDown();
    }
    @Override
    public void longPress()
    {
        processor.speaker.changeMode();
    }
}