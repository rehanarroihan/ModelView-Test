package com.multazamgsd.academy.ui.academy;

import androidx.test.rule.ActivityTestRule;

import com.multazamgsd.academy.R;
import com.multazamgsd.academy.testing.SingleFragmentActivity;
import com.multazamgsd.academy.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class AcademyFragmentTest {

    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private AcademyFragment academyFragment = new AcademyFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(academyFragment);
    }

    @After
    public void tearDown() {}

    @Test
    public void loadCourses() {
        onView(withId(R.id.rv_academy)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_academy)).check(new RecyclerViewItemCountAssertion(5));
    }
}