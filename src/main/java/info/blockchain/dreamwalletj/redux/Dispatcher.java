package info.blockchain.dreamwalletj.redux;

/**
 * Created by riaanvos on 26/02/2017.
 */
public interface Dispatcher<Action> {
    Action dispatch(Action action);
}

