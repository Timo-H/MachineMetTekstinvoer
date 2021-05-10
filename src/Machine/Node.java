package Machine;

public class Node {
    private String name;
    private Node overgangNodeA;
    private Node overgangNodeB;

    public Node(String name) {
        this.name = name;
    }

    public void setOvergangNodes(Node overgangNodeA, Node overgangNodeB) {
        this.overgangNodeA = overgangNodeA;
        this.overgangNodeB = overgangNodeB;
    }

    public String getName() {
        return name;
    }

    public Node overgang(Character overgang) {
        if (overgang == 'A') {
            if (overgangNodeA == null) {
                return null;
            } else {
                return overgangNodeA;
            }
        } else if (overgang == 'B') {
            if (overgangNodeB == null) {
                return null;
            } else {
                return overgangNodeB;
            }
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
