package com.argz.issue5260

import io.mockk.every
import io.mockk.mockk
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Request
import okhttp3.Response
import okio.IOException
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {
    @Test
    fun exampleUntTest() {
        val call: Call = mockk(relaxed = true)
        val callFactory: Call.Factory = mockk {
            every { newCall(any()) } returns call
        }
        Requester(callFactory).doRequest()
    }
}