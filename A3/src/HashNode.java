public class HashNode<Integer, Val>{
    
    final int key;
    Val value;
    HashNode<Integer, Val> next;
    HashNode<Integer, Val> prev;
    boolean isHead = false;
    boolean isTail = false;

    public HashNode(int key, Val value, HashNode<Integer, Val> prev, HashNode<Integer, Val> next){
        this.key = key;
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    
}
