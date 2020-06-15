//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/2/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

class Solution {

public:
  int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
    map = obstacleGrid;
    int r = (int)map.size();
    int c = (int)map[0].size();
    cache.assign(r, vector<int>(c));
    return answer = getUniquePathsWithObstacles(r-1, c-1);
  }
  
  int getUniquePathsWithObstacles(int r, int c) {
    if (!valid(r, c)) return 0;
    if (map[r][c]) return 0;
    if (r == 0 && c == 0) return 1;
    if (cache[r][c]) return cache[r][c];
    return cache[r][c] = getUniquePathsWithObstacles(r-1, c) + getUniquePathsWithObstacles(r, c-1);
  }// O(RC)
  
  bool valid(int r, int c) {
    if (r < 0 || c < 0) return false;
    return true;
  }
  
private:
  int answer;
  vector<vector<int>> map;
  vector<vector<int>> cache;

};
