package com.example.NewsApp;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.NewsApp.ui.Activities.BreakingNewsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;


/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BreakingNewsActivityTest {

    @Rule
    public ActivityScenarioRule<BreakingNewsActivity> activityRule = new ActivityScenarioRule<>(BreakingNewsActivity.class);

    @Test
    public void clickExpandFloatingButton_FloatingButtonsAreNotDisplayed() {
        onView(withId(R.id.see_description_button)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycle_view_button)).check(matches(not(isDisplayed())));
    }

    @Test
    public void clickExpandFloatingButton_FloatingButtonsAreDisplayed() {
        onView(withId(R.id.expand_button)).perform(click());
        onView(withId(R.id.see_description_button)).check(matches(isDisplayed()));
        onView(withId(R.id.recycle_view_button)).check(matches(isDisplayed()));
    }





}