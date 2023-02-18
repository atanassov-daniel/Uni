public class TextDocument {
    private final String aktuellerInhalt;

    //! nur getter und kein setter, muss es also final sein
    public String getAktuellerInhalt() {
        return aktuellerInhalt;
    }

    public TextDocument(String aktuellerInhalt) {
        this.aktuellerInhalt = aktuellerInhalt;
    }

    public TextDocument undo() {
        return this;
    }

    /** erstellt ein neues ModifiedTextDocument-Objekt, mit dem aktuellen TextDocument-Objekt als vorherige Version. Der neue Inhalt ist derselbe wie der aktuelle Inhalt. */
    public TextDocument noop() {
        return new ModifiedTextDocument(this.aktuellerInhalt, this);
    }

    /** erstellt ein neues ModifiedTextDocument-Objekt, mit dem aktuellen TextDocument-Objekt als vorherige Version. Der neue Inhalt wird aus dem aktuellen Inhalt erzeugt, indem der Textabschnitt von Position beginIndex bis Position endIndex - 1 durch den Text replacement ersetzt wird. */
    public TextDocument replaceTextSection(int beginIndex, int endIndex, String replacement) {
        String neuerInhalt = this.aktuellerInhalt.substring(0, beginIndex) + replacement
                + this.aktuellerInhalt.substring(endIndex);
        return new ModifiedTextDocument(neuerInhalt, this);
    }

    /** erstellt ein neues ModifiedTextDocument-Objekt, mit dem aktuellen TextDocument-Objekt als vorherige Version. Der neue Inhalt wird aus dem aktuellen Inhalt erzeugt, indem an der Position position der Text addition eingefuegt wird. */
    public TextDocument addTextAt(int position, String addition) {
        String neuerInhalt = this.aktuellerInhalt.substring(0, position) + addition
                + this.aktuellerInhalt.substring(position);
        return new ModifiedTextDocument(neuerInhalt, this);
    }

    /** erstellt ein neues ModifiedTextDocument-Objekt, mit dem aktuellen TextDocument-Objekt als vorherige Version. Der neue Inhalt wird aus dem aktuellen Inhalt erzeugt, indem der Textabschnitt von Position beginIndex bis Position endIndex - 1 entfernt wird. */
    public TextDocument removeTextSection(int beginIndex, int endIndex) {
        String neuerInhalt = this.aktuellerInhalt.substring(0, beginIndex) + this.aktuellerInhalt.substring(endIndex);
        return new ModifiedTextDocument(neuerInhalt, this);
    }
}