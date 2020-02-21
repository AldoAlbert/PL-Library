package com.aldoalbert.pl_helperlibrary.dialogs

import android.content.Context
import com.aldoalbert.pl_helperlibrary.R

class DialogBuilder{
    private var c: Context

    constructor(c: Context){
        this.c = c
    }

    private fun makeDialog(title: String, message: String): CustomDialogFragment {
        return CustomDialogFragment.newInstance(title, message)
    }

    fun buildDialog(title: String, message: String): CustomDialogFragment? {
        return  makeDialog(title, message)
    }

    fun buildSuccessDialog(title: String, message: String): CustomDialogFragment? {
        return  makeDialog(title, message)
    }

    fun buildCustomErrorDialog(title: String, message: String): CustomDialogFragment? {
        return  makeDialog(title, message)
    }

    fun buildErrorDialog(): CustomDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_generico
        ))
    }

    fun buildNetworkErrorDialog(): CustomDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_intenet
        ))
    }

    fun buildCardErrorDialog(): CustomDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_procesar_tarjeta
        ))
    }

    fun buildInvalidFilesDialog(): CustomDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_archivos_vacios
        ))
    }

    fun buildUnavalibleFilesDialog(): CustomDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_archivos_faltantes
        ))
    }

}