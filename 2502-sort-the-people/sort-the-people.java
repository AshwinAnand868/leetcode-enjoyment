class Solution {
    public String[] sortPeople(String[] names, int[] h) {
        int n = names.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(h[i] < h[j]) {
                    int temp = h[i];
                    h[i] = h[j];
                    h[j] = temp;
                    String temp2 = names[i];
                    names[i] = names[j];
                    names[j] = temp2;
                }
            }
        }

        return names;
    }
}