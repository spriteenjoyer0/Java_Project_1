public class DailyReport {
    private final String reportDate;
    public DailyReport(String reportDate){
        if(reportDate ==null || reportDate.isBlank()){
            throw new IllegalArgumentException("Data raportu nie moze byc pusta");
        }
        this.reportDate=reportDate;
    }
    public String generate(){
        StringBuilder sb = new StringBuilder();
        String sep = "=".repeat(50);
        sb.append("Raport: ").append(name).append(("\n"));
        sb.append("Data: ").append(reportDate).append("\n");
        sb.append(sep).append("\n");
        sb.append("Liczba produktow d menu: ").append(menuSize).append("\n");
        sb.append("Zamowien: ").append(orderCount).append("\n");
        if(orderCount > 0){
            sb.append("---- Lista zamowien---- \n");
            for(int i=0;i<orderCount-1;i++){
                Order ord = orders[i];

                sb.append(String.format("%d %s %.2f zl %d \n",ord.getId(),ord.getCustomer().name(),ord.calculateTotal(),ord.getItemCount());
                sb.append("\n");
                Statistic stats = new Statistic(orders,ordersCount);
                sb.append(String.format("laczny: %.2f zl \n",stats.totalRevenue()));
                sb.append(String.format("Srednia wartosc: %.2f zl \n",stats.averageOrderValue()));
                else{
                    sb.append("Brak \n");
                }
                sb.append("\n").append(sep).append("\n");
                return sb.toString();
            }
        }
    }
}
