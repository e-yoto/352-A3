public class ElasticERL {

    private int key;
    private String value;
    private int size;

    public ElasticERL(int size){

    }

    public void SetEINThreshold(int size){
        if (100 <= size && size <= 500000)
        {
            this.size = size;
        }
    }

    public void generate(){

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

    public int nextKey( ElasticERL e, int key){
        return -100;
    }

    public int prevKey(ElasticERL e , int key){
        return -100;
    }

    public int rangeKey(int key1, int key2){
        return -100;
    }
}