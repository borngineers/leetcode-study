//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/27/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
  
public:
  int uniquePaths(int m, int n) {
    cache.resize(n, vector<int>(m, 0));
    return answer = getUniquePaths(n-1, m-1);
  }
  
  int getUniquePaths(int r, int c) {
    if (r == 0 || c == 0) return 1;
    if (cache[r][c]) return cache[r][c];
    return cache[r][c] = getUniquePaths(r-1, c) + getUniquePaths(r, c-1);
  }
  
private:
  int answer = 0;
  vector<vector<int>> cache;
  
};

int stringToInteger(string input) {
  return stoi(input);
}

int main() {
  string line;
  while (getline(cin, line)) {
    int m = stringToInteger(line);
    getline(cin, line);
    int n = stringToInteger(line);

    int ret = Solution().uniquePaths(m, n);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
