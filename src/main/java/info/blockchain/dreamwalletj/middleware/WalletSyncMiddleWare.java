package info.blockchain.dreamwalletj.middleware;

import info.blockchain.dreamwalletj.actions.WalletActions;
import info.blockchain.dreamwalletj.immutable.Wallet;
import info.blockchain.dreamwalletj.redux.Store;
import info.blockchain.dreamwalletj.redux.Middleware;

/**
 * Created by riaanvos on 23/02/2017.
 */
public class WalletSyncMiddleWare implements Middleware {
    private final Store<WalletActions, Wallet> store;

    public WalletSyncMiddleWare(Store<WalletActions, Wallet> store) {
        this.store = store;
    }

    @Override
    public void onStateChanged() {
        System.out.println("State change - "+store.getState().accounts.toString());
        System.out.println("Saving wallet...\n");
    }
}