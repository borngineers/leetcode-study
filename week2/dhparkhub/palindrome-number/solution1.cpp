//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/6/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
using namespace std;

class Solution {
  
public:
  bool isPalindrome(int x) {
    bool answer = false;
    if (x < 0 ) return false;
    string str = to_string(x);
    return answer = isPalindrome(str, 0);
  }
  
  bool isPalindrome(string str, int index) {
    if (index >= (str.size() / 2)) return true;
    bool temp = str[index] == str[str.size() - index - 1];
    return temp && isPalindrome(str, index + 1);
  }
  
};

int stringToInteger(string input) {
  return stoi(input);
}

string boolToString(bool input) {
  return input ? "True" : "False";
}

int main() {
  string line;
  while (getline(cin, line)) {
    int x = stringToInteger(line);

    bool ret = Solution().isPalindrome(x);

    string out = boolToString(ret);
    cout << out << endl;
  }
  return 0;
}
