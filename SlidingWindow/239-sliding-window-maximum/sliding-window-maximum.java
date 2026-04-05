class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new LinkedList();

        List<Integer> res = new LinkedList();
        
        int l=0,r=0;
        while(r < nums.length)
        {
            while(!deque.isEmpty() && nums[r] > nums[deque.getLast()] )
            {
                deque.removeLast();
            }
            deque.addLast(r);

            if(l > deque.peekFirst() )
            {
                deque.removeFirst();
            }

            if(r+1 >= k)
            {
                res.add(nums[deque.peekFirst()]);
                l++;
            }

            r++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}