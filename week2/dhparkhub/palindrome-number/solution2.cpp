//
//  solution2.cpp
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
    if (x < 0) return false;
    int temp = x;
    long reversed = 0;
    while (temp != 0) {
      reversed = reversed * 10 + temp % 10;
      temp /= 10;
    }
    return x == reversed;
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
