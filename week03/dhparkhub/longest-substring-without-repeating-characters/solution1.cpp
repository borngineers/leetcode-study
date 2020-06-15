//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/21/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <unordered_map>
#include <algorithm>
using namespace std;

class Solution {

public:
  int lengthOfLongestSubstring(string s) {
    if (s.empty()) return 0;
    auto s_size = s.size();
    unordered_map<char, int> index_map;
    int start = 0;
    int end = 0;
    int length = 1;
    for (int i=0; i<s_size; i++) {
      if (index_map.count(s[i]) == 0 || index_map[s[i]] < start) {
        end = i;
      } else {
        start = index_map[s[i]] + 1;
      }
      index_map[s[i]] = i;
      length = max(length, end - start + 1);
    }
    return length;
  }

};

string stringToString(string input) {
  assert(input.length() >= 2);
  string result;
  for (int i = 1; i < input.length() -1; i++) {
    char currentChar = input[i];
    if (input[i] == '\\') {
      char nextChar = input[i+1];
      switch (nextChar) {
        case '\"': result.push_back('\"'); break;
        case '/' : result.push_back('/'); break;
        case '\\': result.push_back('\\'); break;
        case 'b' : result.push_back('\b'); break;
        case 'f' : result.push_back('\f'); break;
        case 'r' : result.push_back('\r'); break;
        case 'n' : result.push_back('\n'); break;
        case 't' : result.push_back('\t'); break;
        default: break;
      }
      i++;
    } else {
      result.push_back(currentChar);
    }
  }
  return result;
}

int main() {
  string line;
  while (getline(cin, line)) {
    string s = stringToString(line);

    int ret = Solution().lengthOfLongestSubstring(s);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
