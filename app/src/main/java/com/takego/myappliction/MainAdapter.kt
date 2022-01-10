package com.takego.myappliction

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.takego.myappliction.databinding.AdapterDataBinding
import com.takego.myappliction.model.HealthItem


class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var dataList = mutableListOf<HealthItem>()
    val adapter = MainAdapter2()
    lateinit var context:Context
    fun setHealthList(dataList: List<HealthItem>, mainActivity: Context) {
        this.dataList = dataList.toMutableList()
        this.context=mainActivity
       notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterDataBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val data = dataList.get(position)
        holder.binding.headerTitle.text = data.name
       holder. binding.recyclerView1.adapter = adapter
        adapter.setAccessibleList(data.accessible)



    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}

class MainViewHolder(val binding: AdapterDataBinding) : RecyclerView.ViewHolder(binding.root) {


}