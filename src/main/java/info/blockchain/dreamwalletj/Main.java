package info.blockchain.dreamwalletj;

import info.blockchain.dreamwalletj.actions.WalletActions;
import info.blockchain.dreamwalletj.immutable.Wallet;
import info.blockchain.dreamwalletj.redux.Store;

/**
 * Created by riaanvos on 23/02/2017.
 */
public class Main {

    public static void main(String[] args) {

        Store.Creator<WalletActions, Wallet> stateContainer = new Store.Creator<>();
        new Sandbox(stateContainer).start();
    }
}
