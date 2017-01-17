class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    /*
        1. KMP算法是解决这个算法很标准的方法，要问清楚数据量,小数据量没必要用KMP
        2. 问清楚要求的时间和空间复杂度
        3. 这个题经常在电面中出现
        4. 算法面试不要写注释，没注释，需要解释的东西都在代码中解释出来
        5. 注意顺序！
    */
    public int strStr(String source, String target){
        if(target=="") return 0;
        if(source==""||source==null||target==null) return -1;
        
        for(int s = 0; s<source.length(); s++){
            int tmp = s;
            int t = 0;
            while(source.charAt(tmp)==target.charAt(t)){
                if(t==target.length()-1) return s;
                tmp++;
                t++;
                if(tmp>source.length()-1) return -1;
            }
        }
        return -1;
    }
}