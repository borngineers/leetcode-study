//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 12/31/19.
//  Copyright © 2019 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

class Solution {

public:
  int reverse(int x) {
    int answer;
    
    string str = to_string(x);
    std::reverse(x < 0 ? str.begin() + 1 : str.begin(), str.end());
    
    auto str_size = str.size();
    for (int i=0; i<str_size; i++) {
      if (str[i] != '0' && str[i] != '-') {
        str = str.substr(i);
        break;
      }
    }// O(N)
    
    // prevent overflow 
    try {
      answer = stoi(str);// O(?)
      answer = x < 0 ? -answer : answer;
    } catch (exception e) {
      answer = 0;
    }
    
    return answer;
  }

};

int stringToInteger(string input) {
  return stoi(input);
}

int main() {
  string line;
  while (getline(cin, line)) {
    int x = stringToInteger(line);

    int ret = Solution().reverse(x);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
