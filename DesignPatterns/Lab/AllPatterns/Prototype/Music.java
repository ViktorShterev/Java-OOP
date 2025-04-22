package Prototype;

public class Music extends Item {
    private Double duration;
    public Music(String name, String imURL, Double price) {
        super(name, imURL, price);
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
