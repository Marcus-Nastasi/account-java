package entities;

import java.util.Locale;
import java.util.Scanner;

public class Account {

    private int id;
    private String name;
    private double cash = 0;

    public Account() {
    }

    private int getId() {

        return id;
    }

    private void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String n) {

        this.name = n;
    }

    public double getCash() {

        return cash;
    }

    public void put(double v) {

        this.cash += v;
    }

    public void saq(double v) {

        this.cash -= (v + 5);
    }

    public void acData() {
        System.out.printf("%nAccount data: %nAccount: %d, Holder: %s, Balance: $%.2f%n%n", getId(), getName(), getCash());
    }

    public void updAcData() {
        System.out.printf("%nUpdated account data: %nAccount: %d, Holder: %s, Balance: $%.2f%n%n", getId(), getName(), getCash());
    }

    public void run() {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter account number: ");
        this.setId(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter account holder: ");
        this.setName(sc.nextLine());

        System.out.print("Is there an initial deposit?(y/n) ");
        String r = sc.next();
        if(r.equals("y")) {
            System.out.print("Enter an initial deposit value: ");
            this.put(sc.nextDouble());
            this.acData();
        } else { this.acData(); }

        System.out.print("Enter a deposit value: ");
        this.put(sc.nextDouble());

        this.updAcData();

        System.out.print("Enter a withdraw value: ");
        this.saq(sc.nextDouble());

        this.updAcData();

        sc.close();
    }
}
