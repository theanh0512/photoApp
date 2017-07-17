package fit.ultimate.photoapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fit.ultimate.photoapp.model.Photo

/**
 * Created by Pham on 16/7/2017.
 */
class MainAdapter(var photos: List<Photo>,
                  var clickListener: View.OnClickListener) : RecyclerView.Adapter<MainAdapter.PhotoViewHolder>() {
    override fun onBindViewHolder(holder: PhotoViewHolder?, position: Int) {
        val photo = photos[position]
        holder?.tags?.text = photo.tags
        holder?.likes?.text = photo.likes.toString()
        holder?.favorites?.text = photo.favorites.toString()
        if(photo.previewUrl.isNotEmpty()){
            Glide.with(holder?.tags?.context)
                    .load(photo.previewUrl)
                    .into(holder?.photoItem)
        }
    }

    fun getPhoto(adapterPosition : Int) : Photo {
        return photos[adapterPosition]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.photo_item,parent,false))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    inner class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tags: TextView
        var likes: TextView
        var favorites : TextView
        var photoItem : ImageView

        init {
            if(clickListener != null){
                itemView.setOnClickListener(clickListener)
            }
            itemView.tag = this
            tags = itemView.findViewById<TextView>(R.id.tags)
            likes = itemView.findViewById<TextView>(R.id.likes)
            favorites = itemView.findViewById<TextView>(R.id.favorites)
            photoItem = itemView.findViewById<ImageView>(R.id.photo_item)
        }
    }

}