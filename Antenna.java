package comm;

class Antenna{

    protected void receiveSignal(String signal)
    {
        convertToDigital();
    }

    protected void sendSignal(String signal)
    {
        convertToAnalog();
        //Then the signal is transmitted to the air
    }

    private void convertToDigital()
    {

    }

    private void convertToAnalog()
    {

    }
}
