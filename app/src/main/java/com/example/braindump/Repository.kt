package com.example.braindump

interface Repository {

    fun saveText(text: String)

    fun getText(callback: Observable?)

    class Base() : Repository{

        private var text = ""
        override fun saveText(text: String) {
            this.text = text
        }

        override fun getText(callback: Observable?) {
            callback?.putValue(text)
        }

    }
}
