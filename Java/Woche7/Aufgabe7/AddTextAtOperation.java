public class AddTextAtOperation extends Operation {
    private final int position;
    private final String addition;

    public AddTextAtOperation(int position, String addition) {
        this.position = position;
        this.addition = addition;
    }

    @Override
    public TextDocument apply(TextDocument current) {
        return current.addTextAt(this.position, this.addition);
    }

    @Override
    public String getDescription() {
        return String.format("adds the following text at position %d: %s", this.position, this.addition);
    }
}
