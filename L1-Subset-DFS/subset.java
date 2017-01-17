class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        //NP问题，没有多项式时间内的算法，只能用搜索解决的问题
        //搜索问题中处理去重：选代表
        if(nums==null||nums.length==0) return null;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        //把空集开头的所有集合放入result
        dfsHelper(nums,0,new ArrayList<Integer>(), results);
        return results;
    }
    /*
    写递归：1. 递归的定义：把所有以subset开头的所有集合放到result中
            2. 递归的拆解
            3. 递归的出口
    */
    private void dfsHelper(int[] nums, 
                            int startIndex, 
                            ArrayList<Integer> subset, 
                            ArrayList<ArrayList<Integer>> results){
        //deep copy,否则后面操作subset，subset的内容就改变了，我们add的就不是空了
        results.add(new ArrayList<Integer>(subset));
        for(int i = startIndex; i<nums.length;i++){
            subset.add(nums[i]);
            dfsHelper(nums,i+1,subset,results);
            subset.remove(subset.size()-1);
        }
    }
}