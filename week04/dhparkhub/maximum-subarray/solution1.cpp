//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/27/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

class Solution {
  
public:
  int maxSubArray(vector<int>& nums) {
    int answer = nums[0];
    int temp = nums[0];
    auto nums_size = nums.size();
    for (int i=1; i<nums_size; i++) {
      temp = temp < 0 ? nums[i] : nums[i] + temp;
      answer = max(answer, temp);
    }
    return answer;
  }
  
};

void trimLeftTrailingSpaces(string &input) {
  input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
    return !isspace(ch);
  }));
}

void trimRightTrailingSpaces(string &input) {
  input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
    return !isspace(ch);
  }).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
  vector<int> output;
  trimLeftTrailingSpaces(input);
  trimRightTrailingSpaces(input);
  input = input.substr(1, input.length() - 2);
  stringstream ss;
  ss.str(input);
  string item;
  char delim = ',';
  while (getline(ss, item, delim)) {
    output.push_back(stoi(item));
  }
  return output;
}

int main() {
  string line;
  while (getline(cin, line)) {
    vector<int> nums = stringToIntegerVector(line);

    int ret = Solution().maxSubArray(nums);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
