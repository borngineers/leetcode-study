//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/2/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {

public:
  string longestCommonPrefix(vector<string>& strs) {
    auto strs_size = strs.size();
    if (strs_size == 0) return "";
    
    auto min_str_size = strs[0].size();
    for (auto str: strs) {
      min_str_size = min(min_str_size, str.size());
    }
    
    int index = 0;
    bool finished = false;
    while (index < min_str_size && !finished) {
      char temp = strs[0][index];
      for (int i=1; i<strs_size; i++) {
        if (temp != strs[i][index]) {
          finished = true;
          break;
        }
      }
      if (!finished) index++;
    }
    
    return answer = strs[0].substr(0, index);
  }

private:
  string answer;

};
