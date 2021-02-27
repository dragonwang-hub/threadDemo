package demo.thread.bank;

public class Account extends Thread {

    Bank bank;
    String name;
    OutMode mode;
    double amount;

    public Account(Bank bank, OutMode mode, double amount, String name) {
        this.bank = bank;
        this.mode = mode;
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void run() {
        while (Bank.totalMoney >= amount) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                bank.outMoney(amount, mode, name);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
