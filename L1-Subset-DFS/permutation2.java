
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
    
        if (nums == null) {
            return results;
        }
         //注意这里 input: [] expected output: [[]]所以下面这里要跟nums==null的情况区别开
        if(nums.length == 0) {
            results.add(new ArrayList<Integer>());
            return results;
        }        
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        ArrayList<Integer> subset = new ArrayList<>();
        dfsHelper(nums,used,subset,results);
        return results;
    }
    private void dfsHelper( int[] nums, boolean[] used, ArrayList<Integer> subset, List<List<Integer>> results){
        if(subset.size()==nums.length){
            results.add(new ArrayList<Integer>(subset));
        }else{
            for(int i = 0; i<nums.length; i++){
                //该数用过了，continue
                if(used[i]) continue;
            /*
            下面的判断主要是为了去除重复元素影响。
            比如，给出一个排好序的数组，[1,2,2]，那么第一个2和第二2如果在结果中互换位置，我们也认为是同一种方案，所以我们强制要求相同的数字，原来排在前面的，在结果当中也应该排在前面，这样就保证了唯一性。所以当前面的2还没有使用的时候，就不应该让后面的2使用。
            */
                if(i>0 &&nums[i-1]==nums[i] && !used[i-1]) continue;
                used[i] = true;
                subset.add(nums[i]);
                dfsHelper(nums,used,subset,results);
                used[i] = false;
                subset.remove(subset.size()-1);
            }  
        }
    }
}