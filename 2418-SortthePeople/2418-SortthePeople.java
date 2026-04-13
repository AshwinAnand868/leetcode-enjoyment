// Last updated: 4/13/2026, 7:22:34 PM
1class Solution {
2    public String[] sortPeople(String[] names, int[] h) {
3        int n = names.length;
4
5        for(int i=0; i<n; i++) {
6            for(int j=i+1; j<n; j++) {
7                if(h[i] < h[j]) {
8                    int temp = h[i];
9                    h[i] = h[j];
10                    h[j] = temp;
11                    String temp2 = names[i];
12                    names[i] = names[j];
13                    names[j] = temp2;
14                }
15            }
16        }
17
18        return names;
19    }
20}