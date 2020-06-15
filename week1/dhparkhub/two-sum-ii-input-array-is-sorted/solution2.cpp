//
//  solution2.cpp
//  leetcode
//
//  Created by dhpark on 1/1/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <cstdio>
#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

class Solution {
  
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> answer;
    
    map<int, int> temp_map;
    auto size_of_nums = nums.size();
    for (int i=0; i<size_of_nums; i++) {
      int num1 = nums[i];
      int num2 = target - num1;
      if (temp_map.find(num2) == temp_map.end()) {
        temp_map.insert({num1, i});// O(?) < O(N)
      } else {
        answer.push_back(temp_map[num2] + 1);// index started with 1
        answer.push_back(i + 1);// index started with 1
        break;
      }
    }// O(N)
    
    return answer;
  }// O(N)
  
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

int stringToInteger(string input) {
  return stoi(input);
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
    getline(cin, line);
    int target = stringToInteger(line);

    vector<int> ret = Solution().twoSum(nums, target);

    string out = integerVectorToString(ret);
    cout << out << endl;
  }
  return 0;
}
