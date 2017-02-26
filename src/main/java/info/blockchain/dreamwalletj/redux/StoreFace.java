package info.blockchain.dreamwalletj.redux;

/**
 * Created by riaanvos on 26/02/2017.
 */
public interface StoreFace<Action, State> extends Dispatcher<Action> {

    State getState();

    void subscribe(Middleware middleware);
    void unsubscribe(Middleware middleware);

    interface Creator<Action, State> {
        Store<Action, State> createStore(Reducer<Action, State> reducer, State initialState);
    }
}
