package Fire;

public class Calc {
    private double effort;
    private int totalWater, water;

    public Calc(double effort, int totalWater, int water) {
        this.effort = effort;
        this.totalWater = totalWater;
        this.water = water;
    }

    public double getEffort() {
        return this.effort;
    }

    public void setEffort(double effort) {
        this.effort = effort;
    }

    public int getTotalWater() {
        return this.totalWater;
    }

    public void setTotalWater(int totalWater) {
        this.totalWater = totalWater;
    }

    public int getWater() {
        return this.water;
    }

    public void setWater(int water) {
        this.water = water;
    }
}
