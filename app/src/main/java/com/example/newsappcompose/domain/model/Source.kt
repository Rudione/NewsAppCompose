package com.example.newsappcompose.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @property [Source] class for source.
 */
@Parcelize
data class Source(
    val id: String,
    val name: String
): Parcelable