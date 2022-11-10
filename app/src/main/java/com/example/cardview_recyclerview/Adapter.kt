package com.example.cardview_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import coil.load
import timber.log.Timber
import java.lang.Exception

class Adapter (
    private val context: Context,
    private var onCardClick: (position: Int) -> Unit
    ) : RecyclerView.Adapter<Adapter.ViewHolder>(){

    var userList = getUsers()

    class ViewHolder(view: View, private val onCardClick: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        val firstName: TextView = view.findViewById(R.id.cardUserFirstName)
        val lastName: TextView = view.findViewById(R.id.cardUserLastName)
        val userName : TextView = view.findViewById(R.id.cardUserUsername)
        val imageView: ImageView = view.findViewById(R.id.cardUserImage)

        override fun onClick(v: View?) {
            val position = absoluteAdapterPosition
            onCardClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var viewInflater = LayoutInflater.from(parent.context)
            .inflate(R.layout.card, parent, false)

        return Adapter.ViewHolder(viewInflater, onCardClick)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.apply {
            firstName.text = userList[position].firstName
            lastName.text = userList[position].lastName
            userName.text = userList[position].userName
        }

        try {
            Glide.with(context).load(userList[position].image).into(holder.imageView)
        } catch (e: Exception) {
            Timber.e("ArticleThumbnailAdapter: Line 43. Exception: $e")
            holder.imageView.setImageResource(R.drawable.ic_baseline_person_24)
        }
    }

    override fun getItemCount(): Int {
        return getUsers().size
    }

    fun getUsers() : List<User>{
        var userList = listOf<User>()
        val aaronDonald = User(
            "Aaron",
            "Donald",
            "@AaronDonald",
            31,
            "Aaron Charles Donald (born May 23, 1991) is an American football " +
                    "defensive tackle for the Los Angeles Rams of the " +
                    "National Football League (NFL).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/aaron_donald.jpg?raw=true"

        )
        val tomBrady = User(
            "Tom",
            "Brady",
            "@TomBrady",
            44,
            "Thomas Edward Patrick Brady Jr. (born August 3, 1977) is an American football quarterback for the Tampa Bay Buccaneers of the National Football League (NFL).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/tom_brady.jpg?raw=true"
        )
        val austinMatthews = User(
            "Austin",
            "Matthews",
            "@AustinMatthews",
            24,
            "Auston Taylour Matthews (born September 17, 1997) is an American professional ice hockey center and alternate captain for the Toronto Maple Leafs",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/austin_matthews.jpg?raw=true"
        )
        val juanSoto = User(
            "Juan",
            "Soto",
            "@JuanSoto",
            23,
            "Juan José Soto Pacheco (born October 25, 1998), nicknamed \"Childish Bambino\", is a Dominican professional baseball outfielder for the Washington Nationals",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/juan_soto.jpg?raw=true"
        )
        val lionelMessi = User(
            "Lionel",
            "Messi",
            "@LionelMessi",
            35,
            "Lionel Andrés Messi also known as Leo Messi, is an Argentine professional footballer who plays as a forward for Ligue 1 club Paris Saint-Germain",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/lionel_messi.jpg?raw=true"
        )
        val caleMaker = User(
            "Cale",
            "Maker",
            "@CaleMaker",
            23,
            "Cale Douglas Makar (born October 30, 1998) is a Canadian professional ice hockey defenceman for the Colorado Avalanche of the National Hockey League (NHL)",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/cale_maker.jpg?raw=true"
        )
        val steveAustin = User(
            "Steve",
            "Austin",
            "@SteveAustin",
            57,
            "Steve Austin better known by his ring name \"Stone Cold\" Steve Austin, is an American media personality, actor, producer, and retired professional wrestler.",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/steve_austin.jpg?raw=true"
        )
        val mikeTrout = User(
            "Mike",
            "Trout",
            "@MikeTrout",
            30,
            "Michael Nelson Trout (born August 7, 1991) is an American professional baseball center fielder for the Los Angeles Angels of Major League Baseball (MLB).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/mike_trout.jpg?raw=true"
        )
        val novakDjokovic = User(
            "Novak",
            "Djokovic",
            "@NovakDjokovic",
            35,
            "Novak Djokovic is a Serbian professional tennis player. He is currently ranked world No. 3 in singles by the Association of Tennis Professionals (ATP).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/novak_djokovic.jpg?raw=true"
        )
        val paulRabil = User(
            "Paul",
            "Rabil",
            "@PaulRabil",
            36,
            "Paul Rabil (born December 14, 1985), is an American former professional lacrosse player and co-founder of the Premier Lacrosse League.",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/paul_rabil.jpg?raw=true"
        )
        val rafaelNadal = User(
            "Rafael",
            "Nadal",
            "@RafaelNadal",
            36,
            "Rafael Nadal Parera is a Spanish professional tennis player, currently ranked world No. 4 in singles by the Association of Tennis Professionals (ATP).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/rafael_nadal.jpg?raw=true"
        )
        val christianoRonaldo = User(
            "Christiano",
            "Ronaldo",
            "@ChristianoRonaldo",
            37,
            "Cristiano Ronaldo dos Santos Aveiro GOIH ComM is a Portuguese professional footballer who plays as a forward for Premier League club Manchester",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/christiano_ronaldo.jpg?raw=true"
        )
        val michaelJordan = User(
            "Michael",
            "Jordan",
            "@MichaelJordan",
            59,
            "Michael Jeffrey Jordan (born February 17, 1963), also known by his initials MJ, is an American businessman and former professional basketball player.",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/michael_jordan.jpg?raw=true"
        )
        val theUndertaker = User(
            "The",
            "Undertaker",
            "@TheUndertaker",
            57,
            "Mark William Callaway (born March 24, 1965), better known by the ring name The Undertaker is an American retired professional wrestler.",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/the_undertaker.jpg?raw=true"
        )
        val lebronJames = User(
            "Lebron",
            "James",
            "@LebronJames",
            37,
            "LeBron Raymone James Sr is an American professional basketball player for the Los Angeles Lakers of the National Basketball Association (NBA).",
            "https://github.com/cglaunchtech/tempImgs/blob/main/tempimgs/lebron_james.jpg?raw=true"
        )

        userList = listOf(aaronDonald,
            tomBrady,
            austinMatthews,
            juanSoto,
            lionelMessi,
            caleMaker,
            steveAustin,
            mikeTrout,
            novakDjokovic,
            paulRabil,
            rafaelNadal,
            christianoRonaldo,
            michaelJordan,
            theUndertaker,
            lebronJames)
        return userList
    }

}