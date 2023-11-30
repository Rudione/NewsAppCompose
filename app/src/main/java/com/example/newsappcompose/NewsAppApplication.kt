package com.example.newsappcompose

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @property [NewsAppApplication] class for application.
 * This class is responsible for initializing the hilt.
 */
@HiltAndroidApp
class NewsAppApplication: Application()