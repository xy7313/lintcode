public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
class Element {
    public String str;
    public int num;
    public Element(String str) {
        this.str = str;
    }
    public Element(int num) {
        this.num = num;
    }
}
    public String expressionExpand(String s) {
        Stack<Element> stack = new Stack<>();
        int number = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '[') {
                stack.push(new Element(number));
                number = 0;
            } else if (c == ']') {
                String newStr = popStack(stack);
                Element elem = stack.pop();
                for (int i = 0; i < elem.num; i++) {
                    stack.push(new Element(newStr));
                }
            } else {
                stack.push(new Element(String.valueOf(c)));
            }
        }
        
        return popStack(stack);
    }
    
    // pop stack until get a number or empty
    private String popStack(Stack<Element> stack) {
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && stack.peek().str != null) {
            buffer.push(stack.pop().str);
        }
        
        StringBuilder sb = new StringBuilder();
        while (!buffer.isEmpty()) {
            sb.append(buffer.pop());
        }
        return sb.toString();
    }
    //也可以这么实现，看起来代码简洁了，但是时间复杂度和空间复杂度更高
    // private String popStack(Stack<Element> stack) {
    //     String re = "";
    //     while (!stack.isEmpty() && stack.peek().str != null) {
    //         re = stack.pop().str+re;
    //     }
    //     return re;
    // }
}
