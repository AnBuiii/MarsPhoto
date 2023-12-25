import androidx.compose.runtime.Stable

@Stable
data class PhotoMars(
    val id: String,
    val imgSrc: String
)

fun MarsPhoto.toPhoto(): PhotoMars{
    return PhotoMars(
        id = id,
        imgSrc = imgSrc
    )
}
