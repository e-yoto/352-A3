public class Large extends ElasticERL {
    
    //HashTable with Chaining
    
    private HashNode<Integer, String>[] table;
    private int size = 0;

    
    public Large(int size){
        super();
        table = new HashNode[size];
        this.size = size;
    }

    public void add(int key, String value){
        HashNode<Integer, String> newNode = new HashNode<Integer,String>(key, value, null, null);
        int bucket = key % this.size;

        HashNode<Integer, String> existingNode = table[bucket];
        System.out.println("bucket: " + bucket);

        while (existingNode != null)
        {
            System.out.println("TRAVERSIN " + existingNode.key); 
            //overwrite if key exists
            if (existingNode.key == key)
            {
                existingNode.value = value;
                return;
            }
                

            existingNode = existingNode.next;
        }
        
        existingNode = table[bucket];
        newNode.next = existingNode;
        if (existingNode != null)
        {
            existingNode.prev = newNode;
        }
        table[bucket] = newNode;
        System.out.println("JUST ADDED " + newNode.key + " " + newNode.value); 

        // if (existingNode == null)
        // {
        //     table[bucket] = newNode;
        //     tail = newNode;
        //     head = newNode;
            
        // }
        // else
        // {
        //     HashNode<Integer, String> temp = tail;
        //     System.out.println("current " + newNode.key + " PREVKEY " + tail.key);
        //     tail.next = newNode;
        //     newNode.prev = tail;
        //     tail = tail.next;
        //     tail.prev = temp;
            
        // }
    }

    public void remove (int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = get(key);
        HashNode<Integer, String> temp = h;

        while (h.next != null)
        {
            if (h.key == key)
            {
                break;
            }
            
            //else keep moving
            temp = h;

            h = h.next;
        }

        if (h != null)
        {
            
            System.out.println("removing: " + h.key + ", " + h.value);
            if (h.next != null && h.prev == null)
            {
                System.out.println("temp : " + temp.key);
                System.out.println("h: " + h.key);
                System.out.println("h next: " + h.next.key);
                System.out.println("case0");
                h = h.next;
                temp.next = null;
                table[bucket] = h;
                
                System.out.println("temp : " + temp.key + " " + temp.value);
                System.out.println("h: " + h.key);
                System.out.println("h next: " + h.next.key);

                // System.out.println("temp : " + temp.key);
                // System.out.println("h: " + h.key);

                // h.next.prev = temp.prev;
                // h.prev.next = temp.next;
                // h = h.next;

                // temp.next = null;
                // temp.prev = null;
            }
            else if (h.next != null)
            {
                System.out.println("temp : " + temp.key);
                System.out.println("h: " + h.key);
                System.out.println("h next: " + h.next.key);
                System.out.println("case1");
                temp = h.prev;
                h = h.next;

                temp.next = h;

                // System.out.println("temp : " + temp.key);
                // System.out.println("h: " + h.key);

                // h.next.prev = temp.prev;
                // h.prev.next = temp.next;
                // h = h.next;

                // temp.next = null;
                // temp.prev = null;
            }
            else
            {
                System.out.println("temp : " + temp.key);
                System.out.println("h: " + h.key);
                System.out.println("case2");
                h = h.prev;
                h.next = null;
                temp = null;
            }
        }

    }

    public HashNode<Integer, String> get(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];
        

        while (h != null) 
        {
            if (h.key == key )
            {
                return h;
            }
                
            h = h.next;
        }
        
        
        return null;
    }

    public String getValue(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];
        System.out.println("BUCKETTTT: " + bucket);
        System.out.println(h.value);
        do 
        {
            if (h.key == key)
            {
                System.out.println("da value " + h.value);
                return h.value;
            }
        } 
        while (h.next != null); 
        {
            System.out.println("H VALUE " + h.value);
            if (h.key == key)
            {
                return h.value;
            }
            h = h.next;
        }

        return "Not found";
    }

    public int nextKey(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];


        System.out.println("current key: " + h.key);
        System.out.println("next key: " + h.next.key);

        while (h.next != null)
        {
            if (h.key == key)
            {
                return h.next.key;
            }
            h = h.next;
        }

        return -2;
    }

    public int prevKey(int key)
    {
        int bucket = key % this.size;
        HashNode<Integer, String> h = table[bucket];

        if (h.key == key)
        {
            //first in the bucket, there is no previous
            return -1;
        }
            
        while (h != null)
        {
            if (h.key == key)
                return h.prev.key;
            
            h = h.next;
        }

        return -2;
    }

    public int[] rangeKey(int k1, int k2)
    {
        if (k1 % this.size != k2 % this.size)
            return null;
        else
        {
            HashNode<Integer, String> h = table[k1 % this.size];
            HashNode<Integer, String> first = null;
            HashNode<Integer, String> second = null;
            Small<Integer, String> list = new Small<>();

            //find which comes first
            while (h != null)
            {
                if (h.key == k1 || h.key == k2)
                {
                    first = h;
                    break;
                }
                h = h.next;
            }

            second = first.next;

            while (second != null)
            {
                System.out.println("RANGEKEY " + second.key);
                //second.value;
                if (second.key == k2)
                    break;
                list.addLast(second.key, second.value);
                second = second.next;
            }

            int[] a = new int[list.size()];
            for (int i = 0; i < list.size(); i++)
            {
                a[i] = list.get(i).key;
            }

            return a;
        }
    }

    public void listAll(){
        for (HashNode<Integer, String> h: table)
        {
            if (h == null)
            {
                continue;
            }

            System.out.println(h.key + " " + h.value);

            HashNode<Integer, String> temp = h;
            while (temp.next != null)
            {
                temp = temp.next;
                System.out.println(temp.key + " " + temp.value);
                h = h.next;
            }
        }
    }
}