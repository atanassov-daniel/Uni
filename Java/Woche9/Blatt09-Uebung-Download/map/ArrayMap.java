import java.util.Set;
import java.util.HashSet;

public class ArrayMap<K, V> extends AbstractMap<K, V> {
    private Entry<K, V>[] entries;

    public ArrayMap(Entry<K, V>[] entries) {
        // kopiert das uebergebene Array und weist das kopierte Array dem Attribut entries zu
        this.entries = GenericArrayHelper.copyArray(entries);
    }

    /** Initialisiert das Attribut entries mit einem Array der Laenge 10 */
    public ArrayMap() {
        this.entries = GenericArrayHelper.newEntryArrayOfSize(10);
    }

    /** sucht einen Arrayeintrag, welcher nicht null ist und dessen Schluessel dem Parameter key entspricht und gibt den Wert dieses Arrayeintrags zurueck
    * @throws UnknownKeyException falls kein Arrayeintrag gefunden wird, welcher nicht null ist und dessen Schluessel dem Parameter key entspricht
    */
    public V getOrThrow(K key) throws UnknownKeyException {
        for (Entry<K, V> entry : this.entries) {
            if (entry != null && entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }

        throw new UnknownKeyException();
    }

    /** Sucht nach einem Arrayeintrag, welcher null ist oder dessen Schluessel dem Parameter key entspricht. Falls so ein Eintrag gefunden wird, wird es durch einem Entry-Objekt ueberschrieben, welches den Parameter key als Schluessel enthaelt und den Parameter value als Wert. 
    * Falls kein solches Arrayeintrag gefunden wird, wird ein entries-Array doppelter Groesse erstellt, das die bisherigen Arrayeintraege enthaelt und dieses wird dem Attribut entries des aktuellen ArrayMap-Objekt zugewiesen. An der ersten freien Stelle im neuen Array wird ein neues Entry-Objekt eingefuegt, welches den Parameter key als Schluessel und den Parameter value als Wert enthaelt.
    */
    public void put(K key, V value) {
        int oldEntriesLength = this.entries.length;

        for (int i = 0; i < oldEntriesLength; i++) {
            Entry<K, V> entry = this.entries[i];
            if (entry == null || entry.getKey().equals(key)) {
                this.entries[i] = new Entry<K, V>(key, value);
                return;
            }
        }

        this.entries = GenericArrayHelper.copyArrayWithIncreasedSize(this.entries, oldEntriesLength * 2);

        // wenn im urspruenglichen Array keine Stelle gefunden wurde, die null ist oder denselben key hat, dann ist die erste freie Stelle des Arrays von doppelter Groesse die erste Stelle, die im urspruenglichen Array nicht vorkam, d.h. die Stelle an dem Index oldEntriesLength 
        this.entries[oldEntriesLength] = new Entry<K, V>(key, value);
    }

    public Set<K> keysAsSet() {
        HashSet<K> keys = new HashSet<K>();
        for (Entry<K, V> entry : this.entries) {
            if (entry != null) {
                keys.add(entry.getKey());
            }
        }

        return keys;
    }
}