package br.com.nicetuber.feature.home;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by thiagozg on 26/10/2017.
 */

@RunWith(AndroidJUnit4.class)
public class HomeActivityTest {

    static final String CHANNEL_TO_SEARCH = "Nao Salvo";
    public static final String FIRST_CHANNEL_TITLE = "Cid Cidoso";


    @Rule
    public ActivityTestRule<HomeActivity> rule = new ActivityTestRule<>(HomeActivity.class);

    @Rule
    public HomeRobot robot = new HomeRobot();

    @Test
    public void testSearchViewText() throws Exception {
        robot.clickSearchView()
             .shouldHaveTyped(CHANNEL_TO_SEARCH);
    }

    @Test
    public void testFirstChannelTitle() throws Exception {
        robot.clickSearchView()
             .shouldHaveTyped(CHANNEL_TO_SEARCH)
             .verifyFirstChannelTitle(FIRST_CHANNEL_TITLE);
    }

}
