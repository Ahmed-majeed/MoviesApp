package hjc.iraq.com.omdbcodelap.models

import com.google.gson.annotations.SerializedName

class Movie {

    @SerializedName("Title")
    var title:String =""

    @SerializedName("Writer")
    var writer:String=""

    @SerializedName("Actors")
    var actors: String=""
    @SerializedName("Poster")
    var poster: String=""
    @SerializedName("imdbID")
    var id: String = ""
}