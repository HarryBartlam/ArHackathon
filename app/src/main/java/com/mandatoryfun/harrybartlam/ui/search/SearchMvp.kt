package com.mandatoryfun.harrybartlam.ui.search

import com.mandatoryfun.harrybartlam.arch.BaseMvp
import com.mandatoryfun.harrybartlam.data.model.ApiAsset

interface SearchMvp : BaseMvp {

    interface View : BaseMvp.View {

        fun showAr(asset: ApiAsset)
        fun showNoneFound()
        fun onError(message: String)
        fun showFound(assetsList: List<ApiAsset>)
    }

    interface Presenter : BaseMvp.Presenter {
        fun search(searchString: String)
        fun onARCllicked(selectedAsset: ApiAsset)
    }
}
