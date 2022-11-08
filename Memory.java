package comm;

/*ROM or Internal Memory*/
class Memory {
    private final double totalSpace;
    private final double spaceOccupiedForOS;
    private double availableSpace;

    protected double getAvailableSpace() {
        return availableSpace;
    }

    protected void setAvailableSpace(double availableSpace) {
        this.availableSpace = availableSpace;
    }

    public Memory(double totalSpace, double spaceOccupiedForOS, double availableSpace) {
        this.totalSpace = totalSpace;
        this.spaceOccupiedForOS = spaceOccupiedForOS;
        this.availableSpace = availableSpace;

    }

}
