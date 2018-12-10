package hjc.iraq.com.omdbcodelap

import hjc.iraq.com.omdbcodelap.models.Movie
import hjc.iraq.com.omdbcodelap.models.SearchResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OmdbInterFace {

    @GET("?apikey=4c479aac")
    fun searchMovies(@Query("s") searchQuery: String): Call<SearchResponse>

    @GET("?apikey=4c479aac")
    fun getMovieInfo(@Query("i") imdbId: String): Call<Movie>

}