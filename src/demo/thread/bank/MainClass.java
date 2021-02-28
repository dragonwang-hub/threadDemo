package demo.thread.bank;

public class MainClass {

    public static void main(String[] args) {
        Bank bank = new Bank();

        Account accountA = new Account(bank, OutModeEnum.ATM, 100, "A");
        Account accountB = new Account(bank, OutModeEnum.COUNTER, 200, "B");

        accountA.start();
        accountB.start();
    }
}
