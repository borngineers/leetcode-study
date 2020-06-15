//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 1/16/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <stack>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
  
public:
  int leastInterval(vector<char>& tasks, int n) {
    int task_counter[26] = {0,};
    for (auto task: tasks) {
      task_counter[getIndexFromChar(task)]++;
    }
    priority_queue<int> q;
    for (auto e: task_counter) {
      if (e != 0) q.push(e);
    }
    int process_time = 0;
    while (!q.empty()) {
      auto q_size = q.size();
      if (n >= q_size) {
        process_time += (n + 1) * (q.top() - 1);
        int top = q.top();
        while (!q.empty()) {
          if (top != q.top()) break;
          process_time++;
          q.pop();
        }
        break;
      }
      stack<int> s;
      for (int i=0; i<n+1; i++) {
        int temp = q.top();
        if (temp != 1) s.push(temp - 1);
        q.pop();
      }
      while (!s.empty()) {
        q.push(s.top());
        s.pop();
      }
      process_time += n + 1;
    }
    return process_time;
  }
  
  int getIndexFromChar(char ch) {
    return ch - 'A';
  }
  
};
