package com.owrly.footballteams.model
import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by ravimahfunda on 19/10/2018.
 */

@SuppressLint("ParcelCreator")
@Parcelize
data class Club(val name: String?, val image: Int?, val desc: String?): Parcelable