//
//  solution1.cpp
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
using namespace std;

class Solution {
  
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<int> answer;
    
    auto size_of_nums = nums.size();
    vector<pair<int, int>> temp_array;
    for (int i=0; i<size_of_nums; i++) {
      temp_array.push_back({nums[i], i});
    }// O(N)
    
    int i = 0;
    int j = size_of_nums - 1;
    while (i < j) {
      int num1 = temp_array[i].first;
      int num2 = temp_array[j].first;
      if (num1 + num2 == target) {
        answer.push_back(temp_array[i].second + 1);// index started with 1
        answer.push_back(temp_array[j].second + 1);// index started with 1
        break;
      } else if (num1 + num2 > target) {
        j--;
      } else {
        i++;
      }
    }// O(N)
    
    sort(answer.begin(), answer.end());// O(1)
    
    return answer;
  }// O(NlogN)
  
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
