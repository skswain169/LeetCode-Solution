class Solution {
    public int characterReplacement(String s, int k) {

int l=0,r=0,res=0;
Map<Character,Integer> freq = new HashMap<>();
        for(; r < s.length() ;r++)
        {
            char c = s.charAt(r);
            freq.put(c,freq.getOrDefault(c,0)+1);

            int maxVal=freq.values().stream().max(Integer::compare).orElse(0);
            while((r-l+1 - maxVal)  > k )
            {
                freq.put(s.charAt(l),freq.get(s.charAt(l))-1);
                l++;
            }  

            res= Math.max(res,r-l+1);
        }

        return res;
        
    }
}