//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/16/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
using namespace std;

class Solution {
  
public:
  
  int removeDuplicates(vector<int>& nums) {
    int answer = 0;
    auto size = nums.size();
    int j = 0;
    int temp = 0;
    for (int i=0; i<size; i++) {
      if (i != 0 && nums[i] == temp) continue;
      answer++;
      nums[j++] = temp = nums[i];
    }// O(N)
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

string integerVectorToString(vector<int> list, int length = -1) {
  if (length == -1) {
    length = list.size();
  }

  if (length == 0) {
    return "[]";
  }

  string result;
  for(int index = 0; index < length; index++) {
    int number = list[index];
    result += to_string(number) + ", ";
  }
  return "[" + result.substr(0, result.length() - 2) + "]";
}

int main() {
  string line;
  while (getline(cin, line)) {
    vector<int> nums = stringToIntegerVector(line);

    int ret = Solution().removeDuplicates(nums);

    string out = integerVectorToString(nums, ret);
    cout << out << endl;
  }
  return 0;
}
