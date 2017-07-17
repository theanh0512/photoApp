package fit.ultimate.photoapp.api

import fit.ultimate.photoapp.model.PhotoList
import okhttp3.OkHttpClient
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.URL
import java.security.KeyStore
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

/**
 * Created by Pham on 16/7/2017.
 */
class PhotoRetriever {
    private val service: PhotoApi

    init {
        val url : URL = URL("https://pixabay.com/api/?key=5908848-3bb2e09db1dfa770242342d14&q=nature&image_type=photo")
        val trustManagerFactory : TrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        val keystore : KeyStore? = null
        trustManagerFactory.init(keystore)
        val trustManagers : Array<TrustManager> = trustManagerFactory.trustManagers
        val trustManager:X509TrustManager = trustManagers[0] as X509TrustManager
        val noSSLv3Factory : SSLSocketFactory = NoSSLv3SocketFactory(url)
        val okHttpClient = OkHttpClient().newBuilder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .sslSocketFactory(noSSLv3Factory,trustManager).build()
        val retrofit = Retrofit.Builder().
                baseUrl("https://pixabay.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        service = retrofit.create(PhotoApi::class.java)
    }

    fun getPhotos(callback : Callback<PhotoList>){
        val call = service.getPhotos()
        call.enqueue(callback)
    }
}