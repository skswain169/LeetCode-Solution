class TimeMap {

    HashMap <String,List<Object[]>> hm;

    public TimeMap() {
        hm = new HashMap();
    }

    public void set(String key, String value, int timestamp) {

        Object[] pair = { timestamp, value };

        List list = new ArrayList<>();
        if (hm.containsKey(key)) {
            list = hm.get(key);
        }
        list.add(pair);
        hm.put(key, list);

    }

    public String get(String key, int timestamp) {

        String value = "";

        if (hm.containsKey(key)) {
            List list = hm.get(key);

            if(!list.isEmpty())
            value = binarySearch(list, timestamp);
        }

        return value;

    }

    String binarySearch(List<Object[]> list, int target) {
        int r = list.size() - 1, l = 0;
        int mid=0; 
        String res="";
        while (l <= r) {
             mid = (l + r) / 2;
            int mid_ts = (int) list.get(mid)[0];

            if (target < mid_ts) {
                r = mid - 1;
            } else {
                l = mid + 1;
                /*Possible result if "="" or largest min under target
                is not found in further scans 
                */
                res =(String) list.get(mid)[1]; 
            }
        }
        return res;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */