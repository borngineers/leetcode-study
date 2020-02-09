//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/9/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <vector>
using namespace std;

class Solution {
  
public:
  vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
    vector<pair<int, int>> temp;
    
    auto mat_size = mat.size();
    temp.resize(mat_size);
    for (int i=0; i<mat_size; i++) {
      int sum = 0;
      for (auto e: mat[i]) {
        sum += e;
      }
      temp[i] = {i, sum};
    }// O(RC)
    
    sort(temp.begin(), temp.end(), [](pair<int, int> l, pair<int, int> r) {
      if (l.second == r.second) {
        return l.first < r.first;
      }
      return l.second < r.second;
    });// O(RlogR)
    
    answer.resize(k);
    for (int i=0; i<k; i++) {
      answer[i] = temp[i].first;
    }// O(K) <= O(R)
    
    return answer;
  }// O(RC + RlogR)
  
private:
  vector<int> answer;
  
};
