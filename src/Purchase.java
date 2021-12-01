public class Purchase  implements Comparable<Purchase>{
    public final static String NAME = "Java book";
    public final static int PRICE = 4700;
    private int amount;
    private double discount;
    private WeekDay weekDay;

    public Purchase(){
    }

    public Purchase(int amount, double discount, WeekDay weekDay){
        this.amount = amount;
        this.discount = discount;
        this.weekDay = weekDay;
    }

    public Purchase(int amount, double discount, int day){
        this(amount, discount, WeekDay.values()[day]);
    }

    public int getAmount() {
        return amount;
    }

    public double getDiscount() {
        return discount;
    }

    public WeekDay getWeekDay(){
        return weekDay;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setWeekDay(WeekDay weekDay) {
        this.weekDay = weekDay;
    }

    public int getCost(){
        return Math.round(PRICE * amount * (100 - discount) / 100);
    }

   @Override
    public String toString(){
        return String.format("%s;%s;%d;%f;%s;%s;", NAME, Convert.convert(PRICE), amount, discount, weekDay, Convert.convert(getCost()));
    }

    @Override
    public int compareTo(Purchase purchase) {
        return amount - purchase.amount;
    }
}

