public record Customer(String name, String email,int loyalitypoints ){
    public Customer{
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("imie klienta nie moze byc puste");
        }
        if(email == null||email.contains("@")){
            throw new IllegalArgumentException("email jest niepoprawny lub pusty");
        }
        if(loyalitypoints < 0){
            throw new IllegalArgumentException("liczba punktow nie moze byc ujemna");
        }
    }
    public String loyalityLevel(){
        if(loyalitypoints >= 200){
            return "ZLOTY";
        }
        if(loyalitypoints >=100){
            return "SREBRNY";
        }
        if(loyalitypoints >= 50){
            return "BRANZOWY";
        }
        return "STANDART";
    }
    public String formatted(){
        return String.format(("%s, %d pkt, %s"), name,email,loyalitypoints,loyalityLevel());
    }

}
