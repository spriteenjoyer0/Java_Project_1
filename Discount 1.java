public abstract class Discount {
    private final String description;
    public Discount(String description){
        if(description == null || description.isBlank()){
            throw new IllegalArgumentException("opis rabatu nie moze byc pusty");
        }
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
    public abstract double apply(double originalPrice);
    public double savings(double originalPrice){
        double discounted = apply(originalPrice);
        return originalPrice - discounted;

    }
    public String toString(){
        return "Rabat: " + description;
    }


}
