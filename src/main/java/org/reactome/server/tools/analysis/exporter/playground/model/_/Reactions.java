package org.reactome.server.tools.analysis.exporter.playground.model._;

/**
 * @author Chuan-Deng <dengchuanbio@gmail.com>
 */
public class Reactions {
    private int total;
    private int found;
    private double ratio;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getFound() {
        return found;
    }

    public void setFound(int found) {
        this.found = found;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "Reactions{" +
                "total=" + total +
                ", found=" + found +
                ", ratio=" + ratio +
                '}';
    }
}