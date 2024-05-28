package br.com.ulbra.myapplication.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.com.ulbra.myapplication.data.models.Product
import br.com.ulbra.myapplication.R
import br.com.ulbra.myapplication.databinding.FragmentHomeBinding
import br.com.ulbra.myapplication.presentation.viewmodels.MainViewModel
import br.com.ulbra.myapplication.presentation.adapters.ProductAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val rc = binding.rcProduct
        val productAdapter =
            ProductAdapter(
                viewModel.getProducts(),
                goToDetail = ::goToDetail,
                removeItem = ::removeItem
            )

        rc.adapter = productAdapter

        super.onViewCreated(view, savedInstanceState)
    }

    private fun removeItem(product: Product) {
        viewModel.removeProduct(product)
    }


    private fun goToDetail(product: Product) {
        val bundle = bundleOf("data" to product)
        findNavController().navigate(
            R.id.action_homeFragment_to_productDetailActivity,
            bundle
        )
    }

}