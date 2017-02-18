public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
      // O(N*L) N:dict.length, L: average lengtho of words
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }
        //add start, end to dict
        dict.add(start);
        dict.add(end);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.offer(start);
        hash.add(start);
        
        int len = 1;
        while(!queue.isEmpty()){
            //each level, len++
            len++;
            int size = queue.size();
            for(int i = 0; i<size; i++){
                String cur = queue.poll();
                for(String next : validNext(dict,cur)){
                    //equals, not ==
                    if(next.equals(end)) return len;
                    if(!hash.contains(next)){
                        hash.add(next);
                        queue.offer(next);
                    }
                }
            }
        }
        return 0;
        
    }
    private ArrayList<String> validNext(Set<String> dict, String cur){
        ArrayList<String> nexts = new ArrayList<String>();
        for(char c = 'a'; c<='z'; c++){
            for(int l = 0; l<cur.length(); l++){
                String n = replaceByIdx(cur, l, c);
                if(dict.contains(n)){
                    nexts.add(n);
                }
            }
        }
        return nexts;
    }
    private String replaceByIdx(String cur, int idx, char c ){
        char[] toChar = cur.toCharArray();
        toChar[idx] = c;
        return String.valueOf(toChar);
    }
}