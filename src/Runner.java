import java.util.Comparator;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Runner {
   public static void main(String[] args) {
      try(Scanner sc = new Scanner(new File("src/in.txt"))) {


         Purchase[] purchases;
         final int PURCHASES_NUMBER = sc.nextInt();
         purchases = new Purchase[PURCHASES_NUMBER];
         //инициализация массива из файла в цикле со счетчиком
	     for (int i = 0; i < PURCHASES_NUMBER; i++){
            purchases[i] = new Purchase();
            purchases[i].setAmount(sc.nextInt());
            purchases[i].setDiscount(sc.nextInt());
            purchases[i].setWeekDay(WeekDay.values()[sc.nextInt()]);
         }
         printPurchases(purchases);
         int totalCost = 0;		//инициализация финансовых величин
         int totalCostMonday = 0;
         int maxCost = 0;
         double meanCost = 0.0;	//среднее - это статистическая, а не финансовая величина!
         WeekDay maxCostDay = null;
         //обработка массива (пункт 4) в цикле for-each (без счетчика)
         for (Purchase purchase : purchases){
            totalCost += purchase.getCost();
            if (purchase.getWeekDay() == WeekDay.MONDAY) totalCostMonday += purchase.getCost();
            if (purchase.getCost() > maxCost) {
               maxCost = purchase.getCost();
               maxCostDay = purchase.getWeekDay();
            }
         }
         //после цикла
         if(purchases.length > 0) {
            meanCost = ((double) totalCost / 100) / purchases.length;
         }
         //вывод результатов пункта 4
         System.out.printf("Mean cost: %.3f %n", meanCost);
         System.out.println("Total cost of all purchases on Monday: " + Convert.convert(totalCostMonday));
         System.out.println("The day with maximum purchase cost: " + maxCostDay);
         System.out.println();
         Arrays.sort(purchases);
         System.out.println("Sorted array:");
         printPurchases(purchases);
         Purchase five = new Purchase(5, 5, 5);
         if (Arrays.binarySearch(purchases, five) >= 0){
            System.out.println("Purchase with amount 5: ");
            System.out.println(purchases[Arrays.binarySearch(purchases, five)]);
         }

      } catch (FileNotFoundException e) {
         System.err.println("Input file is not found");
      }

   }

   private static void printPurchases(Purchase[]purchases){
         System.out.println("Constants -  Name: " + Purchase.NAME + "; Price: " + Convert.convert(Purchase.PRICE));
         for (Purchase purchase : purchases) {
            System.out.println("Amount:" + purchase.getAmount() + "; Discount:" + purchase.getDiscount() + "; Week day:" + purchase.getWeekDay());
         }
         System.out.println();
   }
}
