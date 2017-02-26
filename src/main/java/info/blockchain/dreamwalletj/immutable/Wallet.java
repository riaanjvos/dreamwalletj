package info.blockchain.dreamwalletj.immutable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by riaanvos on 23/02/2017.
 */
public class Wallet {

    public final List<Account> accounts;

    public Wallet() {
        this(new ArrayList<Account>());
    }

    public Wallet(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Wallet addAccount(Account account) {
        final List<Account> accounts = copyAccounts();
        accounts.add(account);
        return new Wallet(accounts);
    }

    private List<Account> copyAccounts() {
        return new ArrayList<>(this.accounts);
    }

    @Override public String toString() {
        return "Wallet(accounts=" + accounts + ")";
    }
}
