package com.gzslt.calendardemo.ui.calendar

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gzslt.calendardemo.model.EventPresentationModel

class EventListAdapter(
    private val context: Context
) : ListAdapter<EventPresentationModel, RecyclerView.ViewHolder>(
    EventItemDiffCallback
) {

    var items: List<EventPresentationModel> = ArrayList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        EventViewHolder(EventItemView(context))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder.itemView as EventItemView).bind(items[position])
    }

    class EventViewHolder(view: EventItemView) :
        RecyclerView.ViewHolder(view)

    object EventItemDiffCallback : DiffUtil.ItemCallback<EventPresentationModel>() {
        override fun areItemsTheSame(
            oldItem: EventPresentationModel,
            newItem: EventPresentationModel
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: EventPresentationModel,
            newItem: EventPresentationModel
        ): Boolean {
            return oldItem == newItem
        }
    }
}
