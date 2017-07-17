package fit.ultimate.photoapp.api

import fit.ultimate.photoapp.model.PhotoList
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Pham on 16/7/2017.
 */
interface PhotoApi {
    //Retrofit enqueue -> execute it asynchronously
    //execute -> run it synchronously
    @GET("?key=5908848-3bb2e09db1dfa770242342d14&q=nature&image_type=photo")
    fun getPhotos(): Call<PhotoList>
}