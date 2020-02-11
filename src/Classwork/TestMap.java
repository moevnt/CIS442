package Classwork;

//import java.util.Map;
import java.util.*;
public class TestMap {

    private Map<String, String> map;

    public TestMap(){
        map = new TreeMap<>();
    }

    public void insert(String x, String y){
        if (!map.containsKey(x))
            map.put(x,y);

        Set<String> keys = map.keySet();
    }


    public  void printMap(){
        System.out.println("Using for each loop");
        for (int i =0;i<map.size();i++) {
            var key =
             var value = map.values();
                 System.out.println(key+" --> "+value);
        }
    }

    public static void main(String[] args){
        TestMap map = new TestMap();

        map.insert("Evan", "A");
        map.insert("Angel", "A");
        map.insert("Alex", "F");
        map.insert("Johnny", "B");

        map.printMap();
    }
}
