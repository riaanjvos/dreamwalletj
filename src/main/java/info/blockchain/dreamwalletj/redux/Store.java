package info.blockchain.dreamwalletj.redux;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by riaanvos on 26/02/2017.
 */
public class Store<Action, State> implements StoreFace<Action, State> {

    private final AtomicBoolean isReducing = new AtomicBoolean(false);
    private final List<Middleware> middlewares = new ArrayList<>();

    private Reducer<Action, State> reducer;
    private State currentState;

    Store(Reducer<Action, State> reducer, State initialState) {
        this.currentState = initialState;
        this.reducer = reducer;
    }

    @Override
    public State getState() {
        return currentState;
    }

    @Override
    public void subscribe(final Middleware middleware) {
        middlewares.add(middleware);
    }

    @Override
    public void unsubscribe(Middleware middleWare) {
        middlewares.remove(middleWare);
    }

    @Override
    public Action dispatch(Action action) {
        assertIsNotReducing();

        currentState = reduce(action);
        notifySubscribers();
        return action;
    }

    private void notifySubscribers() {
        for (Middleware middleware : new ArrayList<>(middlewares)) {
            middleware.onStateChanged();
        }
    }

    private void assertIsNotReducing() {
        if (isReducing.get()) {
            throw new IllegalStateException("Already reducing");
        }
    }

    private State reduce(Action action) {
        startReducing();
        final State reducedSate = reducer.apply(action, currentState);
        stopReducing();
        return reducedSate;
    }


    private void stopReducing() {
        isReducing.set(false);
    }

    private void startReducing() {
        isReducing.set(true);
    }

    public static class Creator<Action, State> implements StoreFace.Creator<Action, State> {

        @Override
        public Store<Action, State> createStore(Reducer<Action, State> reducer, State initialState) {
            return new Store<>(reducer, initialState);
        }
    }
}