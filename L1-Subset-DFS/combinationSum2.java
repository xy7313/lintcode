public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
         List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        
        // int[] can = removeDuplicates(num);因为每个数字只能出现一次，所以不用去重，也不能去重，因为要所有combination
        Arrays.sort(num);
        dfs(num, 0, new ArrayList<Integer>(), target, results);
        
        return results;
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
            //保证在用这个数之前，有和他相等的数并且
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (remainTarget < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates,i+1,combination,remainTarget-candidates[i],results);
            combination.remove(combination.size() - 1);
        }
    }
}

//比如输入是[7,1,2,5,1,6,10], 8，排序后是[1,1,2,5,6,7,10],第一次dfs，combination先添加1，然后继续找，等所有情况找完之后（此时已递归好多次），从下一个元素开始，发现又是1，因为刚才已经把包含1的组合都找过了（因为每个数只能用1次，所以可以和1组成combination的都用过了，所以第二个1没有数可以用了），所以这次不再找，continue