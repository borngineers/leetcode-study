//
//  solution1.cpp
//  leetcode
//
//  Created by dhpark on 2/9/20.
//  Copyright © 2020 daeho.park. All rights reserved.
//

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
  
public:
  int maxProduct(TreeNode* root) {
    int treeSum = sumOfTree(root);// O(N)
//    printf("%d\n", treeSum);
    
    int temp = treeSum;
    int half = treeSum / 2;
    for (auto e: v) {
      if (abs(half - e) < abs(half - temp)) {
        temp = e;
      }
    }// O(N)
//    printf("%d\n", temp);
    
    const int mod = 1000000007;
    long long num1 = temp % mod;
    long long num2 = (treeSum - temp) % mod;
    long long temp2 = num1 * num2;
    
    return answer = temp2 % mod;
  }// O(N)
  
  int sumOfTree(TreeNode* node) {
    if (node == NULL) return 0;
    int left = sumOfTree(node->left);
    int right = sumOfTree(node->right);
    int sum = left + right + node->val;
    v.push_back(sum);
    return sum;
  }
  
  int abs(int num) {
    if (num >= 0) return num;
    return -num;
  }
  
private:
  int answer = 0;
  vector<int> v;
  
};
