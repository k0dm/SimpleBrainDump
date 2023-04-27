package com.example.braindump

import org.junit.Assert.assertEquals
import org.junit.Test


class DataSourceTest {

    @Test
    fun `test start with saved text`(){
        val dataSource = FakeDataSource("initial data")
        val repository = Repository.DataSource(dataSource)
        val textCallback = TestCallback()
        val callback  = Observable.Base(textCallback)

        repository.getText(callback)
        val actual = textCallback.text
        assertEquals("initial data", actual)

    }

    @Test
    fun `test save data and start`(){
        val dataSource = FakeDataSource("")
        val repository = Repository.DataSource(dataSource)
        val textCallback = TestCallback()
        val callback  = Observable.Base(textCallback)
        repository.saveText("some data")
        repository.getText(callback)
        val actual = textCallback.text
        assertEquals("some data", actual)

    }

    @Test
    fun `test saved and clear data`(){
        val dataSource = FakeDataSource("")
        val repository = Repository.DataSource(dataSource)
        val textCallback = TestCallback()
        val callback  = Observable.Base(textCallback)

        repository.saveText("some data")
        repository.getText(callback)

        repository.saveText("")
        var actual = textCallback.text
        assertEquals("some data", actual)

        repository.getText(callback)
        actual = textCallback.text
        assertEquals("", actual)
    }

    private class TestCallback : TextCallback {
        var text = ""
        override fun updateText(str: String) {
            text = str
        }
    }
    private class FakeDataSource(data:String) : DataSource {

        var data: String = data

        override fun saveText(text: String) {
            data = text
        }

        override fun getText(): String =
            data
    }
}