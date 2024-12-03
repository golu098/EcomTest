package CoreJava.Activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Collections {
    public static void main(String[] args) {
        ArrayList<Integer>list=new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(20);
        list.add(null);
        Iterator<Integer> iterator=list.iterator();
        while(iterator.hasNext()){
            Integer element= iterator.next();
            System.out.println(element);
        }

        HashMap<String,Integer>mp=new HashMap<>();
        mp.put("shiv",1);
        mp.put("kant",2);
        mp.put("kumar",3);
        mp.put("kumar",4);
        mp.put("null",null);
        mp.put("null",5);


        Iterator<Map.Entry<String, Integer>> it=mp.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,Integer>entry=it.next();
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
        Iterator<String> iteratorForKey=mp.keySet().iterator();
        while(iteratorForKey.hasNext()){
            String key=iteratorForKey.next();
            System.out.println("Key "+key+" and value "+mp.get(key));
        }
        Iterator<Integer> iteratorForValues=mp.values().iterator();
        while(iteratorForValues.hasNext()){
            Integer value=iteratorForValues.next();
            System.out.println("Key "+value+" and value "+mp.get(value));
        }

        for(Map.Entry<String,Integer>entry:mp.entrySet()){
            System.out.println("key "+entry.getKey()+" value "+entry.getValue());
        }

        for(String key:mp.keySet()){
            System.out.println(key);
        }

        for(Integer value:mp.values()){
            System.out.println(value);
        }
        mp.forEach((k,v)-> System.out.println(k+" : "+v));
        mp.entrySet().stream().forEach(i-> System.out.println("key "+i.getKey()+" value "+i.getValue()));


    }
}
