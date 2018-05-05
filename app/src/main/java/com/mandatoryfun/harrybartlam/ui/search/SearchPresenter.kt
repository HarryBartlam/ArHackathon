package com.mandatoryfun.harrybartlam.ui.search

import com.mandatoryfun.harrybartlam.arch.ApiModule
import com.mandatoryfun.harrybartlam.arch.BasePresenter
import com.mandatoryfun.harrybartlam.data.model.ApiAsset
import com.mandatoryfun.harrybartlam.data.model.ApiFormat
import com.mandatoryfun.harrybartlam.data.api.PolyService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class SearchPresenter constructor(searchView: SearchMvp.View,
                                  private val polyService: PolyService = ApiModule.polyService) : BasePresenter<SearchMvp.View>(searchView), SearchMvp.Presenter {

    override fun search(searchString: String) {

        if (searchString.isEmpty()) {
            view?.onError("Search Cannot Be Blank or Empty")
            return
        }

        polyService.getResources(keywords = searchString)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    if (it.assets == null ||it.assets.isEmpty()) {
                        view?.showNoneFound()
                    } else {
                        val assetList = it.assets.filter { asset ->
                            asset.formats.find {
                                isFormatCompatible(it)
                            } != null
                        }
                        assetList.forEach {
                            it.formats = listOf(it.formats.find { isFormatCompatible(it) }!!)
                        }

                        view?.showFound(assetList)
                    }
                }, {
                    Timber.e(it)
                    view?.onError("Connect Error \\_('')_/")
                })
    }

    override fun onARCllicked(selectedAsset: ApiAsset) {
        view?.showAr(selectedAsset)
    }

    private fun isFormatCompatible(format: ApiFormat) =
            format.formatType == "OBJ" && format.resources?.any { it.relativePath.endsWith(".png") } == true
}
