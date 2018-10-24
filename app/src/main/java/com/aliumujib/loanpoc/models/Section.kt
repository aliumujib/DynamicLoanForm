package com.aliumujib.loanpoc.models

import android.os.Parcel
import android.os.Parcelable

class Section(var sectionNo: Int,
              var sectionTitle: String,
              var sectionDescription: String,
              var sectionDrawable: Int,
              var sectionBackground: Int,
              var showSectionNumber: Boolean,
              var sectionId: Int,
              var pages: List<Page>? = null) : Parcelable {

    constructor(source: Parcel) : this(
            source.readInt(),
            source.readString(),
            source.readString(),
            source.readInt(),
            source.readInt(),
            1 == source.readInt(),
            source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(sectionNo)
        writeString(sectionTitle)
        writeString(sectionDescription)
        writeInt(sectionDrawable)
        writeInt(sectionBackground)
        writeInt((if (showSectionNumber) 1 else 0))
        writeInt(sectionId)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Section> = object : Parcelable.Creator<Section> {
            override fun createFromParcel(source: Parcel): Section = Section(source)
            override fun newArray(size: Int): Array<Section?> = arrayOfNulls(size)
        }
    }
}