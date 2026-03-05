package ani.saiyako.media.novel

import android.view.HapticFeedbackConstants
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ani.saiyako.FileUrl
import ani.saiyako.copyToClipboard
import ani.saiyako.databinding.ItemUrlBinding
import ani.saiyako.parsers.Book
import ani.saiyako.setSafeOnClickListener
import ani.saiyako.tryWith

class UrlAdapter(
    private val urls: List<FileUrl>,
    val book: Book,
    val novel: String,
    val callback: BookDialog.Callback?
) :
    RecyclerView.Adapter<UrlAdapter.UrlViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UrlViewHolder {
        return UrlViewHolder(
            ItemUrlBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UrlViewHolder, position: Int) {
        val binding = holder.binding
        val url = urls[position]
        binding.urlQuality.text = url.url
        binding.urlQuality.maxLines = 4
        binding.urlDownload.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int = urls.size

    inner class UrlViewHolder(val binding: ItemUrlBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setSafeOnClickListener {
                tryWith(true) {
                    binding.urlDownload.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS)
                    callback?.onDownloadTriggered(book.links[bindingAdapterPosition].url)
                    /*download(
                        itemView.context,
                        book,
                        bindingAdapterPosition,
                        novel
                    )*/

                }
            }
            itemView.setOnLongClickListener {
                val file = urls[bindingAdapterPosition]
                copyToClipboard(file.url, true)
                true
            }
        }
    }
}