package self.Collection.Map;

import java.util.*;

public class SortByKeys {
    public static void main(String[] args) {
        Map<String,Integer> mp=new LinkedHashMap<>();
        mp.put("s",1);
        mp.put("a",13);
        mp.put("r",23);
        System.out.println("original map");
        System.out.println(mp);

//          1st way
//        Map<String,Integer>treemap=new TreeMap<>(mp);
//
//        System.out.println("sorted map by treemap 1");
//        System.out.println(treemap);

        // 2nd way
//        Map<String,Integer>treemap=new TreeMap<>(Collections.reverseOrder());
//        treemap.putAll(mp);
//        System.out.println(treemap);

//        //3rd way
//       Map<String,Integer>treemap=new TreeMap<>(new Comparator<String>(){
//          public int compare(String o1,String o2){
////              return Integer.compare(o2.length(), o1.length());//wrong
//              return o1.compareTo(o2);
//          }
//       });
//       treemap.putAll(mp);
//        System.out.println(treemap);

        // 4th way
//        Map<String,Integer>treeMap=new TreeMap<>(Comparator.naturalOrder());
//        treeMap.putAll(mp);
//        System.out.println(treeMap);







    }

}
