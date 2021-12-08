package com.example.ca_mobile1.data

import android.os.Parcel
import android.os.Parcelable
import com.example.ca_mobile1.NEW_CHARACTER_ID

data class Disney(
    val _id: Int,
    val name: String?,
    val imageUrl: String?,
    val films: List<String>?,
    val tvShows: List<String>?,
    val url: String?
        ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.createStringArrayList(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(_id)
        parcel.writeString(name)
        parcel.writeString(imageUrl)
        parcel.writeStringList(films)
        parcel.writeStringList(tvShows)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Disney> {
        override fun createFromParcel(parcel: Parcel): Disney {
            return Disney(parcel)
        }

        override fun newArray(size: Int): Array<Disney?> {
            return arrayOfNulls(size)
        }
    }
}
