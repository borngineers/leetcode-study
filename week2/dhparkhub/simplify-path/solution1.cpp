//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/7/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <stack>
using namespace std;

class Solution {

public:
  string simplifyPath(string path) {
    stack<string> s;
    vector<string> splited = split(path, '/');
    for (auto e: splited) {
      if (e == "" || e == ".") continue;
      if (e == "..") {
        if (!s.empty()) {
          s.pop();
        }
      } else {
        s.push(e);
      }
    }

    string answer = "";
    if (s.empty()) {
      answer = "/";
    } else {
      while (!s.empty()) {
        answer = "/" + s.top() + answer;
        s.pop();
      }
    }

    return answer;
  }

  vector<string> split (const string &s, char delim) {
    vector<string> result;
    stringstream ss (s);
    string item;
    while (getline (ss, item, delim)) {
      result.push_back (item);
    }
    return result;
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
    string path = stringToString(line);

    string ret = Solution().simplifyPath(path);

    string out = (ret);
    cout << out << endl;
  }
  return 0;
}
