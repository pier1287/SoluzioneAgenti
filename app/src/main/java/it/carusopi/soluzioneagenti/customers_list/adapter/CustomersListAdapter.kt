package it.carusopi.soluzioneagenti.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.commons.inflate
import it.carusopi.soluzioneagenti.data.model.Customer
import kotlinx.android.synthetic.main.recycler_item_customer.view.*
import kotlinx.android.synthetic.main.recycler_item_loader.view.*


/**
 * Created by carusopi on 30/10/2017.
 */

const val VIEW_TYPE_LOADING = 0
const val VIEW_TYPE_ITEM = 1

class CustomersListAdapter (private val customerClick: (Customer) -> Unit):
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    private var customersList: MutableList<Customer> = mutableListOf()
    private var hasNextPage = false

    override fun getItemCount(): Int = if (hasNextPage) customersList.size + 1 else customersList.size

    override fun getItemViewType(position: Int): Int = if (position < (customersList.size)) VIEW_TYPE_ITEM else VIEW_TYPE_LOADING

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CustomerViewHolder -> holder.bind(customersList[position])
            is LoaderViewHolder -> holder.progress.isIndeterminate = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            VIEW_TYPE_LOADING -> LoaderViewHolder(parent.inflate(R.layout.recycler_item_loader))
            else -> CustomerViewHolder(parent.inflate(R.layout.recycler_item_customer))
        }
    }

    fun addCustomers(customersList: List<Customer>, hasMore: Boolean) {
        this.customersList.addAll(customersList)
        hasNextPage = hasMore
        notifyDataSetChanged()
    }

    inner class CustomerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val user: TextView = itemView.name
        private val avatar: SimpleDraweeView = itemView.imgAvatar

        fun bind(item: Customer) {
            user.text = item.businessName
            avatar.setImageURI(item.avatarUrl)
            itemView.setOnClickListener { customerClick.invoke(item) }
        }
    }

    inner class LoaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val progress: ProgressBar = itemView.progressBar
    }
}