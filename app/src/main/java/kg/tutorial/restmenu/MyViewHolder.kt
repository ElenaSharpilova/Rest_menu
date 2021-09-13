package kg.tutorial.restmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.restmenu.databinding.ItemsMenuBinding

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val binding = ItemsMenuBinding.bind(itemView)
        fun bind (item: Item) = with(binding){
            imageView.setImageResource(item.imageId)
            tvItem.text = item.title
            tvTimeOrder.text = item.timeOrder
            tvNameCountry.text = item.nameCountry
            tvNameFood. text = item.nameFood
            distanceDelivery.text = item.distanceDelivery
        }
    companion object {
        fun create (parent: ViewGroup) : MyViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.items_menu, parent, false)
            return MyViewHolder(view)
        }
    }

    fun initialize(item: Item, action: MyAdapter.OnMenuItemClickListener) {
        val binding = ItemsMenuBinding.bind(itemView)
        binding.imageView.setImageResource(item.imageId)
        binding.tvItem.text = item.title
        binding.tvTimeOrder.text = item.timeOrder
        binding.tvNameCountry.text = item.nameCountry
        binding.tvNameFood. text = item.nameFood
        binding.distanceDelivery.text = item.distanceDelivery

       itemView.setOnClickListener{
           action.onItemClick(item, adapterPosition)
       }
    }
}