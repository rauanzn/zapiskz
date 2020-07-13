package com.example.zapiskz.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.zapiskz.*
import com.example.zapiskz.adapters.BeautyShopAdapter
import com.example.zapiskz.listeners.OnShopClickListener
import com.example.zapiskz.viewmodels.BeautyShopsViewModel
import com.example.zapiskz.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.beauty_shops_fragment.view.*

class BeautyShopsFragment : Fragment(),
    OnShopClickListener {
    private val adapterPopularShops by lazy {
        BeautyShopAdapter(
            context!!,
            this
        )
    }
    private val adapterRecommendedShops by lazy {
        BeautyShopAdapter(
            context!!,
            this
        )
    }
    private val adapterRecentlyAddedShops by lazy {
        BeautyShopAdapter(
            context!!,
            this
        )
    }

    companion object {
        fun newInstance() = BeautyShopsFragment()
    }

    private val viewModel by lazy{
        MainViewModel.get<BeautyShopsViewModel>(
            this
        )
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.beauty_shops_fragment, container, false)
        view.recyclerViewShopsPop.adapter = adapterPopularShops
        view.recyclerViewShopsRec.adapter = adapterRecommendedShops
        view.recyclerViewShopsRecentlyAdded.adapter = adapterRecentlyAddedShops
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getShopsPop().observe(viewLifecycleOwner, Observer {
                adapterPopularShops.listOfItems.clear()
                adapterPopularShops.listOfItems.addAll(it)
                adapterPopularShops.notifyDataSetChanged()
                if (it.isEmpty()){
                    view.popularFirmsLayout.visibility = View.GONE
                    view.recyclerViewShopsPop.visibility = View.GONE
                } else {
                    view.popularFirmsLayout.visibility = View.VISIBLE
                    view.recyclerViewShopsPop.visibility = View.VISIBLE
                }
            }
        )
        viewModel.getShopsRec().observe(viewLifecycleOwner, Observer{
                adapterRecommendedShops.listOfItems.clear()
                adapterRecommendedShops.listOfItems.addAll(it)
                adapterRecommendedShops.notifyDataSetChanged()
                if (it.isEmpty()){
                    view.recomendedFirmsLayout.visibility = View.GONE
                    view.recyclerViewShopsRec.visibility = View.GONE
                } else {
                    view.recomendedFirmsLayout.visibility = View.VISIBLE
                    view.recyclerViewShopsRec.visibility = View.VISIBLE
                }

            }
        )
        viewModel.getShopsRecentlyAdded().observe(viewLifecycleOwner, Observer{
                adapterRecentlyAddedShops.listOfItems.clear()
                adapterRecentlyAddedShops.listOfItems.addAll(it)
                adapterRecentlyAddedShops.notifyDataSetChanged()
                if (it.isEmpty()){
                    view.recentlyAddedLayout.visibility = View.GONE
                    view.recyclerViewShopsRecentlyAdded.visibility = View.GONE
                } else {
                    view.recentlyAddedLayout.visibility = View.VISIBLE
                    view.recyclerViewShopsRecentlyAdded.visibility = View.VISIBLE
                }
            }
        )
    }

    override fun onShopClicked(id: Int) {
        Log.i(javaClass.simpleName, "click " + id.toString())
        (activity as MainActivity?)?.supportFragmentManager?.beginTransaction()?.replace(
            R.id.container,
            ShopDetailFragment.newInstance(id)
        )?.addToBackStack(null)?.commit()
    }

}