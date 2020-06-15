//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/2/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
  
public:
  int minCostClimbingStairs(vector<int>& cost) {
    auto stair_size = cost.size();
    cache.assign(stair_size + 1, 0);
    return answer = getMinCostClimbingStairs(stair_size, cost);
  }
  
  int getMinCostClimbingStairs(int n, vector<int>& cost) {
    if (n <= 1) return 0;
    if (cache[n]) return cache[n];
    int cost1 = getMinCostClimbingStairs(n-1, cost) + cost[n-1];
    int cost2 = getMinCostClimbingStairs(n-2, cost) + cost[n-2];
    return cache[n] = min(cost1, cost2);
  }// O(N)
  
private:
  int answer;
  vector<int> cache;
  
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

int main() {
  string line;
  while (getline(cin, line)) {
    vector<int> cost = stringToIntegerVector(line);

    int ret = Solution().minCostClimbingStairs(cost);

    string out = to_string(ret);
    cout << out << endl;
  }
  return 0;
}
