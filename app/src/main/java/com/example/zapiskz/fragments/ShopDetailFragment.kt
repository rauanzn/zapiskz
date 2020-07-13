package com.example.zapiskz.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.text.HtmlCompat
import androidx.lifecycle.Observer
import com.example.zapiskz.viewmodels.MainViewModel
import com.example.zapiskz.adapters.MastersAdapter
import com.example.zapiskz.R
import com.example.zapiskz.viewmodels.ShopDetailViewModel
import com.example.zapiskz.state.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.shop_detail_fragment.view.*

class ShopDetailFragment : Fragment() {
    private val masterAdapter by lazy {
        MastersAdapter(
            context!!
        )
    }
    companion object {
        fun newInstance(id:Int):Fragment {
            val fragment = ShopDetailFragment()
            fragment.arguments = bundleOf("id" to id)
            return fragment
        }
    }

    private val viewModel by lazy{
        MainViewModel.get<ShopDetailViewModel>(
            this
        )
    }
    private val detailId by lazy { arguments?.getInt("id") }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shop_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.setDetailId(detailId?:-1)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.recyclerViewOfMasters.adapter = masterAdapter
        view.anim_toolbar.setNavigationOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }
        viewModel.state.observe(viewLifecycleOwner, Observer {
                when(it){
                    is Result.BeautyShopDetailResponse.Loading -> {
                        Log.i(javaClass.simpleName, "loader")
                    }
                    is Result.BeautyShopDetailResponse.Failure -> {
                        Log.i(javaClass.simpleName, it.throwable?.localizedMessage?:"")
                    }
                    is Result.BeautyShopDetailResponse.Success -> {
                        Log.i(javaClass.simpleName, "success")
                    }
                }
            }
        )
        viewModel.getShopDetail().observe(viewLifecycleOwner, Observer {
                Picasso.get().load("http://zp.jgroup.kz${it.data.firm.avatarUrl}").into(view.product_image)
                view.description.text = HtmlCompat.fromHtml(it.data.firm.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
            view.ratingBar.rating = it.data.firm.averageRating?:0F
                view.time.setText((it.data.firm.workStartTime?:"".split(" ")[1]) + " - " + (it.data.firm.workEndTime?:"".split(" ")[1]))
                view.address.text = HtmlCompat.fromHtml(it.data.firm.address, HtmlCompat.FROM_HTML_MODE_LEGACY)
                view.phone.text = (it.data.firm.phoneNumbers?: emptyList())[0]
                view.site.text = it.data.firm.instagramProfile
                masterAdapter.mastersList.addAll(it.data.masters)
                masterAdapter.notifyDataSetChanged()
            }
        )
    }

}