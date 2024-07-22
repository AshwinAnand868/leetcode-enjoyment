class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> map = new HashMap<>();
        
        for(int i = 0; i < names.length; i++) {
            map.put(heights[i], names[i]);
        }
        
        // sort the heights array using quick sort

        quickSort(heights, 0, heights.length - 1);
        
        // debug statement
        // System.out.println(Arrays.toString(heights));
        
        // now the heights array is sorted in desceding order
        // so let's use the map to update the names array
        
        for(int i = 0; i < map.size(); i++) {
            names[i] = map.get(heights[i]);
        }
        
        // debug statement
        System.out.println(Arrays.toString(names));
        
        return names;
    }
    
    
    public void quickSort(int[] heights, int begin, int end) {
        // only execute if begin is less than end
        if(begin < end) {
            int pivotPos = partition(heights, begin, end);
            
            // sort the elements around the pivot recursively
            quickSort(heights, begin, pivotPos - 1);
            quickSort(heights, pivotPos + 1, end);
        }
    }
    
    public int partition(int[] heights, int begin, int end) {
        int pivot = heights[end]; // take pivot as the end of the array
        int i = begin - 1; // initial value of i will be one less than the start idx
        
        for(int j = begin; j < end; j++) {
            
            // if current element is less than or equal to pivot then
            // swap the element at i and j indices
            if(heights[j] >= pivot) {
                i++; 
                
                int swap = heights[i];
                heights[i] = heights[j];
                heights[j] = swap;                
            }
        }
        
        // swap the ith + 1 element with the pivot
        int swap = heights[i + 1];
        heights[i + 1] = heights[end];
        heights[end] = swap;
        
        return i + 1; // final pivot index or position        
    }
}