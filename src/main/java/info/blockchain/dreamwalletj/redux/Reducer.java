package info.blockchain.dreamwalletj.redux;

/**
 * Created by riaanvos on 26/02/2017.
 */
public interface Reducer<Action, State> {
    State apply(Action action, State state);
}

