package com.mandatoryfun.harrybartlam.data.model

import android.os.Parcel
import android.os.Parcelable

data class ApiAssets(val assets: List<ApiAsset>)

data class ApiAsset(val name: String, val displayName: String, val authorName: String, var formats: List<ApiFormat>) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.createTypedArrayList(ApiFormat)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(displayName)
        parcel.writeString(authorName)
        parcel.writeTypedList(formats)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiAsset> {
        override fun createFromParcel(parcel: Parcel): ApiAsset {
            return ApiAsset(parcel)
        }

        override fun newArray(size: Int): Array<ApiAsset?> {
            return arrayOfNulls(size)
        }
    }
}

data class ApiFormat(val root: ApiFile, val resources: List<ApiFile>?, val formatType: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(ApiFile::class.java.classLoader),
            parcel.createTypedArrayList(ApiFile),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(root, flags)
        parcel.writeTypedList(resources)
        parcel.writeString(formatType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiFormat> {
        override fun createFromParcel(parcel: Parcel): ApiFormat {
            return ApiFormat(parcel)
        }

        override fun newArray(size: Int): Array<ApiFormat?> {
            return arrayOfNulls(size)
        }
    }
}

data class ApiFile(val relativePath: String, val url: String, val contentType: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(relativePath)
        parcel.writeString(url)
        parcel.writeString(contentType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ApiFile> {
        override fun createFromParcel(parcel: Parcel): ApiFile {
            return ApiFile(parcel)
        }

        override fun newArray(size: Int): Array<ApiFile?> {
            return arrayOfNulls(size)
        }
    }
}
