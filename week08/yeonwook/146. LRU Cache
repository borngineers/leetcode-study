class LRUCache {
	
	int capacity;
	int use;
	Map<Integer, Node> cache;
	Node head;
	Node end;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.use = 0;
    }
    
    public int get(int key) {
        
    	//있으면 get 
    	//순서변경 (삭제, 맨앞에 삽입)
    	if(cache.containsKey(key)) {
    		Node node = cache.get(key);
    		int answer = node.value;
    		
    		removeNode(node);
    		addHead(node);
    		
    		return answer;
    	} else { //cache에 없으면 -1 return
    		return -1;
    	}
    }
    
    public void put(int key, int value) {
       
    	//있으면 (삭제, 맨앞에 삽입)
    	if(cache.containsKey(key)) {
    		Node node = cache.get(key);
    		node.value = value;
    		cache.put(key, node);
    		removeNode(node);
    		addHead(node);
    		
    	} else { //없으면 맨앞에 삽입 , cache 추가
    		
    		System.out.println("신규생성  "+ key);
    		Node node = new Node(key, value);
    		addHead(node);
    		cache.put(key, node);
    		use++;
    		
    		//capa를 넘으면 endNode 삭제, cache 삭제
    		if(use > capacity) {
    			cache.remove(end.key);
    			removeNode(end);
    			use--;
    		}
    	}
    }
    
    public void addHead(Node node) {
    	
    	if(head==null) {
    		head = node;
    	} else {
    		node.next = head;
    		node.next.pre = node;
    		head = node;
    	}
    	
    	if(end == null) {
    		end = node;
    	} 
    	
    }
    
    public void removeNode(Node node) {
    	
    	if(node.pre == null) {
    		head = node.next;
    	} else {
    		node.pre.next = node.next;
    	}
    	
    	if(node.next == null) {
    		end = node.pre;
    	} else {
    		node.next.pre = node.pre;
    	}
        
        node.pre = null;
    	node.next = null;
    }
    
}


class Node {
   
   int key;
   int value;
   
   Node next;
   Node pre;
   
   public Node(int key, int value) {
      this.key = key;
      this.value = value;
   }
}
