package ani.saiyako.media.manga

import ani.saiyako.media.MediaDetailsViewModel
import ani.saiyako.media.SourceAdapter
import ani.saiyako.media.SourceSearchDialogFragment
import ani.saiyako.parsers.ShowResponse
import kotlinx.coroutines.CoroutineScope

class MangaSourceAdapter(
    sources: List<ShowResponse>,
    val model: MediaDetailsViewModel,
    val i: Int,
    val id: Int,
    fragment: SourceSearchDialogFragment,
    scope: CoroutineScope
) : SourceAdapter(sources, fragment, scope) {
    override suspend fun onItemClick(source: ShowResponse) {
        model.overrideMangaChapters(i, source, id)
    }
}