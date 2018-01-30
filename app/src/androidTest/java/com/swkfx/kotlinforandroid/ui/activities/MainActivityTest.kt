package com.swkfx.kotlinforandroid.ui.activities

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.swkfx.kotlinforandroid.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.Test

/**
 * <pre>
 * author : test
 * e-mail : fangx@hyxt.com
 * time   : 2018/1/30
 * desc   :
</pre> *
 */
class MainActivityTest {
    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)

    //@Test
    fun testItemClick() {
        onView(withId(R.id.girlList)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.tvDesc)).check(
                matches(isAssignableFrom(TextView::class.java))
        )
    }

    @Test
    fun testTitle() {
        //打开菜单 这个方法打不开菜单.目测是因为没有设置activity的菜单.而是自定义toolbar的原因.
        openActionBarOverflowOrOptionsMenu(activity.activity)
        //点击设置
        onView(withText(R.string.settings)).perform(click())
       //check title
        onView(isAssignableFrom(Toolbar::class.java)).check(
                matches(withToolbarTitle(`is`("设置")))
        )
    }

    private fun withToolbarTitle(matcher: Matcher<String>?): Matcher<Any> =
            object : BoundedMatcher<Any, Toolbar>(Toolbar::class.java) {
                override fun matchesSafely(item: Toolbar): Boolean {
                    matcher?.matches(item.title)
                    return false
                }

                override fun describeTo(description: Description?) {
                    description?.appendText("toolbar title text :")
                    matcher?.describeTo(description)
                }
            }
}