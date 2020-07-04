class Solution {
    public int countPrimes(int n) {
        
        if(n <= 2) return 0;
        
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, false);
        int answer = 0;
        
        for(int i=2; i<n; i++) {
            if(isPrime[i]) continue;
            
            isPrime[i] = true;
            answer++;
            
            for(int j=i+i; j<n; j += i) {
                isPrime[j] = true;
            }
        }
        
        return answer;
    }
}
