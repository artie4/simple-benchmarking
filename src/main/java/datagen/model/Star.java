package datagen.model;


import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Random;

public class Star implements Comparable<Star>{

    private Star() {}
    private String name;
    private String color;
    private Integer surfaceTempature;
    private Double solarSize;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Integer getSurfaceTempature() {
        return surfaceTempature;
    }

    public Double getSolarSize() {
        return solarSize;
    }

    @Override
    public int compareTo(Star star) {
        return this.getName().compareTo(star.name);
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", surfaceTempature=" + surfaceTempature +
                ", solarSize=" + solarSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Star star = (Star) o;
        return Objects.equals(name, star.name) &&
                Objects.equals(color, star.color) &&
                Objects.equals(surfaceTempature, star.surfaceTempature) &&
                Objects.equals(solarSize, star.solarSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color, surfaceTempature, solarSize);
    }

    public static Star generateStar() {
        Star star = new Star();

        int clr = new Random().nextInt(Color.values().length);
        star.color = Color.values()[clr].color;

        int tmp = new Random().nextInt(18000) + 2000;
        star.surfaceTempature = tmp;

        double size = Double.valueOf(new DecimalFormat("#.##")
                .format(Math.pow(Math.random() * 2, 6) + 0.08));
        star.solarSize = size;

        star.name = String.format("%sStar-%d-%d", star.color, Math.round(star.solarSize), star.surfaceTempature);

        return star;
    }

}