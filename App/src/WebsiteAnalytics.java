import java.util.*;

public class WebsiteAnalytics {

    HashMap<String,Integer> pageViews = new HashMap<>();
    HashMap<String, Set<String>> uniqueUsers = new HashMap<>();
    HashMap<String,Integer> sourceCount = new HashMap<>();

    public void processEvent(String url, String userId, String source) {

        pageViews.put(url, pageViews.getOrDefault(url,0)+1);

        uniqueUsers.putIfAbsent(url,new HashSet<>());
        uniqueUsers.get(url).add(userId);

        sourceCount.put(source, sourceCount.getOrDefault(source,0)+1);
    }

    public void dashboard() {

        System.out.println("Page Views: "+pageViews);
        System.out.println("Unique Visitors: "+uniqueUsers);
        System.out.println("Traffic Sources: "+sourceCount);
    }

    public static void main(String[] args) {

        WebsiteAnalytics wa = new WebsiteAnalytics();

        wa.processEvent("/news","user1","google");
        wa.processEvent("/news","user2","facebook");
        wa.processEvent("/sports","user3","google");

        wa.dashboard();
    }
}