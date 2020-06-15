//
//  solution2.cpp
//  leetcode
//
//  Created by dhpark on 1/5/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
using namespace std;

class Solution {

public:
  int reverse(int x) {
    int answer;
    
    // reverse the number
    long temp_answer = 0;
    while (x != 0) {
      temp_answer = temp_answer * 10 + (x % 10);
      x /= 10;
    }// O(D)
    
    // check overflow 
    answer = (int) temp_answer;
    if (answer != temp_answer) {
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
