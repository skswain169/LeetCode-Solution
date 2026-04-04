// class Solution {
//     public String minWindow(String s, String t) {


//         if(t.length() > s.length())
//         return "";

//         Map<Character, Integer> tcount = new HashMap();
//         Map<Character,Integer> window = new HashMap();

        
//         for(char c: t.toCharArray())
//         {
//             tcount.put(c, tcount.getOrDefault(c,0)+1);
//         }
//         int need=tcount.size(), have =0;

//         int l=0, reslength = Integer.MAX_VALUE ;
//         String res_string ="";

//         for(int r = 0; r < s.length() ; r++)
//         {
//             char w = s.charAt(r);
//             window.put(w, window.getOrDefault(w,0)+1);

//             if(tcount.containsKey(w) && tcount.get(w) == window.get(w))
//             have ++;

//             while(need == have)
//             {
//                 String subs= s.substring(l,r+1);
                
//                 if(reslength > subs.length())
//                 {
//                 res_string = subs;
//                 reslength = subs.length(); 
//                 }
//                 char left = s.charAt(l);
//                 window.put(left, window.get(left) - 1);

//                 if (tcount.containsKey(left) && window.get(left) < tcount.get(left)) {
//                     have--;
//                 }
//                 l++;
//             }
//         }

//         return res_string;


        
//     }
// }
public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty()) return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}