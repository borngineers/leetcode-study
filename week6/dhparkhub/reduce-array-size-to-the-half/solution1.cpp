//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/9/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <vector>
#include <queue>
#include <map>
using namespace std;

class Solution {
  
public:
  int minSetSize(vector<int>& arr) {
    map<int, int> m;
    for (auto e: arr) {
      m[e]++;
    }// O(N)
    
    priority_queue<int> q;
    for (auto e: m) {
//      printf("%d %d\n", e.first, e.second);
      q.push(e.second);
    }// O(NlogN)
    
    auto arr_size = arr.size();
    int sum = 0;
    while (!q.empty()) {
      auto e = q.top();
      q.pop();
      
      answer++;
      sum += e;
      if (sum * 2 >= arr_size) break;
    }// O(NlogN)
    
    return answer;
  }// O(NlogN)
  
private:
  int answer = 0;
  
};
