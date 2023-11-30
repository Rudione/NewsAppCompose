package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * @property [News] data class for news.
 */
@Serializable
data class News(
    @SerializedName("articles")
    val articles: List<Article>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)