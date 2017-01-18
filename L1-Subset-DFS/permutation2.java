public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
    List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) return results;
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
                if(used[i]) continue;
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