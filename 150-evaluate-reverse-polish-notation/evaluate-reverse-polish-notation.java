class Solution {
    public int evalRPN(String[] tokens) {
        
        Stack<Integer> intStack = new Stack<>();//test
        

        for(int i=0; i < tokens.length;i++)
        {
            String token = tokens[i];

            if("+".equals(token) || "-".equals(token)
            || "*".equals(token) ||"/".equals(token))
            {
                int opr2=intStack.pop(), opr1=intStack.pop(),res=0;
                

                switch(token){
                    case "*":  res=opr1*opr2; break;
                    case "+":  res=opr1+opr2; break;
                    case "-":  res=opr1-opr2; break;
                    case "/":  res=opr1/opr2; break;
                    //default :  res=token;
                }

                intStack.push(res);

            }
            else
            intStack.push(Integer.valueOf(token));
        }

        return intStack.peek();
    }
}