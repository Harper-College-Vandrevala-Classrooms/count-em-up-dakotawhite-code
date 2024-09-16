package com.csc;
public class GroceryCounter {
    int count;
    int overflowcount;

    public GroceryCounter() {
        this.count = 0;
        this.overflowcount = 0;
    }

    public void tens() {
      count += 1000;
      checkoverflow();
  }

    public void ones() {
        count += 100;
        checkoverflow();
    }

    public void tenths() {
        count += 10;
        checkoverflow();
    }

    public void hundreths() {
        count += 1;
        checkoverflow();
    }

    void checkoverflow() {
        if (count > 9999) {
            count = count % 10000;
            overflowcount++;
        }
    }

    public String total() {
        int dollars = count / 100;
        int cents = count % 100;
        String formatdollars = String.format("%02d", dollars);
        String formatcents = String.format("%02d", cents);
        return "$" + formatdollars + "." + formatcents;
    }

    public int number_of_overflows() {
        return overflowcount;
    }

    public void clear() {
        this.count = 0;
        this.overflowcount = 0;
    }

    public static void main(String[] args) {
        GroceryCounter counter = new GroceryCounter();
        System.out.println("Welcome to the Grocery Counter. Count'em Up!\n" + counter.total());
        
        counter.tens();
        System.out.println(counter.total());
       
        for (int i = 0; i < 2; i++) {
          counter.ones();
          }
          System.out.println(counter.total());

        for (int i = 0; i < 3; i++) {
          counter.tenths();
          }
        System.out.println(counter.total());
        
        for (int i = 0; i < 4; i++) {
          counter.hundreths();
        }
        System.out.println(counter.total());
        System.out.println("Amount spent on groceries: " + counter.total());

        for (int i = 0; i < 10000; i++) {
            counter.hundreths();
        }
        System.out.println("Number of overflows: " + counter.number_of_overflows());
      
        counter.clear();
        System.out.println("\nReset Counter\n" + counter.total());
        System.out.println("Number of overflows: " + counter.number_of_overflows());
    
        for (int i = 0; i < 5; i++) {
          counter.ones();
          }
        for (int i = 0; i < 9; i++) {
              counter.hundreths();
              }
        System.out.println("\nAmount spent on groceries: " + counter.total());
        System.out.println("Number of overflows: " + counter.number_of_overflows());
      }
}
