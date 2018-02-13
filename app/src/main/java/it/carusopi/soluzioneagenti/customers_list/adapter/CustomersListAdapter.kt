package it.carusopi.soluzioneagenti.list.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView
import it.carusopi.soluzioneagenti.R
import it.carusopi.soluzioneagenti.data.model.Customer
import it.carusopi.soluzioneagenti.data.model.CustomerPage
import kotlinx.android.synthetic.main.recycler_item_customer.view.*
import kotlinx.android.synthetic.main.recycler_item_loader.view.*
import java.util.*


/**
 * Created by carusopi on 30/10/2017.
 */
class CustomersListAdapter(private var context: Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var onCustomerSelectedListener: ((Customer) -> Unit)? = null

    private var customersList: MutableList<Customer> = mutableListOf()
    private var hasNextPage = false

    companion object {
        const val VIEW_TYPE_LOADING = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemCount(): Int = if (hasNextPage) customersList.size + 1 else customersList.size

    override fun getItemViewType(position: Int): Int = if (position < (customersList.size)) VIEW_TYPE_ITEM else VIEW_TYPE_LOADING

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        when (holder) {
            is CustomerViewHolder -> holder.bind(customersList[position])
            is LoaderViewHolder -> holder.progress.isIndeterminate = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == VIEW_TYPE_ITEM) {
            val view = LayoutInflater.from(context).inflate(R.layout.recycler_item_customer, parent, false)
            return CustomerViewHolder(view)
        } else {
            val view = LayoutInflater.from(context).inflate(R.layout.recycler_item_loader, parent, false)
            return LoaderViewHolder(view)
        }
    }

    fun loadCustomers(customersPage: CustomerPage) {
        customersList = LinkedList(customersPage.customersList)
        hasNextPage = customersPage.hasNextPage()
        notifyDataSetChanged()
    }

    fun addMoreCustomers(customersPage: CustomerPage) {
        customersList.addAll(customersPage.customersList)
        hasNextPage = customersPage.hasNextPage()
        notifyDataSetChanged()
    }

    inner class CustomerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val user: TextView = itemView.name
        val avatar: SimpleDraweeView = itemView.imgAvatar

        fun bind(item: Customer) {
            user.text = item.businessName
            avatar.setImageURI(item.avatarUrl)
            onCustomerSelectedListener?.let { itemView.setOnClickListener { it(item) } }
        }
    }

    inner class LoaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val progress: ProgressBar = itemView.progressBar
    }
}