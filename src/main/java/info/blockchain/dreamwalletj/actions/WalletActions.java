package info.blockchain.dreamwalletj.actions;

/**
 * Created by riaanvos on 26/02/2017.
 */
public class WalletActions {

    public enum Action {
        ADD_ACCOUNT
    }

    public Action type;
    public Object payload;

    public WalletActions(Action type, Object payload) {
        this.type = type;
        this.payload = payload;
    }

    public static WalletActions of(Action type, Object payload) {
        return new WalletActions(type, payload);
    }
}
