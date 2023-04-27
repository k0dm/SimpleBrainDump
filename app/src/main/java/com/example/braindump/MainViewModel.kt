package com.example.braindump

class MainViewModel(private val repository: Repository) {

    private var callback: Observable? = null


    fun init(observable: Observable.Base) {
        this.callback = observable
    }

    fun clear() {
        callback = null
    }

    fun getData() {
        repository.getText(callback)
    }

    fun saveData(text: String) {
        repository.saveText(text)
    }


}