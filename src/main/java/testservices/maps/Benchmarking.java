package testservices.maps;

import datagen.DummySource;
import datagen.model.Star;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.apache.commons.collections4.map.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2)
@Measurement(iterations = 5)
@Fork(value = 5)
@State(value = Scope.Benchmark)
public class Benchmarking {

    private final int total = 200000;
    private DummySource source = new DummySource();

    private Star randomStar = Star.generateStar();
    private Star starFromStream;

    /**
     * Standard maps
     */
    private HashMap<String, Star> hashMap = new HashMap<>();
    private TreeMap<String, Star> treeMap = new TreeMap<>();
    private LinkedHashMap<String, Star> linkedHashMap = new LinkedHashMap<>();

    /**
     * Thread safe maps
     */
    private ConcurrentSkipListMap<String, Star> concurrentSkipListMap = new ConcurrentSkipListMap<>();
    private ConcurrentHashMap<String, Star> concurrentHashMap = new ConcurrentHashMap<>();

    /**
     * Apache commons maps
     */
    private HashedMap<String, Star> hashedMap = new HashedMap<>();
    private LinkedMap<String, Star> linkedMap = new LinkedMap<>();

    {
        source.getStarStream().limit(total)
                .forEach((v) ->
                        {
                            String k = v.getName();
                            hashMap.put(k, v);
                            treeMap.put(k, v);
                            concurrentSkipListMap.put(k, v);
                            concurrentHashMap.put(k, v);
                            hashedMap.put(k, v);
                        });

        starFromStream = new ArrayList<>(hashMap.values()).get(total/2);
    }

    @Benchmark
    public void hashMap(Blackhole blackhole) {
        hashMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(hashMap);

    }

    @Benchmark
    public void treeMap(Blackhole blackhole) {
        treeMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(treeMap);
    }

    @Benchmark
    public void linkedHashMap(Blackhole blackhole) {
        linkedHashMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(linkedHashMap);
    }

    @Benchmark
    public void concurrentSkipListMap(Blackhole blackhole) {
        concurrentSkipListMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(concurrentSkipListMap);
    }

    @Benchmark
    public void concurrentHashMap(Blackhole blackhole) {
        concurrentHashMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(concurrentHashMap);
    }

    @Benchmark
    public void hashedMap(Blackhole blackhole) {
        hashedMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(hashedMap);
    }

    @Benchmark
    public void linkedMap(Blackhole blackhole) {
        linkedMap.putIfAbsent(randomStar.getName(), randomStar);
        blackhole.consume(linkedMap);
    }




}
