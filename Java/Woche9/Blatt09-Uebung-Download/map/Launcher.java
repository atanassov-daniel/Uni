import java.util.Set;
import java.util.HashSet;

public class Launcher {
    public static void main(String[] args) {
        AbstractMap<String, Integer> map = new ArrayMap<String, Integer>();
        putEntries(map);
        printMap(map);

        Set<String> testSet = new HashSet<String>();
        testSet.add("unknown");
        try {
            map.getValuesAsSetOrThrow(testSet);
        } catch (UnknownKeyException uke) {
            System.out.println("unknown key");
        }
    }

    private static void putEntries(AbstractMap<String, Integer> map) {
        map.put("sizeInMB", 42);
        map.put("version", 4);
        map.put("yearOfRelease", 2015);
    }

    private static <K, V> void printMap(AbstractMap<K, V> map) {
        // In der Schleife wird die Methode getOrThrow mit jedem gefundenen Schluessel key auf der uebergebenen Map aufgerufen, um den Integer-Wert value zu erhalten, welcher dem Schluessel zugeordnet ist. Diese Schluessel-Wert-Zuordnung wird in folgender Form auf der Konsole ausgegeben: "key: value"
        for (K key : map.keysAsSet()) {
            try {
                V value = map.getOrThrow(key);
                System.out.println(key + ": " + value);
            } catch (UnknownKeyException uke) {
                System.out.println("Fuer den key \"" + key + "\" ist ein UnknownKeyException aufgetreten.");
            }
        }
    }
}