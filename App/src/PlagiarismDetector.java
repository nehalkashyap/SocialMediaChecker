import java.util.*;

public class PlagiarismDetector {

    HashMap<String, Set<String>> ngramMap = new HashMap<>();

    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i] + " " + words[i+1] + " " +
                    words[i+2] + " " + words[i+3] + " " + words[i+4];

            ngramMap.putIfAbsent(gram, new HashSet<>());
            ngramMap.get(gram).add(docId);
        }
    }

    public void analyze(String docId, String text) {

        String[] words = text.split(" ");
        int matches = 0;

        for (int i = 0; i < words.length - 4; i++) {

            String gram = words[i]+" "+words[i+1]+" "+words[i+2]+" "+words[i+3]+" "+words[i+4];

            if (ngramMap.containsKey(gram)) {
                matches++;
            }
        }

        System.out.println("Matching n-grams: " + matches);
    }

    public static void main(String[] args) {

        PlagiarismDetector pd = new PlagiarismDetector();

        pd.addDocument("doc1", "this is a simple example of plagiarism detection system");

        pd.analyze("doc2", "this is a simple example of plagiarism check");
    }
}