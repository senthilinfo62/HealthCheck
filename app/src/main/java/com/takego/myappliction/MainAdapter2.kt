package com.takego.myappliction

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.takego.myappliction.databinding.AdapterData2Binding
import com.takego.myappliction.databinding.AdapterDataBinding
import com.takego.myappliction.model.AccessibleItem
import okhttp3.internal.notify


class MainAdapter2 : RecyclerView.Adapter<MainViewHolder2>() {

    var dataList = mutableListOf<AccessibleItem>()

    fun setAccessibleList(dataList: List<AccessibleItem>) {
        this.dataList = dataList.toMutableList()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder2 {
        val inflater = LayoutInflater.from(parent.context)

        val binding = AdapterData2Binding.inflate(inflater, parent, false)
        return MainViewHolder2(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder2, position: Int) {
        val data = dataList.get(position)
        if(data.name==null){
            holder.binding.title.text = data.type
        }else{
            holder.binding.title.text = data.name
        }

        if(data.success){
            holder.binding.status.setText("TRUE")
            holder.binding.status.setTextColor(Color.GREEN)
        }else{
            holder.binding.status.setText("FALSE")
            holder.binding.status.setTextColor(Color.RED)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }


}

class MainViewHolder2(val binding: AdapterData2Binding) : RecyclerView.ViewHolder(binding.root) {

}