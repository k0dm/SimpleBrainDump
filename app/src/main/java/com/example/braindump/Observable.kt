package com.example.braindump

interface Observable {
    fun observe(callback: TextCallback)

    fun putValue(value:String)

    class Base(private var callback: TextCallback) : Observable{
        override fun observe(callback: TextCallback) {
            this.callback = callback
        }

        override fun putValue(value: String) {
            callback.updateText(value)
        }

    }
}