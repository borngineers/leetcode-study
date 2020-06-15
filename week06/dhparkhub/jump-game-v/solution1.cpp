//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/9/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

class Solution {
  
public:
  int maxJumps(vector<int>& arr, int d) {
    arrSize = (int) arr.size();
    cache.assign(arrSize, 0);
    for (int i=0; i<arrSize; i++) {
      answer = max(answer, getMaxJumps(arr, i, d));// O(D)
    }// O(ND)
    return answer;
  }// O(ND)
  
  int getMaxJumps(vector<int>& arr, int index, int d) {
    if (cache[index]) return cache[index];
    int temp = 0;
    // go left
    for (int i=1; i<=d; i++) {
      int tempIndex = index - i;
      if (!valid(tempIndex)) break;
      if (arr[tempIndex] >= arr[index]) break;
      temp = max(temp, getMaxJumps(arr, tempIndex, d));
    }
    // go right
    for (int i=1; i<=d; i++) {
      int tempIndex = index + i;
      if (!valid(tempIndex)) break;
      if (arr[tempIndex] >= arr[index]) break;
      temp = max(temp, getMaxJumps(arr, tempIndex, d));
    }
    return cache[index] = temp + 1;
  }
  
  bool valid(int i) {
    return i >= 0 && i < arrSize;
  }
  
private:
  int answer = 0;
  int arrSize;
  vector<int> cache;
  
};
