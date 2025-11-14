class LRUCache {

    class Node{
        int val,key;
        Node next,prev;

        public Node(int key, int val)
        {
            this.val=val;
            this.key=key;
        }
    }
     HashMap<Integer,Node> cacheMap;
     Node left,right;
     int  capacity;

    public LRUCache(int capacity) {

        cacheMap = new HashMap<>(capacity);
        left =new Node(0,0);
        right = new Node(0,0);
        left.next=right;
        right.prev=left;
        this.capacity= capacity;
        
    }
    
    public int get(int key) {
        Node retNode=cacheMap.get(key);
        //lru
        if(retNode !=null)
        {
         remove(retNode);
         addAtRight(retNode);
        }
        return retNode == null ? -1 : retNode.val;
    }
    
    public void put(int key, int value) {

        Node newNode = new Node(key,value);

        if(cacheMap.containsKey(key))
        {
            remove(cacheMap.get(key));
            //cacheMap.remove(key); 
            
        }
         addAtRight(newNode);  
        cacheMap.put(key,newNode);  
        if(cacheMap.size() > capacity)
        {
            //remove at left
            Node lru = left.next;
            remove(lru);
            cacheMap.remove(lru.key);
   
        }   
          
    }

    public void addAtRight(Node node)
    {
        Node prev= right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=right;
        right.prev=node;

    }

    public void remove(Node node)
    {
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */