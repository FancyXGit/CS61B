import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < 26; i++ ){
            m.put((char)(i + 'a'), i + 1);
        }
        return m;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer, Integer> m = new HashMap<>();
        for (Integer i : nums){
            m.put(i, (int)Math.pow(i, 2));
        }
        return m;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String, Integer> m = new HashMap<>();
        for (String s : words){
            m.put(s, m.getOrDefault(s, 0) + 1);
        }
        return m;
    }
}
