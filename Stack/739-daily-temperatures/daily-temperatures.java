class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        
        int[] res= new int[temperatures.length];//test

        Stack<Integer> monStack = new Stack<>();

        for(int i=0; i < temperatures.length ; i++)
        {
            int temp = temperatures[i];
            while(!monStack.isEmpty() && temp > temperatures[monStack.peek()])
            {
              res[monStack.peek()] = i- monStack.pop();
            }
            monStack.push(i);
        }

        return res;
        
    }
}