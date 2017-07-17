package fit.ultimate.photoapp.api

import fit.ultimate.photoapp.model.PhotoList
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Pham on 16/7/2017.
 */
class PhotoRetriever {
    private val service: PhotoApi

    init {
        val retrofit = Retrofit.Builder().
                baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(PhotoApi::class.java)
    }

    fun getPhotos(callback : Callback<PhotoList>){
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}