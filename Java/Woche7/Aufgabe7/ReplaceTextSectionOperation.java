public class ReplaceTextSectionOperation extends Operation {
    private final int beginIndex;
    private final int endIndex;
    private final String replacement;

    public ReplaceTextSectionOperation(int beginIndex, int endIndex, String replacement) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
        this.replacement = replacement;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.replaceTextSection(this.beginIndex, this.endIndex, this.replacement);
    }

    @Override
    public String getDescription() {
        return String.format("replaces the text section from %d to %d by: %s", this.beginIndex, this.endIndex,
                this.replacement);
    }
}
