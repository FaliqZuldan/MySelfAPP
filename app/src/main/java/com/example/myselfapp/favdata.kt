data class MediaItem(val type: Int, val title: String?, val videoUrl: String?, val imageUrl: Int)


object MediaType {
    const val SONG = 0
    const val VIDEO = 1
}
