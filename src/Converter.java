public class Converter {
    public static String convert(int price){
        return price / 100 + "." + price / 10 % 10 + price % 10;
    }
}
