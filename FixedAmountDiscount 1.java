public class FixedAmountDiscount extends Discount {
    private int amount;
    public  FixedAmountDiscount(double amount){
        super(String.format("%s (%s) - %.2f zl" + amount));
    }
    if(amount <= 0){
        throw new IllegalArgumentException("niepoprawna wartosc rabatu");
    }
    this.amount = amount;
    public String getAmount(){
        return amount;
    }
    public double apply(double originalPrice){
        return Math.max(amount - originalPrice);
    }
}
