package comm;

class Speaker {
    private int mediaVolumeLevel;
    public Speaker(int initialMediaVolumeLevel) {
        this.mediaVolumeLevel = initialMediaVolumeLevel;
    }

    protected int getMediaVolumeLevel()
    {
        return mediaVolumeLevel;
    }

    protected void playSound(String sound)
    {

    }

    protected void volumeUp()
    {
        if(mediaVolumeLevel<15)
            mediaVolumeLevel+=1;
    }

    protected void volumeDown()
    {
        if (mediaVolumeLevel>0)
            mediaVolumeLevel -= 1;
    }

    protected void changeMode()
    {
        if(mediaVolumeLevel!=0)
            mediaVolumeLevel = 0;
        else
            mediaVolumeLevel = 15;
    }

}
