package thread.sync.lock;

public interface BankAccount {
    boolean withdraw(int amount);

    int getBalance();
}
