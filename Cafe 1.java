import java.awt.color.ProfileDataException;

public class Cafe  {
    private final String name;
    private Product[] menu;
    private int menuSize;
    private Order[] orders;
    private int orderCount;
    public Cafe(String name, int menuCapacity, int orderCapacity){
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("nazwa kawiarni nie moze byc pusta");
        }
        if(menuCapacity <=0 || orderCapacity <=0){
            throw new IllegalArgumentException("pojemnosci muszą byc wieksze od 0");
        }
        this.name = name;
        this.menu = new Product[menuCapacity];
        this.menuSize = 0;
        this.orders=new Order[orderCapacity];
        this.orderCount = 0;
    }
    public void addProduct(Product product){
        if(product == null){
            throw new IllegalArgumentException("Product nie moze byc null");
        }
        if(menuSize == menu.length){
            Product[] items1= new Product[menu.length*2];
            for(int i =0;i<menu.length;i++){
                items1[i] = menu[i];
            }
            menu = items1;
        }
        menu[menuSize++] = product;
    }
    public boolean removeProduct(String productName){
        int index = -1;
        for(int i =0;i<menuSize;i++){
            if(menu[i].name().equalsIgnoreCase(productName)){
                index =i;
                break;;
            }
        }
        if(index == -1){
            return false;
        }
        for(int i =index;i<menuSize-1;i++){
            menu[i]= menu[i+1];
        }
        menu[--menuSize]= null;
        return true;
    }
    public Product[] getProductByCategory(String category){
        int count = 0;
        for(int i=0;i<menuSize;i++){
            if(menu[i].category().equalsIgnoreCase(category)){
                count++;
            }
        }
        Product[] result = new Product[count];
        int idx =0;
        for(int i =0;i<menuSize;i++){
            if(menu[i].category().equalsIgnoreCase(category)){
                result[idx++]=menu[i];
            }
        }
        return result;
    }
    public void sortMenuByPrice(){
        for(int i =1;i <menuSize;i++){
            Product key =menu[i];
            int j = i-1;
            if(j >=0 && menu[j].price()> key.price()){
                menu[j+1]= menu[j];
                j--;
            }
            menu[j+1] = key;
        }
        public void displayMenu() {
            System.out.println("MENU " + name.toUpperCase() + "\n");
            for (int i = 0; i < menuSize; i++) {
                System.out.println((i + 1) + " " + menu[i].formatted());
            }
            System.out.println();
        }

        public void addOrder(Order order) {
            if (order == null) {
                throw new IllegalArgumentException("Zamowienie nie moze byc null");
            }
            if (orderCount == orders.length) {
                Order[] now = new Order[orders.length * 2];
                for (int i = 0; i < orders.length; i++) {
                    now[i] = orders[i];
                }
                orders = now;
            }
            orders[orderCount++] = order;
        }

        public Order[] getOrdersByCustomer(String customerName) {
            int count = 0;
            for (int i = 0; i < orderCount; i++) {
                if (orders[i].getCustomer().name().equalsIgnoreCase(customerName)) {
                    count++;
                }
            }

            Order[] result = new Order[count];
            int ind = 0;
            for (int i = 0; i < orderCount; i++) {
                if (orders[i].getCustomer().name().equalsIgnoreCase(customerName)) {
                    result[ind++] = orders[i];
                }
            }
            return result;
        }

        public void sortOrdersByTotal() {
            for (int i = 0; i < orderCount - 1; i++) {
                for (int j = 0; j < orderCount - i - 1; j++) {
                    if (orders[j].calculateTotal() > orders[j + 1].calculateTotal()) {
                        Order kosz = orders[j];
                        orders[j] = orders[j + 1];
                        orders[j + 1] = kosz;
                    }
                }
            }
        }
public String getName(){
            return name;
    }
        public int getMenuSize(){
            return menuSize;
            }
        public int getOrderCount(){
            return orderCount;
        }
        public Order[] getOrders(){
            Order[] kopia = new Order[orderCount];
            for(int i =0;i<orderCount;i++){
                kopia[i]= orders[i];
            }
            return kopia;
        }
    }
}
