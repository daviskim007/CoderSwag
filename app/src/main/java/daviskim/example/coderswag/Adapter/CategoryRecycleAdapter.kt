package daviskim.example.coderswag.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import daviskim.example.coderswag.Model.Category
import daviskim.example.coderswag.R

class CategoryRecycleAdapter (val context: Context, val categories: List <Category>, val itemClick:(Category)->Unit): RecyclerView.Adapter<CategoryRecycleAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_list_item, parent, false)
        return Holder(view, itemClick)
    }

    // tell the recycling of you how many items is this going to be displaying
    override fun getItemCount(): Int {
        return categories.count()
    }

    /* the function that is called by the recycler view to display the data at the specified location
        binding is the process of preparing a child view to display data according to the position within the adapter*/
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)

    }

    // large class 안 class 라서 inner class
    inner class Holder(itemView: View, val itemClick:(Category)->Unit) : RecyclerView.ViewHolder(itemView) {

        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        fun bindCategory(category: Category, context: Context)  {
            val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName)

            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener { itemClick(category) }
        }
    }
}