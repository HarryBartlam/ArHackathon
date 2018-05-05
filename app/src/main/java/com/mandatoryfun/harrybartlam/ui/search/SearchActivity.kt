package com.mandatoryfun.harrybartlam.ui.search

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.mandatoryfun.harrybartlam.R
import com.mandatoryfun.harrybartlam.arch.BaseActivity
import com.mandatoryfun.harrybartlam.data.model.ApiAsset
import com.mandatoryfun.harrybartlam.ext.android.hideKeyboard
import com.mandatoryfun.harrybartlam.ui.ar.ArActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity<SearchMvp.Presenter>(), SearchMvp.View {

    private lateinit var searchAdaptor: SearchAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SearchPresenter(this)
        setContentView(R.layout.activity_search)

        search_button.setOnClickListener {
            this.hideKeyboard()
            presenter.search(search_input.text.toString())
        }
        searchAdaptor = SearchAdaptor()

        searchAdaptor.onSearchArClick = {
            this.hideKeyboard()
            presenter.onARCllicked(it)
        }
    }

    override fun onStart() {
        super.onStart()
        search_list.layoutManager = LinearLayoutManager(this)
        search_list.adapter = searchAdaptor
    }

    override fun showAr(asset: ApiAsset) {
        ArActivity.start(this, asset)
    }

    override fun showFound(assetsList: List<ApiAsset>) {
        searchAdaptor.setData(assetsList)
    }

    override fun showNoneFound() {
        onError("None Found")
    }

    override fun onError(message: String) {
        searchAdaptor.clear()
        Snackbar.make(search_layout, message, Snackbar.LENGTH_LONG).show()
    }
}
