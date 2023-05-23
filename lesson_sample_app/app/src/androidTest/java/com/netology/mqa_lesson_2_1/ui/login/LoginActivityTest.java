package com.netology.mqa_lesson_2_1.ui.login;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.netology.mqa_lesson_2_1.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LoginActivityTest {

    @Rule
    public ActivityScenarioRule<LoginActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    @Test
    public void loginActivityTest() {
        String email = "qwerty@net.ru";
        String password = "qwerty";

        ViewInteraction appCompatEditText = onView(withId(R.id.username))
                .check(matches(isDisplayed()))
                .perform(replaceText(email), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(withId(R.id.password))
                .check(matches(isDisplayed()))
                .perform(replaceText(password), closeSoftKeyboard());

        ViewInteraction materialButton = onView(withId(R.id.login))
                .check(matches(isDisplayed()))
                .perform(click());

        ViewInteraction textView = onView(withId(R.id.result))
                .check(matches(isDisplayed()))
                .check(matches(withText("Welcome !" + email)));
    }
}
