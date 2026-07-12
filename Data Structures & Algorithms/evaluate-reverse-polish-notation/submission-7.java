class Solution {
    public int evalRPN(String[] tokens) {
        // 1 2 + 3 * 4 - 
        // ((1+2) *3) - 4 = 5
        // 1 2
        // 1+2
        //3 3

        Stack<Integer> items = new Stack<>();
        for (String c : tokens) {
            if (c.equals("+")) {
                items.push(items.pop()+items.pop());
            }
            else if (c.equals("-")) {
                int after = items.pop();
                int before = items.pop();
                items.push(before-after);
            }
            else if (c.equals("*")) {
                items.push(items.pop()*items.pop());
            }
            else if (c.equals("/")) {
                int after = items.pop();
                int before = items.pop();
                items.push(before/after);
            }else {
                items.push(Integer.parseInt(c));
            }
        }
        return items.pop();
        
    }
}
