package comm;

class RAM {
    private final double totalRAM;
    private double availableRAM;

    public RAM(double totalRAM, double availableRAM) {
        this.totalRAM = totalRAM;
        this.availableRAM = availableRAM;
    }

    protected double getTotalRAM() {
        return totalRAM;
    }

    protected double getAvailableRAM()
    {
        return availableRAM;
    }

    protected void setAvailableRAM(double availableRAM)
    {
        this.availableRAM = availableRAM;
    }
}
