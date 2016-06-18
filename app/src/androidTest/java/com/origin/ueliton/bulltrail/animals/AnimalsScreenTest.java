package com.origin.ueliton.bulltrail.animals;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;
import android.text.TextUtils;
import android.view.View;

import com.origin.ueliton.bulltrail.Animals.AnimalsActivity;
import com.origin.ueliton.bulltrail.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.google.common.base.Preconditions.checkArgument;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;

/**
 * Created by ueliton on 5/31/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class AnimalsScreenTest {

    /**
     * {@link ActivityTestRule} is a JUnit {@link Rule @Rule} to launch your activity under test.
     * <p/>
     * <p/>
     * Rules are interceptors which are executed for each test method and are important building
     * blocks of Junit tests.
     */
    @Rule
    public ActivityTestRule<AnimalsActivity> mAnimalsActivityTestRule =
            new ActivityTestRule<>(AnimalsActivity.class);

    /**
     * A custom {@link Matcher} which matches an item in a {@link RecyclerView} by its text.
     * <p/>
     * <p/>
     * View constraints:
     * <ul>
     * <li>View must be a child of a {@link RecyclerView}
     * <ul>
     *
     * @param itemText the text to match
     * @return Matcher that matches text in the given view
     */
    private Matcher<View> withItemText(final String itemText) {
        checkArgument(!TextUtils.isEmpty(itemText), "itemText cannot be null or empty");
        return new TypeSafeMatcher<View>() {
            @Override
            public boolean matchesSafely(View item) {
                return allOf(
                        isDescendantOfA(isAssignableFrom(RecyclerView.class)),
                        withText(itemText)).matches(item);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("is isDescendantOfA RV with text " + itemText);
            }
        };
    }

    @Test
    public void clickAddAnimalButton_opensAnimalUi() throws Exception {

        //When click on add animalButton
        onView(withId(R.id.float_action_button_new)).perform(click());

        //Show animal detail screen
        onView(withId(R.id.image_view_animal_image)).check(matches(isDisplayed()));

    }

    @Test
    public void addAnimalToAnimalsList() {

        String newAnimalRegisterNumber = "0000";
        String newAnimalName = "Mimosa";

        onView(withId(R.id.float_action_button_new)).perform(click());

        onView(withId(R.id.edit_text_register_number)).perform(typeText(newAnimalRegisterNumber),
                closeSoftKeyboard());

        onView(withId(R.id.edit_text_animal_name)).perform(typeText(newAnimalName),
                closeSoftKeyboard());

        onView(withId(R.id.button_save)).perform(ViewActions.scrollTo(), click());

        onView(withId(R.id.recycler_view_pasture)).perform(
                scrollTo(hasDescendant(withText(newAnimalName))));

        onView(withItemText(newAnimalName)).check(matches(isDisplayed()));
    }
}
