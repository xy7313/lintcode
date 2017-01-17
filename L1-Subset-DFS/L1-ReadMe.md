subset-DFS+Backtracking系列，有模板方法可以记
##例1：[ Subset](http://www.lintcode.com/en/problem/subsets/)
####1. 题目分析
  1. 首先 ，这个题是NP问题，没有多项式时间内的算法，只能用搜索解决的问题
  2. 选择用DFS-backtracking 的递归方式解决
  3. 画递归树图
  2. 搜索问题中处理去重：选代表，因为我们的递归helper是在index向后排的时候调用，（因为树没有重复，我们枚举元素都是按照顺序的，所以不会有答案出现重复）

####2. 代码实现思路
  3. 先排除边界情况：判断输入的array nums 是不是有效的，这里做判断：
if nums==null||nums.length==0{return results};(results是刚初始化的返回值)
  5. 写递归：
    1. 递归定义：以subset开头的所有自己放在result里（从nums里的startindex开始挑数）
    2. 递归的拆解
    2. 递归的出口、什么时候记录答案：if(){return;},这里不需要出口，要一直做到没有就退出

####3. 时间复杂度分析
通用时间复杂度：O(解的个数 \* 每个解产生的复杂度)，数学推导有兴趣的话 可以看这个帖子，http://www.jiuzhang.com/qa/1601/
subset
=O(2^n * n) 构造每个答案的时间是1，2，。。。n平均就是n/2，就是n
permutation
=O(n*n!) n!个答案
n queens 不知道有几个答案
=O(n*s) s 是答案的个数
####4. code

```
class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) { 
        if(nums==null||nums.length==0) return null;
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        //把空集开头的所有集合放入result
        dfsHelper(nums,0,new ArrayList<Integer>(), results);
        return results;
    }

    private void dfsHelper(int[] nums, 
                            int startIndex, 
                            ArrayList<Integer> subset, 
                            ArrayList<ArrayList<Integer>> results){
        //deep copy,否则后面操作subset，subset的内容就改变了
        results.add(new ArrayList<Integer>(subset));
        for(int i = startIndex; i<nums.length;i++){
            subset.add(nums[i]);
            dfsHelper(nums,i+1,subset,results);
            subset.remove(subset.size()-1);
        }   
    }
}
```

####5. 一些细节
  1. 库函数 Arrays.sort()是用的quick sort实现，可以认为是nlogn的复杂度
  2. 代码中写的deep copy，java默认都是pass by reference ，这里不new的话传递的是指向subset的reference，后面subset改变，results中加入的subset也会改变，最后返回就变成了[[],[],[],[]......]
  3. 这里不可以用results.addAll(xxx) ，因为addAll 表示，把xxx中的元素都加入到results中，我们是需要加入list，而不是list中的元素
  4. 为什么result.add 在for循环前面？
因为答案不仅仅只存在于搜索树的叶子节点，每一个节点都是一个答案，所以进入这个搜索节点 就要add一下
  5. 要记得递归完成后subset.remove(subset.size() - 1)，这就是BackTracking，把刚才加进去的那一个清除掉 ，回到上一步，再继续向后进行，刚才添加进去的那个就是idx=subset.size() - 1，因为我们是往list添加元素，那么当前元素就是添加在list后面，我们回溯是一层一层上来，就是从后一层一层把元素remove掉，当前就remove目前的最后的元素
  6. DFS有两种实现方式，一种是递归，一种是非递归，递归只算作是一种实现的方式

##例2 [Leetcode 90. Subsets II](https://leetcode.com/problems/subsets-ii/)
[solution-github](https://github.com/xy7313/leetEM/blob/master/90subset2.java)

####1. 题目分析
跟上题不一样的是 input数组中有重复元素

####2. 代码实现思路
跟上题一样，除了：
如何去重，比如输入[1,2,2] list长=1的只有两个了[1]，[2]。
1. 这里需要通过排序把相等的数凑在一起
2. 再在helper中，for loop中，if的那句话，确保每次循环起始的数字不能和之前重复，避免再用重复元素，即避免插入[1,2,2]插入第二个[2]的情况,

####3. 时间复杂度分析
O(n^2)

####4. code
```
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
```

####5. 一些细节
subset2 需要注意。。
continu用法？这个太初级了吧，最需要注意的就是 for循环递归调用前的if判断

permutation

所有的recursion问题你都可以想象成一棵树。subset上面每一个树的节点都是结果。而permutation上面只有叶子节点才是结果