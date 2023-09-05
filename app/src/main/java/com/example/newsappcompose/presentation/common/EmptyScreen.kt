package com.example.newsappcompose.presentation.common

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.paging.LoadState
import com.example.newsappcompose.R
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun EmptyScreen(error: LoadState.Error? = null) {

    var message by remember {
        mutableStateOf(parseErrorMessage(error))
    }

    var icon by remember {
        mutableStateOf(R.drawable.ic_network_error)
    }

    if (error == null){
        message = "You have not saved news so far !"
        icon = R.drawable.ic_search_document
    }

    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation by animateFloatAsState(
        targetValue = if (startAnimation) 0.3f else 0f,
        animationSpec = tween(durationMillis = 1000), label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

}

fun parseErrorMessage(error: LoadState.Error?): Any {
    return when (error?.error) {
        is SocketTimeoutException -> "Server Unavailable"
        is ConnectException -> "Internet Unavailable"
        else -> "Unknown Error"
    }
}
