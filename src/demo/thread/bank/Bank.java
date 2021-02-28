package demo.thread.bank;

public class Bank {

    static double totalMoney = 1000;

    public synchronized void outMoney(double money, OutModeEnum mode, String name) throws Exception {
        if (money > totalMoney) {
            throw new Exception("银行账户金额不足" + money + ". 取款失败！当前余额为：" + totalMoney);
        }
        WithdrawMoney(money, mode, name);
    }

    private void WithdrawMoney(double money, OutModeEnum mode, String name) {
        totalMoney -= money;
        System.out.println("用户" + name + "从" + mode.toString() + "取出金额：" + money + ". 当前余额为：" + totalMoney);
    }

}
