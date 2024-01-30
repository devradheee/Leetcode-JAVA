class MinStack {

    Stack<Integer> st;
    Stack<Integer> ms;

    public MinStack() {
        st=new Stack<Integer>();
        ms=new Stack<Integer>();
        
    }
    
    public void push(int val) {
        st.push(val);
        if(ms.empty() || val<=ms.peek()){
            ms.push(val);
        }
        
    }
    
    public void pop() {
        int a=st.pop();
        if(a==ms.peek()){
            ms.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
        
    }
    
    public int getMin() {
        if(ms.empty()){
        return 0;}
        else{
            return ms.peek();
        }
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */