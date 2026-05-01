import java.time.LocalDateTime;

public class Order {
    private int id;
    private final OrderItem[] items;
    private final Customer customer;
    private final LocalDateTime createdAt;
    private Discount discount;
    private Order(int id,OrderItem[] items, Customer customer,Discount discount){
        this.id = id;
        OrderItem[] copy = new OrderItem[items.length];
        for(int i = 0;i < items.length;i++){
            copy[i] =items[i];
        }
        this.items = copy;
        this.customer=customer;
        this.discount=discount;
        this.createdAt= LocalDateTime.now();
    }
    public int getId(){
        return id;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Discount getDiscount(){
        return discount;
    }
    public void setDiscount(Discount discount){
        this.discount = discount;
    }
    public OrderItem[] getItems(){
        OrderItem[] copy = new OrderItem[items.length];
        for( int i = 0; i <items.length;i++){
            copy[i] = items[i];
        }
        return copy;
    }
    public int getLineCount(){
        return items.length;
    }
    public int getItemCount(){
        int count = 0;
        for (int i =0;i<items.length;i++){
            OrderItem[] item = items[i];
            count +=item.quantity();
        }
        return count;
    }
    public double calculateTotal(){
        double sum = 0;
        for(OrderItem item : items){
            sum+=item.totalPrice();
        }
        return sum;
    }
    public double calculateTotal(){
        double subtotal = calculateTotal();
        if(discount !=null){
            return discount.apply(subtotal());
        }
        return subtotal;
    }
    public String toString(){
        return String.format("Zamowienie %d (%s) %.2f zl (%d szt)",id,customer.name(),calculateTotal(),getItemCount());
    }
public Order build(){
        if(size == 0){
            throw new IllegalArgumentException("zamowienie musi zawierac co najmniej jedna pozycje");
        }
        OrderItem[] items2 = new OrderItem[size];
        for(int i=0;i<size;i++){
            items2[i]=items[i];
        }
        return new Order(id,items2,customer,discount);
}
}
