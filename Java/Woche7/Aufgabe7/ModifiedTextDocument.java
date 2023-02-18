/** Diese Klasse stellt
ein Textdokument dar, zu welchem eine vorherige Version bekannt ist. */
public class ModifiedTextDocument extends TextDocument {
    private TextDocument vorherigeVersion;

    public ModifiedTextDocument(String aktuellerInhalt, TextDocument vorherigeVersion) {
        super(aktuellerInhalt);
        this.vorherigeVersion = vorherigeVersion;
    }

    @Override
    public TextDocument undo() {
        return this.vorherigeVersion;
    }
}
