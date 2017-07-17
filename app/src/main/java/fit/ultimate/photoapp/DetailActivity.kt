package fit.ultimate.photoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import fit.ultimate.photoapp.model.Photo
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        setSupportActionBar(toolbar)

        val photo = intent.getSerializableExtra(PHOTO) as Photo?
        //the function inside let only run if the webFormatUrl is not null
        photo?.webformatURL.let {
            Glide.with(this).load(photo?.webformatURL)
                    .into(imageView)
        }
        imageView.setOnClickListener{
            finish()
        }
    }

    //companion object is kotlin way of creating constant and static
    companion object {
        val PHOTO = "PHOTO"
    }
}
