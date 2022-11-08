package comm;

public class PowerButton implements Button{
    private Processor processor;

    public PowerButton(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void press()
    {
        if(processor.screen.getPowerCondition())
        {
            processor.screen.setScreenCondition(!processor.screen.getScreenCondition());
        }
    }

    @Override
    public void longPress()
    {
        if(!processor.screen.getPowerCondition())
        {
            processor.screen.setPowerCondition(true);
            press();
        }
        else
        {
            press();
            processor.screen.setPowerCondition(false);
        }
    }
}
