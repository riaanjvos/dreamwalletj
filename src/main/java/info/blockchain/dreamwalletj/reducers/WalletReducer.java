package info.blockchain.dreamwalletj.reducers;

import info.blockchain.dreamwalletj.actions.WalletActions;
import info.blockchain.dreamwalletj.immutable.Account;
import info.blockchain.dreamwalletj.immutable.Wallet;
import info.blockchain.dreamwalletj.redux.Reducer;

/**
 * Created by riaanvos on 26/02/2017.
 */
public class WalletReducer implements Reducer<WalletActions, Wallet>{

    @Override
    public Wallet apply(WalletActions walletActions, Wallet state) {
        switch (walletActions.type) {
            case ADD_ACCOUNT:
                return state.addAccount((Account) walletActions.payload);
            default:
                throw new IllegalArgumentException("Invalid Action Type: " + walletActions.type);
        }
    }
}
