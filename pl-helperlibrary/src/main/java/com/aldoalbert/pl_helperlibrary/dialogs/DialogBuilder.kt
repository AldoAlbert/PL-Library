package com.aldoalbert.pl_helperlibrary.dialogs

import android.content.Context
import com.aldoalbert.pl_helperlibrary.R

class DialogBuilder{
    private var c: Context

    constructor(c: Context){
        this.c = c
    }

    private fun makeDialog(title: String, message: String, type: Int): DefaultDialogFragment {
        return DefaultDialogFragment.newInstance(title, message, type)
    }

    private fun makeCustomDialog(title: String, message: String): CustomDialogFragment {
        return CustomDialogFragment.newInstance(title, message)
    }

    fun buildDialog(title: String, message: String): CustomDialogFragment? {
        return  makeCustomDialog(title, message)
    }

    fun buildSuccessDialog(title: String, message: String): DefaultDialogFragment? {
        return  makeDialog(title, message, DefaultDialogFragment.SUCCESS_TYPE)
    }

    fun buildCustomErrorDialog(title: String, message: String): DefaultDialogFragment? {
        return  makeDialog(title, message, DefaultDialogFragment.ERROR_TYPE)
    }

    fun buildErrorDialog(): DefaultDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_generico
        ), DefaultDialogFragment.ERROR_TYPE)
    }

    fun buildNetworkErrorDialog(): DefaultDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_intenet
        ), DefaultDialogFragment.ERROR_NETWORK_TYPE)
    }

    fun buildCardErrorDialog(): DefaultDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_procesar_tarjeta
        ), DefaultDialogFragment.ERROR_TYPE)
    }

    fun buildInvalidFilesDialog(): DefaultDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_archivos_vacios
        ), DefaultDialogFragment.ERROR_TYPE)
    }

    fun buildUnavalibleFilesDialog(): DefaultDialogFragment? {
        return makeDialog(c.getString(R.string.error_title), c.getString(
            R.string.error_archivos_faltantes
        ), DefaultDialogFragment.ERROR_TYPE)
    }

}