package com.sorokin.yamob.mycash.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sorokin.yamob.mycash.R
import com.sorokin.yamob.mycash.ui.base.BaseFragment
import com.sorokin.yamob.mycash.util.getViewModel
import com.sorokin.yamob.mycash.util.observe
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject


class HomeFragment @Inject constructor() : BaseFragment<HomeViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rg_currencies.setOnCheckedChangeListener { group, checkedId ->
            when(checkedId){
                R.id.rb_currency_0 -> viewModel.setCurrency(viewModel.favoriteCurrencies.value!![0])
                R.id.rb_currency_1 -> viewModel.setCurrency(viewModel.favoriteCurrencies.value!![1])
                R.id.rb_currency_2 -> viewModel.setCurrency(viewModel.favoriteCurrencies.value!![2])
            }
        }

        viewModel.favoriteCurrencies.observe(this){
            it?.let {
                rb_currency_0.text = it[0].shortName
                rb_currency_1.text = it[1].shortName
                rb_currency_2.text = it[2].shortName
                if(rg_currencies.checkedRadioButtonId == -1){ // If not checked
                    rg_currencies.check(R.id.rb_currency_0)
                }
            }
        }

        viewModel.userMoney.observe(this){
            tv_balance.text = it?.amount?.toString() ?: "0"
        }


    }

    override fun provideViewModel(): HomeViewModel = getViewModel(viewModelFactory)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}
