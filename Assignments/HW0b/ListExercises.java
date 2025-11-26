import java.util.*;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum = 0;
        for (Integer integer : L) {
            sum += integer;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> l = new ArrayList<>();
        for (Integer integer : L){
            int val = integer;
            if (val % 2 == 0){
                l.add(val);
            }
        }
        return l;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> copy1 = new ArrayList<>(L1);
        List<Integer> copy2 = new ArrayList<>(L2);
        Collections.sort(copy1);
        Collections.sort(copy2);
        List<Integer> res = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < copy1.size() && p2 < copy2.size()){
            if (Objects.equals(copy1.get(p1), copy2.get(p2))){
                res.add(copy1.get(p1));
                p1++;
                p2++;
            }else if (copy1.get(p1) < copy2.get(p2)){
                p1++;
            }else{
                p2++;
            }
        }
        return res;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count = 0;
        for (String s1 : words) {
            for (int i = 0; i < s1.length(); i++) {
                char ch = s1.charAt(i);
                if (c == ch) {
                    count++;
                }
            }
        }
        return count;
    }
}
