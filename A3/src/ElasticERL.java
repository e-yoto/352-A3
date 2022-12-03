import java.util.Random;

public class ElasticERL {

    private int size;
    ElasticERL smallErl;
    ElasticERL mediumErl;
    ElasticERL largeErl;
    
    public ElasticERL(){
        
    }

    public ElasticERL(int size){
        SetEINThreshold(size);
    }
    
    public void SetEINThreshold(int size){
        if (100 <= size && size < 10000)
        {
            //small
        }
        else if(10000 <= size && size < 100000)
        {
            //medium
        }
        else if (size <= 100000 && size <= 500000)
        {
            this.size = size;
            largeErl = new Large(size);
        }
        else
            System.out.println("Invalid size.");
    }

    public void generate(){
        Random rand = new Random();

        int k = rand.nextInt(9000000) + 1000000;

        while (allKeys(this) == null)
        {
            k = rand.nextInt(9000000) + 1000000;
        }
        
        System.out.println("Unique key generated: " + k);
    }

    public int[] allKeys(ElasticERL e){
        return null;
    }

    public void add(ElasticERL e, int key, String value){
        
    }

    public void remove(ElasticERL e, int key){

    }

    public int[] getValues(ElasticERL e, int key){
        return null;
    }

    public int nextKey(ElasticERL e, int key){
        return -100;
    }

    public int prevKey(ElasticERL e, int key){
        return -100;
    }

    public int rangeKey(int key1, int key2){
        return -100;
    }
}