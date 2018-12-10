package hjc.iraq.com.omdbcodelap.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.text.Editable
import android.text.TextWatcher
import hjc.iraq.com.omdbcodelap.*
import hjc.iraq.com.omdbcodelap.models.SearchResponse
import hjc.iraq.com.omdbcodelap.models.Movie
import kotlinx.android.synthetic.main.activity_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GridActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)


        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchMove(s.toString())
            }

        })
    }

    private fun searchMove(searchQuery: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl(Consts.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val omdbInterface = retrofit.create(OmdbInterFace::class.java)

        omdbInterface.searchMovies(searchQuery)
            .enqueue(object : Callback<SearchResponse> {
                override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
//                    Toast.makeText(this@SearchActivity,t.message, Toast.LENGTH_SHORT).show()
//                    Toast.makeText(this@SearchActivity,"Hello", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {

                    response.body()?.let {
                        prepareRecyclerView(it.moviesList)

                    }
                }

            })

    }

    private fun prepareRecyclerView(moveList: List<Movie>) {
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = MoveAdpter(moveList)

    }
}



