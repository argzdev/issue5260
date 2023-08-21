package com.argz.issue5260

import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import okio.IOException


class Requester(private val callFactory: Call.Factory) {
    fun doRequest() {
        callFactory.newCall(Request.Builder().url("https://google.com").build())
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {}
                override fun onResponse(call: Call, response: Response) {}
            })
    }
}
