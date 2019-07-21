import datagen.DummySource;
import datagen.model.Star;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        DummySource dummySource = new DummySource();

        Stream<Star> starStream = dummySource.getStarStream();

        starStream.limit(100).forEach(System.out::println);
    }
}
