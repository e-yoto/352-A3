public class Node<Integer, String> {
    int key;
    String value;
    Node<Integer, String> next;

    public Node(int key, String value)
    {
        this.key = key;
        this.value = value;
    }
}
