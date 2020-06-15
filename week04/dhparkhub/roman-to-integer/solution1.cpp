//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/27/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
  
public:
  int romanToInt(string s) {
    unordered_map<char, int> m;
    m.insert({'I', 1});
    m.insert({'V', 5});
    m.insert({'X', 10});
    m.insert({'L', 50});
    m.insert({'C', 100});
    m.insert({'D', 500});
    m.insert({'M', 1000});
    
    int answer = 0;
    auto s_size = s.size();
    for (int i=0; i<s_size; i++) {
      if (s[i] == 'I' && s[i+1] == 'V') {
        answer += 4;
        i++;
        continue;
      }
      if (s[i] == 'I' && s[i+1] == 'X') {
        answer += 9;
        i++;
        continue;
      }
      if (s[i] == 'X' && s[i+1] == 'C') {
        answer += 90;
        i++;
        continue;
      }
      if (s[i] == 'X' && s[i+1] == 'L') {
        answer += 40;
        i++;
        continue;
      }
      if (s[i] == 'C' && s[i+1] == 'D') {
        answer += 400;
        i++;
        continue;
      }
      if (s[i] == 'C' && s[i+1] == 'M') {
        answer += 900;
        i++;
        continue;
      }
      answer += m.at(s[i]);
    }
    return answer;
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

    int ret = Solution().romanToInt(s);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
