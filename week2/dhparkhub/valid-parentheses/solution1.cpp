//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/6/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <stack>
using namespace std;

class Solution {
  
public:
  bool isValid(string str) {
    bool answer = true;
    
    stack<char> s;
    for (auto e: str) {
      if (e == '(' || e == '[' || e == '{') {
        s.push(e);
      } else {
        if (s.empty()) {
          answer = false;
          break;
        } else if (e == ')' && s.top() == '(') {
          s.pop();
        } else if (e == ']' && s.top() == '[') {
          s.pop();
        } else if (e == '}' && s.top() == '{') {
          s.pop();
        } else {
          answer = false;
          break;
        }
      }
    }
    
    return answer && s.empty();
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

string boolToString(bool input) {
  return input ? "True" : "False";
}

int main() {
  string line;
  while (getline(cin, line)) {
    string s = stringToString(line);

    bool ret = Solution().isValid(s);

    string out = boolToString(ret);
    cout << out << endl;
  }
  return 0;
}
