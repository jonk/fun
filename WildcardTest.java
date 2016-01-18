import java.util.*;
import java.util.regex.*;

class WildcardTest {
    public static void main(String[] args) {
        String query = "&lt;b&gt;Bolded Text&lt;/b&gt;, &lt;i&gt; Italicized Text &lt;/i&gt;";

        int start = 0;

        Pattern safeTags = Pattern.compile("&lt;(/?b|/?i|/?u)&gt;");

        Matcher m = safeTags.matcher(query);
        System.out.println(m.find());
        System.out.println((m.replaceAll("<" + m.group(1) + ">")));
    }


}