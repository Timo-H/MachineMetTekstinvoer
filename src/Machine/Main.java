package Machine;
import java.util.Arrays;

public class Main {
    public static void main(String [] args) {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");

        s0.setOvergangNodes(s2, s1);
        s1.setOvergangNodes(s1, s2);
        s2.setOvergangNodes(null, s3);
        s3.setOvergangNodes(s3, s0);

        f("BAABA", s0);
    }

    public static void f(String tekst, Node currentNode) {
        Node[] nodeList = {currentNode};
        char stopChar = 'A';
        for (int i = 0; i < tekst.length(); i++) {
            if (currentNode.overgang(tekst.charAt(i)) == null) {
                stopChar = tekst.charAt(i);
                break;
            } else {
                currentNode = currentNode.overgang(tekst.charAt(i));
                nodeList = Arrays.copyOf(nodeList, nodeList.length + 1);
                nodeList[nodeList.length - 1] = currentNode;
                }
        }
        if (tekst.length() > nodeList.length-1) {
            System.out.println(Arrays.toString(nodeList));
            System.out.println("Ongeldige stap " + currentNode + " heeft geen overgang met " + stopChar);
        } else {
            System.out.println(Arrays.toString(nodeList));
            System.out.println("Tekst helemaal doorgelopen!");
        }
    }
}
