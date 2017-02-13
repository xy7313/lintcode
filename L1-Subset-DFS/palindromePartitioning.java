public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s==null||s.length()==0) return results;
        
        List<String> partition = new ArrayList<String>();
        dfsHelper(s, 0, partition, results);
        
        return results;
    }
    private void dfsHelper(String s, int start, List<String> part, List<List<String>> results){
        //all substrings has been checked
        if(start==s.length()){
            results.add(new ArrayList<String>(part));
            return;
        }
        for(int i = start; i<s.length(); i++){
            String sub = s.substring(start,i+1);
            if(isPalindrome(sub)){
                part.add(sub);
                dfsHelper(s,i+1,part,results);
                part.remove(part.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s){
        for(int i = 0, j = s.length()-1; i<j; i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
}