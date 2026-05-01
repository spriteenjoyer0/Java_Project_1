public static class Builder {
    private final int INITIAL_COPACITY = 4;
    private int id;
    private String customer;
    private OrderItem[] items;
    private int size;
    private Discount discount;
    public Builder(int id,Customer customer){
        if(id <=0){
            throw new IllegalArgumentException("ID zamówienia musi być większe od zera.");
        }
        if(customer == null){
            throw new IllegalArgumentException("Klient nie moze byc rowny null");
        }
        this.id=id;
        this.customer = customer;
        this.items = new OrderItem[INITIAL_COPACITY];
        this.size =0;
    }
    private void grow(){
        OrderItem[] items1 = new OrderItem[items.length*2];
        for(int i =0;i<size;i++){
            items1[i]=items[i];
        }
        items = items1;
    }
    public Builder addItem(Product product,int quantity){
        if(size == items.length){
            grow();
        }
        items[size++] = new OrderItem(product,quantity);
        return this;
    }
    public Builder addItem(Product product){
        return addItem(product,1);
    }
    public Builder withDiscount(Discount discount){
        this.discount = discount;
        return this;
    }

}
