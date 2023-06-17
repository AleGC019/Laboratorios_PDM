package com.example.laboratorio11

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.example.laboratorio11.ui.login.LoginFragment
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LoginNavigationTest {

    @Test
    fun testNavigationToWelcome() {
        val navNavController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )

        val login = launchFragmentInContainer<LoginFragment>(
            themeResId = R.style.Theme_Laboratorio11
        )

        login.onFragment{fragment ->
            navNavController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navNavController)
        }

        onView(withId(R.id.emailEditTextInput)).perform(typeText("test@test.com"))
        onView(withId(R.id.passwordEditTextInput)).perform(typeText("12345678"))
        onView(withId(R.id.loginBtn)).perform(click())

        Thread.sleep(2000)
        assertEquals(navNavController.currentDestination?.id, R.id.welcomeFragment)
    }
}