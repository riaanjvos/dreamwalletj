package info.blockchain.dreamwalletj.immutable;

/**
 * Created by riaanvos on 26/02/2017.
 */
public class Account {
    public String label;

    public Account(String label) {
        this.label = label;
    }

    @Override public String toString() {
        return "Account(" + label +")";
    }
}
