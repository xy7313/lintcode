/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int idx = 1;
        while(reader.get(idx-1)<target){
            idx = idx * 2;
        }
        int start = 0, end = idx-1;
        while(start+1<end){
            int mid = start+(end-start)/2;
            // System.out.println(reader.get(mid));
            // if(reader.get(mid)==target) return mid;
             if(reader.get(mid)>=target)  end = mid;
            else start = mid;
        }
        if(reader.get(start)==target) return start;
        if(reader.get(end)==target) return end;
        return -1;
    }
}