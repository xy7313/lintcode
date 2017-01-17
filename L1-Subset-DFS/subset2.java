public class Solution {
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) return results;
        Arrays.sort(nums);
        ArrayList<Integer> subset = new ArrayList<>();
        dfsHelper(0,nums,subset,results);
        return results;
    }
    private void dfsHelper(int start, int[] nums, ArrayList<Integer> subset, List<List<Integer>> results){
        results.add(new ArrayList(subset));
        for(int i = start; i<nums.length; i++){
            if(i>start&&nums[i]==nums[i-1]) continue;
            subset.add(nums[i]);
            dfsHelper(i+1,nums,subset,results);
            subset.remove(subset.size()-1);
        }  
    }
}