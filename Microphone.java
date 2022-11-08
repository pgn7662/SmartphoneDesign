package comm;

class Microphone {
    public boolean isMicOn() {
        return isMicOn;
    }

    private boolean isMicOn;
    public Microphone(boolean isMicOn) {
        this.isMicOn = isMicOn;
    }

    protected void turnOffMic() {
        isMicOn = false;
    }
    protected void turnOnMic()
    {
        isMicOn = true;
    }

    protected void getVoiceInput()
    {

    }

    protected void processVoice()
    {

    }

}
