import java.util.*;

class DNSEntry {
    String ip;
    long expiry;

    DNSEntry(String ip, long ttl) {
        this.ip = ip;
        this.expiry = System.currentTimeMillis() + ttl;
    }
}

public class DNSCache {

    HashMap<String, DNSEntry> cache = new HashMap<>();
    int hits = 0, misses = 0;

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiry) {
                hits++;
                return "Cache HIT: " + entry.ip;
            } else {
                cache.remove(domain);
            }
        }

        misses++;
        String newIP = "172.217.14." + new Random().nextInt(200);
        cache.put(domain, new DNSEntry(newIP, 5000));

        return "Cache MISS → " + newIP;
    }

    public void stats() {
        System.out.println("Hits: " + hits + " Misses: " + misses);
    }

    public static void main(String[] args) {

        DNSCache dns = new DNSCache();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));

        dns.stats();
    }
}