public class Launcher {
    public static void main(String[] args) {
        Operation[] operations = {
                new AddTextAtOperation(0, "Hello Aachen!"),
                new ReplaceTextSectionOperation(6, 12, "World"),
                new UndoOperation(),
                new ReplaceTextSectionOperation(0, 5, "Goodbye"),
                new RemoveTextSectionOperation(14, 15)
        };

        TextDocument aktuellesDokument = new TextDocument("");
        for (Operation operation : operations) {
            // Es wird zunächst der Inhalt des aktuellen TextDocuments auf der Konsole ausgeben
            System.out.println(aktuellesDokument.getAktuellerInhalt());
            // dann wird die Beschreibung der aktuellen Operation ausgegeben
            System.out.println(operation.getDescription());
            // Anschliessend wird das aktuelle TextDocument durch das TextDocument ersetzt, welches von der aktuellen Operation erzeugt wird, wenn diese mit dem aktuellen TextDocument als Parameter ausgeführt wird
            aktuellesDokument = operation.apply(aktuellesDokument);
        }
        // Nach Beendigung der Schleife wird noch einmal der Inhalt des aktuellen TextDocuments ausgegeben
        System.out.println(aktuellesDokument.getAktuellerInhalt());
    }
}
