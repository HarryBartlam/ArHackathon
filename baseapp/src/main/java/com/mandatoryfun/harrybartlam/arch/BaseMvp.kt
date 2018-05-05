package com.mandatoryfun.harrybartlam.arch

interface BaseMvp {
    interface View {
        fun finish()
    }

    interface Presenter {
        fun onDestroy()
    }
}
