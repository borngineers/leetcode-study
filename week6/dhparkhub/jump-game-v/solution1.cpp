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
      answer = max(answer, getMaxJumps(arr, i, d));
    }
//    for (auto e: cache) {
//      printf("%d\n", e);
//    }
    return answer;
  }
  
  int getMaxJumps(vector<int>& arr, int index, int d) {
    int temp = 0;
    bool minusFlag = false;
    bool plusFlag = false;
    for (int i=1; i<=d; i++) {
      if (minusFlag && plusFlag) break;
      // back case
      int tempIndex = index - i;
      if (!minusFlag && valid(tempIndex) && arr[tempIndex] < arr[index]) {
        temp = max(temp, cache[tempIndex] ? cache[tempIndex] : getMaxJumps(arr, tempIndex, d));
      } else {
        minusFlag = true;
      }
      // front case
      tempIndex = index + i;
      if (!plusFlag && valid(tempIndex) && arr[tempIndex] < arr[index]) {
        temp = max(temp, cache[tempIndex] ? cache[tempIndex] : getMaxJumps(arr, tempIndex, d));
      } else {
        plusFlag = true;
      }
    }
    puts("");
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
