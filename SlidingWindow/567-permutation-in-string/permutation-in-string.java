class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length())
        return false;

        HashMap<Character, Integer> s1map = new HashMap();
        HashMap<Character, Integer> s2map = new HashMap();

        for(int i=0; i< s1.length();i++)
        {
            s1map.put(s1.charAt(i),s1map.getOrDefault(s1.charAt(i),0)+1);
        }

        // for(int i=0; i< s2.length();i++)
        // {
        //     s2map.put(s2.charAt(i),s2.getOrDefault(0)+1);
        // }

        int l=0, r=0;

        while( r < s2.length())
        {

            s2map.put(s2.charAt(r),s2map.getOrDefault(s2.charAt(r),0)+1);

            if(r-l+1 == s1.length())
            {
                if (s1map.equals(s2map.entrySet().stream()
                                    .filter(e -> e.getValue() != 0)
                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)))) return true;


                s2map.put(s2.charAt(l),(s2map.get(s2.charAt(l))-1)<0 ? 0 : s2map.get(s2.charAt(l))-1);
                l++;

            }


            r++;

        }
        return s1map.equals(s2map.entrySet().stream()
                                    .filter(e -> e.getValue() != 0)
                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
}