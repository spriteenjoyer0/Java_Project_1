public record OrderItem(Product product, int quaintity) {
    if(product == null){
        throw new IllegalArgumentException("product nie moze byc pusty");
    }
    if(quantity < 1){
        throw new IllegalArgumentException("Ilosc musi wynosic najmniej 1. Otrzymano: " + quaintity);

    }
    public double totalPrice(){
        return product.price()* quaintity;
    }
    public String formatted(){
        String lewa = String.format("%dx %s",quaintity,product.name());
        String prawa = String.format("%.2f zl", totalPrice());
        int width = 40;
        int spacja = width - lewa.length() - prawa.length();
        return lewa +" ".repeat(spacja)+prawa;
        }
    }
}
