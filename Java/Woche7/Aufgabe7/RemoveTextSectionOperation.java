public class RemoveTextSectionOperation extends Operation {
    private final int beginIndex;
    private final int endIndex;

    public RemoveTextSectionOperation(int beginIndex, int endIndex) {
        this.beginIndex = beginIndex;
        this.endIndex = endIndex;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.removeTextSection(this.beginIndex, this.endIndex);
    }

    @Override
    public String getDescription() {
        return String.format("removes the text section from %d to %d", this.beginIndex, this.endIndex);
    }
}
