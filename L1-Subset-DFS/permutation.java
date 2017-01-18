public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) return results;
        List<Integer> subset = new ArrayList<>();
        helper(nums,subset,results);
        return results;
    }
    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> results ){
            for(int i = 0; i< nums.length; i++){
                if(subset.contains(nums[i])) continue;
                subset.add(nums[i]);
                helper(nums,subset,results);
                if(subset.size()==nums.length){
                    results.add(new ArrayList<Integer>(subset));
                }
                subset.remove(subset.size() - 1);
            }
    }
}
//按照subset的格式写的话是这样的
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if(nums==null||nums.length==0) return results;
        List<Integer> subset = new ArrayList<>();
        helper(nums,subset,results);
        return results;
    }
    private void helper(int[] nums, List<Integer> subset, List<List<Integer>> results ){
        if(subset.size()==nums.length){
            results.add(new ArrayList<Integer>(subset));
        }else{
            for(int i = 0; i< nums.length; i++){
                if(subset.contains(nums[i])) continue;
                subset.add(nums[i]);
                helper(nums,subset,results);
                subset.remove(subset.size() - 1);
            }
        }
    }
}