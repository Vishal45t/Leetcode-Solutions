class StockSpanner {

    Stack<Integer> st;
    List<Integer> prices;

    public StockSpanner() {
        st = new Stack<>();
        prices = new ArrayList<>();
    }

    public int next(int price) {

        prices.add(price);
        int i = prices.size() - 1;

        while(!st.empty() && prices.get(st.peek()) <= price){
            st.pop();
        }

        int span;

        if(st.empty()){
            span = i + 1;
        }else{
            span = i - st.peek();
        }

        st.push(i);

        return span;
    }
}