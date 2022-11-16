package my.challenge.project.connectivity

import android.content.Context

interface ConnectivityCheck {

    fun isNetworkAvailable(ctx: Context): Boolean
}