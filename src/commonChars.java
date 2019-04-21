import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : commonChars.java
 * Time       : Create on 19-4-21
 * Location   : ../Home/JavaForLeetCode/commonChars.java
 * Function   : LeetCode No.1002
 */
public class commonChars {

    private static List<String> commonCharsResult(String[] A) {
        List<String> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        if (A.length == 0)
            return list;
        StringBuilder s = new StringBuilder(A[0]);
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == null)
                map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        for (String a : A) {
            StringBuilder string = new StringBuilder(a);
            Map<Character, Integer> tempMap = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                if (tempMap.get(string.charAt(i)) == null)
                    tempMap.put(string.charAt(i), 1);
                else
                    tempMap.put(string.charAt(i), tempMap.get(string.charAt(i)) + 1);
            }
            for (Map.Entry<Character, Integer> entry : tempMap.entrySet()) {
                if (map.get(entry.getKey()) > entry.getValue())
                    map.put(entry.getKey(), entry.getValue());
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++)
                list.add(entry.getKey().toString());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        System.out.println(commonCharsResult(A).toString());
    }
}
