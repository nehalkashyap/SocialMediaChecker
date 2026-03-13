import java.util.*;

public class AutoCompleteSystem {

    HashMap<String,Integer> queries=new HashMap<>();

    public void addQuery(String q){
        queries.put(q,queries.getOrDefault(q,0)+1);
    }

    public void search(String prefix){

        List<String> result=new ArrayList<>();

        for(String q:queries.keySet()){
            if(q.startsWith(prefix)){
                result.add(q);
            }
        }

        result.sort((a,b)->queries.get(b)-queries.get(a));

        System.out.println(result);
    }

    public static void main(String[] args){

        AutoCompleteSystem ac=new AutoCompleteSystem();

        ac.addQuery("java tutorial");
        ac.addQuery("javascript");
        ac.addQuery("java download");

        ac.search("jav");
    }
}