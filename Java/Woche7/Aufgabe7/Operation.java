public class Operation {
    /** Methode, welche eine Operation auf dem übergebenen TextDocument ausführt und das dabei erzeugte TextDocument zurückgibt. In der Klasse Operation führt die apply-Methode die leere Operation (noop) auf dem TextDocument current aus. */
    public TextDocument apply(TextDocument current) {
        return current.noop();
    }

    public String getDescription() {
        return "does not modify the document";
    }
}
