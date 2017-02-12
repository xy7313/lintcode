public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }
        //结果里每种combination都只能出现一次，又每个数字使用次数不限，所以需要去重
        int[] nums = removeDuplicates(candidates);
        
        dfs(nums, 0, new ArrayList<Integer>(), target, results);
        
        return results;
    }
    private int[] removeDuplicates(int[] candidates){
        Arrays.sort(candidates);
        int idx=1;
        for(int i=1; i<candidates.length; i++){
            if(candidates[i]!=candidates[i-1]){
                candidates[idx]=candidates[i];
                idx++;
            }
        }
        int[] nums = new int[idx];
        for (int i = 0; i < idx; i++) {
            nums[i] = candidates[i];
        }
        return nums;
    }
    private void dfs(int[] candidates,
                     int startIndex,
                     List<Integer> combination,
                     int remainTarget,
                     List<List<Integer>> results){
        if(remainTarget==0){
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        for(int i = startIndex; i<candidates.length; i++){
            //注意这个判断很容易忘
            if (remainTarget < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates,i,combination,remainTarget-candidates[i],results);
            combination.remove(combination.size() - 1);
        }
    }
}
//需要去重，因为每个数不限出现此数，但不希望结果里有重复的combination，所以取宠后开始任意组合，因为每个数不限出现次数，所以for循环中每次dfs都传i进去，而不再是i+1