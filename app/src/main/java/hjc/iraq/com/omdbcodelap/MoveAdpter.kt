package hjc.iraq.com.omdbcodelap

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import hjc.iraq.com.omdbcodelap.activities.ConstraintActivity
import hjc.iraq.com.omdbcodelap.models.Movie
import kotlinx.android.synthetic.main.item_move.view.*


class MoveAdpter : RecyclerView.Adapter<MoveAdpter.MoveViewHolder> {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_move, parent, false)
        return MoveViewHolder(view)

    }

    override fun getItemCount(): Int {
        return moveList.size
    }

    override fun onBindViewHolder(viewHolder: MoveViewHolder, position: Int) {

        viewHolder.setMove(moveList[position])


    }

    var moveList: List<Movie>

    constructor(cityList: List<Movie>) {
        this.moveList = cityList
    }

    inner class MoveViewHolder : RecyclerView.ViewHolder {
        val view: View

        constructor(view: View) : super(view) {
            this.view = view

            this.view.setOnClickListener {
                val clickedMove = moveList[layoutPosition]
                val clickId = clickedMove.id
                //Log.i("Movie Adapter","$clickId")

                val intent = Intent(view.context, ConstraintActivity::class.java)

                intent.putExtra(Consts.imdbID, clickId)
                view.context.startActivity(intent)
            }





        }

        fun setMove(movie: Movie) {
            view.titleTextView.text = movie.title
            view.writerTextView.text = movie.writer
            Picasso.get()
                .load(movie.poster)
                .into(view.imageView)

        }

    }
}