class Solution {
    public String minWindow(String s, String t) {

        if (t.isEmpty())
            return "";

        Map<Character, Integer> tcount = new HashMap();
        Map<Character, Integer> window = new HashMap();

        for (char c : t.toCharArray()) {
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }
        int need = tcount.size(), have = 0;

        int l = 0, reslength = Integer.MAX_VALUE;
        int[] lr = { -1, -1 };

        for (int r = 0; r < s.length(); r++) {
            char w = s.charAt(r);
            window.put(w, window.getOrDefault(w, 0) + 1);

            if (tcount.containsKey(w) && tcount.get(w).equals(window.get(w))) // use equals instead of ==,to avoid error in long ranges > 128, check Integer Caching
                have++;

            while (need == have) {
                if (reslength > r - l + 1) {  
                    reslength = r - l + 1;
                    lr[0] = l; //better than substring(), as that would result in O(n) time, and index lookup is O(1)
                    lr[1] = r;
                }
                char left = s.charAt(l);
                window.put(left, window.get(left) - 1);

                if (tcount.containsKey(left) && window.get(left) < tcount.get(left)) {
                    have--;
                }
                l++;
            }
        }

        return reslength == Integer.MAX_VALUE ? "" : s.substring(lr[0], lr[1] + 1);

    }
}
