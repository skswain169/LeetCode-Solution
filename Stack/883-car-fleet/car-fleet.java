class Solution {
    public int carFleet(int target, int[] position, int[] speed) {

      /*
      Intuition: We need to find where car, intersect to find a fleet, that could be done
                 by finding the time for a car to reach the target.    
      Approach: Sort descending by distance and calculate the time to reach destination
        ,compare time to know if car fleet is formed or not.
      */  

      int pos_speed_pair[][] = new int [speed.length][2];
      Stack<Double> time = new Stack();

    for(int i=0; i< speed.length; i++)
    {
        pos_speed_pair[i][0]=position[i];
        pos_speed_pair[i][1]=speed[i];
    }

    Arrays.sort(pos_speed_pair,(a,b) -> Integer.compare(b[0],a[0]));


    for(int [] pair : pos_speed_pair )
    {
        Double car_time=(double)(target-pair[0])/pair[1];

    if(time.isEmpty() )
        time.push(car_time);
    else if( time.peek() < car_time)
        {
         time.push(car_time);
        }

    }
    return time.size();


    }
}