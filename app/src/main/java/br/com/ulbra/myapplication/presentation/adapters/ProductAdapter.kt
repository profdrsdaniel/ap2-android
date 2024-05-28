package br.com.ulbra.myapplication.presentation.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import br.com.ulbra.myapplication.R
import br.com.ulbra.myapplication.data.models.Product
import br.com.ulbra.myapplication.databinding.ProductItemBinding

class ProductAdapter(
    val listaDeProdutos: MutableList<Product>,
    val goToDetail: (product: Product) -> Unit,
    val removeItem: (product: Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(product: Product) {
            binding.product = product

            binding.root.setOnLongClickListener {
                showPopUpMenu(it, product)
                false
            }

            binding.root.setOnClickListener {
                goToDetail(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        val binding = ProductItemBinding.inflate(LayoutInflater.from(context))

        return ViewHolder(binding)
    }

    override fun getItemCount() = listaDeProdutos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listaDeProdutos[position])
    }

    private fun showPopUpMenu(view: View, product: Product) {
        PopupMenu(context, view).apply {
            setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.remove -> {
                        removeItem(product)
                        notifyDataSetChanged()
                        false
                    }

                    else -> {
                        Log.i("error", "error")
                        false
                    }
                }
            }

            inflate(R.menu.menu_popup)
            show()
        }
    }
}