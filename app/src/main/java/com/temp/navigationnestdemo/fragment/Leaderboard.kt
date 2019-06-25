package com.temp.navigationnestdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.temp.navigationnestdemo.R

class Leaderboard :Fragment(){

    private lateinit var recyclerView: RecyclerView

    private lateinit var viewAdapter : RecyclerView.Adapter<*>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_leaderboard, container, false)

        viewAdapter = MyAdapter(arrayOf("Flo", "Ly", "Jo"))

        recyclerView = view.findViewById<RecyclerView>(R.id.leaderboard_list).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }
        return view
    }

}

class MyAdapter(private val myDataSet : Array<String>):RecyclerView.Adapter<MyAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_view_item, parent, false)

        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = myDataSet.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.user_name_text).text = myDataSet[position]

        holder.itemView.findViewById<ImageView>(R.id.user_avatar_image)
                .setImageResource(listOfAvatars[position])

        /*todo kotlin 骚操作之 to*/
        holder.view.setOnClickListener {
            var  bundle = bundleOf("userName" to myDataSet[position],"pwd" to myDataSet[position] )
            Navigation.findNavController(it).navigate(R.id.action_leaderboard_to_userProfile,bundle)/*携带参数*/
        }

    }

    class ViewHolder(val view: View):RecyclerView.ViewHolder(view);

}

private val listOfAvatars = listOf(
        R.drawable.avatar_1_raster, R.drawable.avatar_2_raster, R.drawable.avatar_3_raster)