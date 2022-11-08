package comm;

class TouchScreen {
    private final float width;
    private final float height;
    private final DisplayType displayType;
    private  boolean screenCondition;//true = ON  false = OFF
    private  boolean powerCondition;//true = ON  false = OFF

    public TouchScreen(float width, float height, DisplayType displayType, boolean screenCondition, boolean powerCondition) {
        this.width = width;
        this.height = height;
        this.displayType = displayType;
        this.screenCondition = screenCondition;
        this.powerCondition = powerCondition;
    }

    public boolean getScreenCondition()
    {
        return screenCondition;
    }

    public void setScreenCondition(boolean screenCondition)
    {
        this.screenCondition = screenCondition;
    }

    public boolean getPowerCondition()
    {
        return powerCondition;
    }

    public void setPowerCondition(boolean powerCondition)
    {
        this.powerCondition = powerCondition;
    }

    enum DisplayType{
        AMOLED,
        IPSLCD,
        OLED,
        POLED,
        SUPER_AMOLED;
    }

}
