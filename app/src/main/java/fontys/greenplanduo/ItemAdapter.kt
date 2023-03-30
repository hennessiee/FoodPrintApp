package fontys.greenplanduo

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(context: Context):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var list:MutableList<String>
    init{
        list= mutableListOf()
        val items= listOf(
            PlanItem("Item 1","This is item 1","Impact 1"),
            PlanItem("Item 2","This is item 1","Impact 1"),
            PlanItem("Item 3","This is item 1","Impact 1")
        )
        for (item in items){
            list.add(item.title)
        }
    }

    //Creating the view (what is in the view?)
    class ItemViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val button=view.findViewById<Button>(R.id.bt_item)
    }

    //Inflating the view (Displaying the view)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layout=LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_view_item,parent,false)

        return ItemViewHolder(layout)
    }

    //not used
    override fun getItemCount(): Int {
        return list.size
    }

    //Functional stuff
    //for example, setOnclickListener
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item=list.get(position)
        holder.button.text=item


        holder.button.setOnClickListener {
            val direction=AddPlanFragmentDirections.actionAddPlanFragmentToViewDetailsFragment2(holder.button.text.toString())
            holder.view.findNavController().navigate(direction)
        }
    }
}