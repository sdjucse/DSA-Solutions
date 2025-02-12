
import java.util.*;


public class LRUCache{
    /*
     * T.C:-O(1)
     * S.C:-O(N)
     */
    private LinkedHashMap<Integer,Integer>map= new LinkedHashMap<>();
    private int capacity;

    public LRUCache(int capacity){
        this.capacity=capacity;
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Integer val=map.get(key);
        put(key,val);
        return val;

    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            map.remove(key);
        }
        else if(capacity==map.size()){
            map.remove(map.keySet().iterator().next());
        }
        map.put(key, value);
    }
}