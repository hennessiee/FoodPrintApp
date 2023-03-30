package fontys.greenplanduo

import android.content.Context
import android.media.session.MediaController.PlaybackInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView


class HomeItemAdapter(context: Context): RecyclerView.Adapter<HomeItemAdapter.HomeItemViewHolder>() {
    private var list:MutableList<String>
    init{
        list= mutableListOf()
        val items= PlanItemList.items

        for (item in items){
            list.add(item.title)
        }
    }
    class HomeItemViewHolder(val view:View):RecyclerView.ViewHolder(view){
        val button=view.findViewById<Button>(R.id.bt_item)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeItemAdapter.HomeItemViewHolder {
        val layout= LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_home,parent,false)

        return HomeItemViewHolder(layout)
    }

    override fun onBindViewHolder(holder: HomeItemAdapter.HomeItemViewHolder, position: Int) {
        val item=list.get(position)
        holder.button.text=item


        holder.button.setOnClickListener {

            val direction=HomeFragmentDirections.actionHomeFragmentToViewDetailsFragment2(holder.button.text.toString())
            holder.view.findNavController().navigate(direction)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}