package com.mandatoryfun.harrybartlam.ui.ar.poly

import com.mandatoryfun.harrybartlam.data.model.ApiAsset

class PolyAssetLoader() {

    fun loadAssetFor(asset: ApiAsset, listener: AssetListener) {
        FormatDownloader(asset.formats.get(0)).start(object : FormatDownloader.CompletionListener {
            override fun onDownloadFinished(format: Format) {
                listener.onAssetFound(PolyAsset(asset.name, asset.displayName, asset.authorName, format))
            }

            override fun onError(error: Exception) {
                listener.onError(error)
            }
        })
    }

    interface AssetListener {
        fun onAssetFound(asset: PolyAsset)
        fun onAssetNotFound()
        fun onError(error: Exception)
    }
}
