package workingWithAbstraction.exercises.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Bag {
    private long capacity;
    private Map<String, Map<String, Long>> bag;
    private long gold = 0;
    private long gems = 0;
    private long cash = 0;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.bag = new LinkedHashMap<>();
    }

    public long getAmount() {
        return bag.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(e -> e)
                .sum()
                ;
    }

    public long getItemAmount(String key) {
        return this.bag.get(key).values().stream().mapToLong(e -> e).sum();
    }

    public Map<String, Long> get(String key) {
        return this.bag.get(key);
    }

    public void updateItem(String item, String name, long currAmount) {
        bag.get(item).put(name, bag.get(item).get(name) + currAmount);
        if (item.equals("Gold")) {
            gold += currAmount;
        } else if (item.equals("Gem")) {
            gems += currAmount;
        } else if (item.equals("Cash")) {
            cash += currAmount;
        }
    }

    public void put(String key, Map<String, Long> value) {
        this.bag.put(key, value);
    }

    public boolean containsKey(String key) {
        return this.bag.containsKey(key);
    }

    public Set<Map.Entry<String, Map<String, Long>>> entrySet() {
        return this.bag.entrySet();
    }

    public void printContents() {
        for (Map.Entry<String, Map<String, Long>> entry : this.bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }
}
