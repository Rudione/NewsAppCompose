package data.model

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.Serializable

/**
 * @property [Article] data class for article.
 */
@Serializable
data class Source(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String
)