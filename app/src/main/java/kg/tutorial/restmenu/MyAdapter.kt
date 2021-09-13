package kg.tutorial.restmenu

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.restmenu.databinding.ItemsMenuBinding

class MyAdapter(var clickListener: OnMenuItemClickListener): RecyclerView.Adapter<MyViewHolder>() {

    private val items = arrayListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       // holder.bind(items[position])
        holder.initialize(items.get(position), clickListener)
    }

    override fun getItemCount() = items.count()

    fun setItems (newItems: List<Item>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    interface OnMenuItemClickListener{
        fun onItemClick(item: Item, position: Int)
    }
}