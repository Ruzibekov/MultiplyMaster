package uz.ruzibekov.multiplymaster.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.ruzibekov.multiplymaster.R

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    var items: ArrayList<Int> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onClick: (Int) -> Unit = {}

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var tvTitle: TextView? = null

        init {
            tvTitle = itemView.findViewById(R.id.tv_title)
        }

        @SuppressLint("NotifyDataSetChanged", "SetTextI18n")
        fun onBind(data: Int) {

            tvTitle?.text = "x$data"

            itemView.setOnClickListener {
                onClick.invoke(data)
                notifyDataSetChanged()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        )
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(items[position])
    }
}