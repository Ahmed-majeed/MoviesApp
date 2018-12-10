package hjc.iraq.com.omdbcodelap.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import hjc.iraq.com.omdbcodelap.Consts
import hjc.iraq.com.omdbcodelap.models.SearchResponse
import hjc.iraq.com.omdbcodelap.OmdbInterFace
import hjc.iraq.com.omdbcodelap.R
import hjc.iraq.com.omdbcodelap.models.Movie
import kotlinx.android.synthetic.main.activity_constraint.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConstraintActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint)


        val id = intent.getStringExtra(Consts.imdbID)
        Log.i("Movie details Activity", id)

        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        if (!id.isNullOrEmpty()) {
            val omdbInterFace = retrofit.create(OmdbInterFace::class.java)
            omdbInterFace.getMovieInfo(id)
                .enqueue(object : Callback<Movie> {
                    override fun onFailure(call: Call<Movie>, t: Throwable) {
                        Toast.makeText(this@ConstraintActivity, t.message, Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {

                        response.body()?.let {

                            //Toast.makeText(this@ConstraintActivity, it.writer, Toast.LENGTH_LONG).show()
                            titleTextViewID.text = it.title
                            writerTextViewID.text = it.writer

                            Picasso.get()
                                .load(it.poster)
                                .into(imageViewID)


                        }
                    }

                })
        } else {
            Toast.makeText(this, "UnKnow movie id", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}


