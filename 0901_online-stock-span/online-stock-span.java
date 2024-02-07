// package 0901_online-stock-span;

class StockSpanner {
    static class Pair {
        int x;
        int span;

        Pair(int x, int span) {
            this.x = x;
            this.span = span;
        }
    }

    private Stack<Pair> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().x <= price) {
            Pair p = stack.pop();
            span = span + p.span;
        }
        stack.push(new Pair(price, span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */