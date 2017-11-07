package br.com.nicetuber.base;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import br.com.nicetuber.helper.RecyclerViewMatcher;

/**
 * Created by thiagozg on 26/10/2017.
 */

public class BaseRobot implements TestRule {

    public static final int ONE_SECOND = 1000;

    protected void doWait() {
        try {
            Thread.sleep(ONE_SECOND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    @Override
    public Statement apply(Statement base, Description description) {
        return base;
    }

}
