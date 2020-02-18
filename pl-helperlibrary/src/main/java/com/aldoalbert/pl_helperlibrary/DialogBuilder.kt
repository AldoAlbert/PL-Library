package com.aldoalbert.pl_helperlibrary

import android.content.Context
import androidx.appcompat.app.AlertDialog

class DialogBuilder{
    private lateinit var c: Context

    constructor(c: Context){
        this.c = c
    }

    private fun makeDialog(title: String, message: String): AlertDialog? {
        val builder: AlertDialog.Builder? = c.let {
            AlertDialog.Builder(it)
        }
        builder?.setMessage(message)?.setTitle(title)
        val dialog: AlertDialog? = builder?.create()
        return dialog
    }

    fun buildDialog(title: String, message: String) {
        makeDialog(title, message)
    }

    fun buildErrorDialog() {
        makeDialog("", c.getString(R.string.error_generico))
    }

    fun buildNetworkErrorDialog() {
        makeDialog(c.getString(R.string.error_title), c.getString(R.string.error_intenet))
    }

    fun buildCardErrorDialog() {
        makeDialog(c.getString(R.string.error_title), c.getString(R.string.error_procesar_tarjeta))
    }

    fun buildInvalidFilesDialog() {
        makeDialog(c.getString(R.string.error_title), c.getString(R.string.error_archivos_vacios))
    }

    fun buildUnavalibleFilesDialog() {
        makeDialog(c.getString(R.string.error_title), c.getString(R.string.error_archivos_faltantes))
    }

}