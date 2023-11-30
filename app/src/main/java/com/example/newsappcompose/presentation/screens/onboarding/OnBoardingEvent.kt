package com.example.newsappcompose.presentation.screens.onboarding

/**
 * @property [OnBoardingEvent] class for on boarding event.
 * This class is responsible for holding the events of the on boarding screen.
 */
sealed class OnBoardingEvent {

    object SaveAppEntry: OnBoardingEvent()

}
