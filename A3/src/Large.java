public class Large extends ElasticERL {
    //HashTable with Chaining
    
    private HashNode<Integer, String>[] table;
    private HashNode<Integer, String> tail;
    private HashNode<Integer, String> head;
    private int size = 0;
    
    public Large(int size){
        HashNode<Integer, String>[] table = new HashNode[size];
    }

    public void put(int key, String value){
        HashNode<Integer, String> newNode = new HashNode<Integer,String>(key, value, null, null);
        int bucket = newNode.key % this.size;

        HashNode<Integer, String> existingNode = table[bucket];
        if (existingNode == null)
        {
            table[bucket] = newNode;
            tail = newNode;
            head = newNode;
            size++;
        }
        else
        {
            HashNode<Integer, String> temp = newNode;
            tail.next = temp;
            tail = tail.next;
            size++;
        }
    }
}