package fit.ultimate.photoapp.model

import java.io.Serializable

/**
 * Created by Pham on 16/7/2017.
 */
data class Photo(val id : String,
                 val likes : Int,
                 val favorites : Int,
                 val tags : String,
                 val previewUrl : String,
                 val webFormatUrl : String) : Serializable{

}