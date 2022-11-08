package comm;

public class VolumeUpButton extends VolumeButton{
    Processor processor;
    public VolumeUpButton(Processor processor)
    {
        this.processor = processor;
    }

    public void press()
    {
        if(isSpeakerOn)
            processor.speaker.volumeUp();
        else
            processor.earPiece.volumeUp();
    }
    public void longPress()
    {
        processor.speaker.changeMode();
    }
}
