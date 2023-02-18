//Stub für das Tutorium

class BoolTreeNode {

    //Attribute hier einfügen
    private String variable;
    private BoolTreeNode child1, child2;

    private BoolTreeNode(BoolTreeNode child1Input, BoolTreeNode child2Input, String variableInput) {
        
    }

    private BoolTreeNode(String variableInput) {
        this.child1 = null;
        this.child2 = null;
        this.variable = variableInput;
    }

    private BoolTreeNode(BoolTreeNode negated) {
        this.child1 = negated;
        this.child2 = null;
        this.variable = "";
    }

    private BoolTreeNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {
        this.child1 = conjunct1;
        this.child2 = conjunct2;
        this.variable = "";
    }

    private static BoolTreeNode boolTreeVariableNode(String variableInput) {

    }

    static BoolTreeNode boolTreeAndNode(BoolTreeNode conjunct1, BoolTreeNode conjunct2) {

    }

    static BoolTreeNode boolTreeNotNode(BoolTreeNode negated) {

    }

    static BoolTreeNode boolTreeTrueNode() {

    }

    static BoolTreeNode boolTreeFalseNode() {

    }

    public boolean evaluate(String... trueVars) {

    }

    public int depth() {

    }

    public boolean isLeaf() {

    }

    public boolean isTrueLeaf() {

    }

    public boolean isFalseLeaf() {

    }

    public boolean isNegation() {

    }

    public boolean isConjunction() {

    }

    public static void main(String[] args) {

    }
}
