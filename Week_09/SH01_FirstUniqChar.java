package Week_09;

import java.util.LinkedHashMap;
import java.util.Map;

public class SH01_FirstUniqChar {
    public static void main(String[] args) {
        SH01_FirstUniqChar sh01_firstUniqChar = new SH01_FirstUniqChar();
        System.out.println(sh01_firstUniqChar.firstUniqChar("loveleetcode"));
    }
    public int firstUniqChar(String s) {
        int index = -1;
        char[] sc = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < sc.length; i++) {
            if (map.containsKey(sc[i])) {
                int num = (Integer) map.get(sc[i]) + 1;
                map.put(sc[i], num);
            } else {
                map.put(sc[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ " - "+entry.getValue());
            if (entry.getValue() == 1) {
                System.out.println(s.indexOf(entry.getKey()));
                index = s.indexOf(entry.getKey());
                break;
            }
        }
        return index;
    }
}
