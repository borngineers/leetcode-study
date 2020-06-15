//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/27/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
  
public:
  int climbStairs(int n) {
    cache.resize(n+1);
    return dp(n);
  }
  
  int dp(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    if (cache[n]) return cache[n];
    return cache[n] = dp(n-1) + dp(n-2);
  }
  
private:
  vector<int> cache;
  
};

int stringToInteger(string input) {
  return stoi(input);
}

int main() {
  string line;
  while (getline(cin, line)) {
    int n = stringToInteger(line);

    int ret = Solution().climbStairs(n);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
