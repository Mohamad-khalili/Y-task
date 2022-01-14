package com.mkh.news.task.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.mkh.news.task.R
import com.mkh.news.task.models.Item
import com.mkh.news.task.utils.Publics
import kotlinx.android.synthetic.main.recycler_item.view.*
import kotlinx.android.synthetic.main.recycler_item2.view.*


private const val  HAS_WIKI_TRUE = 0
private const val  HAS_WIKI_FALSE = 1
class RecyclerAdapter(private val context: Context, private val list: List<Item>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class MyViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

        fun bind(item : Item){
            itemView.name.text = item.full_name
            itemView.description.text = item.description
            itemView.language.text = item.language
            itemView.updated_at.text = Publics.convertTime(item.updated_at)

        }
    }
    class MyViewHolder1(itemView : View): RecyclerView.ViewHolder(itemView){

        fun bind(item : Item){
            itemView.fullName1.text= item.full_name
            itemView.description1.text = item.description
            itemView.language1.text = item.language
            itemView.updated_at1.text = Publics.convertTime(item.updated_at)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == HAS_WIKI_FALSE){
            val view = LayoutInflater.from(context).inflate(R.layout.recycler_item,parent,false)
            return MyViewHolder(view)
        }else {

            val view = LayoutInflater.from(context).inflate(R.layout.recycler_item2,parent,false)
            return MyViewHolder1(view)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       if(getItemViewType(position) == HAS_WIKI_TRUE){
           (holder as MyViewHolder1).bind(list[position])
       }else{
           (holder as MyViewHolder).bind(list[position])
       }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {

        return if (list[position].has_wiki){
            HAS_WIKI_TRUE
        }else {
            HAS_WIKI_FALSE
        }
    }
}