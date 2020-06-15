class Solution {
    public List<String> fizzBuzz(int n) {
        
        //sb를 String으로 썼을때 9ms
        //sb를 StringBuilder로 사용했을때 2ms
        List<String> answer = new ArrayList<>();
        
        String add3 = "Fizz";
        String add5 = "Buzz";
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<=n; i++) {
            int remainder1 = i % 3;
            int remainder2 = i % 5;
            
            if(remainder1 == 0) sb.append(add3);
            if(remainder2 == 0) sb.append(add5);
            if(remainder1 != 0 && remainder2 != 0) sb.append(i);
            answer.add(sb.toString());  
            
            // sb.delete(0, sb.length()); => 2ms
            // sb.setLength(0); => 1ms
            sb.setLength(0);
        }
        
        return answer;
    }
}
