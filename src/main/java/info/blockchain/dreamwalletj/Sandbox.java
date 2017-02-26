package info.blockchain.dreamwalletj;

import info.blockchain.dreamwalletj.actions.WalletActions;
import info.blockchain.dreamwalletj.actions.WalletActions.Action;
import info.blockchain.dreamwalletj.immutable.Account;
import info.blockchain.dreamwalletj.immutable.Wallet;
import info.blockchain.dreamwalletj.middleware.WalletSyncMiddleWare;

import info.blockchain.dreamwalletj.reducers.WalletReducer;
import info.blockchain.dreamwalletj.redux.Store;

/**
 * Created by riaanvos on 23/02/2017.
 */
class Sandbox {

    private final Store<WalletActions, Wallet> store;

    public Sandbox(Store.Creator<WalletActions, Wallet> stateContainer) {

        //Clean wallet
        Wallet initialState = new Wallet();
        store = stateContainer.createStore(new WalletReducer(), initialState);
    }

    public void start() {
        store.subscribe(new WalletSyncMiddleWare(store));

        //Initial state empty
        System.out.println(store.getState().toString());

        //Add accounts
        store.dispatch(WalletActions.of(Action.ADD_ACCOUNT, new Account("Account 1")));
        store.dispatch(WalletActions.of(Action.ADD_ACCOUNT, new Account("Account 2")));

    }
}