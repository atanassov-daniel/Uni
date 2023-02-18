import java.util.Set;
import java.util.HashSet;

public abstract class AbstractMap<K, V> {
    public abstract V getOrThrow(K key) throws UnknownKeyException;
    public abstract void put(K key, V value);

    /** Erstellt ein neues HashSet und fuegt dort fuer jeden in der Schluesselmenge enthaltenen Schluessel den in der Map zugeordneten Wert ein, und gibt anschliessend das erstellte HashSet zurueck.
    * @return die den Schluesseln in der Map zugeordnete Wertemenge. 
    */
    public Set<V> getValuesAsSetOrThrow(Set<K> keys) throws UnknownKeyException {
        HashSet<V> values = new HashSet<V>();
        for (K key : keys) {
            try {
                V value = this.getOrThrow(key);
                values.add(value);
            } catch (UnknownKeyException uke) {
                // continue;
                throw new UnknownKeyException();
            }
        }
        return values;
    }

    /** @return die Schluesseln des Map-Objekts, auf dem die Methode aufgerufen wird */
    public abstract Set<K> keysAsSet();
}