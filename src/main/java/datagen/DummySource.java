package datagen;

import datagen.model.Star;

import java.util.stream.Stream;

public class DummySource {

    public Stream<Star> getStarStream() {
        return Stream.iterate(Star.generateStar(), s -> Star.generateStar());
    }


}
