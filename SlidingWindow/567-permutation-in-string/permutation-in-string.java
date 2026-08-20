class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] s1count = new int[26];
        int[] s2count = new int[26];

        //freq count of first window(size of s1)
        for (int i = 0; i < s1.length(); i++) {
            s1count[s1.charAt(i) - 'a']++;
            s2count[s2.charAt(i) - 'a']++;
        }

        //get initialmatches
        int j = 0, matches = 0;
        while (j < 26) {
            if (s1count[j] == s2count[j])
                matches++;

            j++;
        }

        //slide  window as per s1 size and update matches
        int l = 0, r = s1.length();
        while (r < s2.length()) {

            if (matches == 26)
                return true;
            int idx = s2.charAt(r) - 'a';
            s2count[idx]++;
            if (s2count[idx] == s1count[idx])
                matches++;
            else if (s2count[idx] - 1 == s1count[idx])
                matches--;

            idx = s2.charAt(l) - 'a';
            s2count[idx]--;
            if (s2count[idx] == s1count[idx])
                matches++;
            else if (s2count[idx] + 1 == s1count[idx])
                matches--;

            l++;
            r++;
        }

        return matches == 26;

    }
}