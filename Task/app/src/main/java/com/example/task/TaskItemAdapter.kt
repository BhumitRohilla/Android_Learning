package com.example.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import org.w3c.dom.Text

class TaskItemAdapter():RecyclerView.Adapter<TaskItemAdapter.TaskViewHolder>(){

    var data = listOf<Task>()
    set(value){
        field=value
        notifyDataSetChanged()
    }

    class TaskViewHolder(val rootView:CardView):RecyclerView.ViewHolder(rootView){
        val taskName=rootView.findViewById<TextView>(R.id.task_name)
        val taskStatus=rootView.findViewById<CheckBox>(R.id.task_done)
        companion object{
            fun infateFrom(parent: ViewGroup):TaskViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val view=layoutInflater.inflate(R.layout.task_item,parent,false) as CardView
                return  TaskViewHolder(view)

            }
        }

        fun bind(item: Task){
            taskName.text=item.taskName
            this.taskStatus.isChecked=item.taskStatus
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder.infateFrom(parent)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

}