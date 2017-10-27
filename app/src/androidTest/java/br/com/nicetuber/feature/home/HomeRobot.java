package br.com.nicetuber.feature.home;

import android.view.KeyEvent;

import br.com.nicetuber.R;
import br.com.nicetuber.base.BaseRobot;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by thiagozg on 26/10/2017.
 */

public class HomeRobot extends BaseRobot {

    HomeRobot clickSearchView() {
        onView(withId(R.id.action_search)).perform(click());
        return this;
    }

    HomeRobot shouldHaveTyped(String channelToSearch) {
        onView(withId(android.support.design.R.id.search_src_text))
                .perform(typeText(channelToSearch), pressKey(KeyEvent.KEYCODE_ENTER))
                .check(matches(withText(channelToSearch)));
        return this;
    }

    HomeRobot verifyFirstChannelTitle(String firstChannelTitle) {
        doWait();
        onView(withRecyclerView(R.id.rv_channel_list).atPosition(0))
                .check(matches(hasDescendant(withText(firstChannelTitle))));
        return this;
    }
}
