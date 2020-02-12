package com.aldoalbert.pl_helperlibrary

import android.content.Context
import android.view.View
import android.widget.EditText

import java.util.regex.Pattern

class EditTextValidator {

    private val EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])"
    private val LETTERS_SPACE = "^[a-zA-ZñÑáéíóúÁÉÍÓÚ\\s]+$"
    private val ONLY_NUMBERS = "^[0-9]+$"

    var isResult: Boolean = false
    var view: View? = null
    var c: Context?= null

    constructor(c: Context){
        this.c = c
        this.isResult = true
        this.view = null
    }

    fun showErrors() {
        view!!.requestFocus()
    }

    fun validate(): Boolean {
        if (!isResult) {
            view!!.requestFocus()
        }
        return isResult
    }

    private fun setView(e: EditText) {
        view = e
    }

    private fun setError(editText: EditText, error: String) {
        editText.error = error
        isResult = false
        setView(editText)
    }

    fun requiredField(editText: EditText) {
        editText.error = null
        if (editText.text.toString().isEmpty()) {
            c?.getString(R.string.error_campo_requerido)?.let { setError(editText, it) }
        }
    }

    fun validateOnlyLetters(editText: EditText) {
        editText.error = null
        if (!onlyLetters(editText.text.toString())) {
            c?.getString(R.string.error_solo_letras)?.let { setError(editText, it) }
        }
    }

    fun validateOnlyNumbers(editText: EditText) {
        editText.error = null
        if (!onlyNumbers(editText.text.toString())) {
            c?.getString(R.string.error_solo_numeros)?.let { setError(editText, it) }
        }
    }

    fun validateLength(editText: EditText, minLength: Int) {
        editText.error = null
        if (editText.text.toString().trim { it <= ' ' }.length < minLength) {
            c?.getString(R.string.error_caracteres_minimos, minLength)?.let { setError(editText, it) }
        }
    }

    fun validateEmail(ET_email: EditText) {
        if (!validateEmail(ET_email.text.toString())) {
            c?.getString(R.string.error_email_invalido)?.let { setError(ET_email, it) }
        }
    }

    fun validatePasswords(ET_contrasena: EditText, ET_confirmar_contrasena: EditText, min_long: Int) {
        ET_contrasena.error = null
        ET_confirmar_contrasena.error = null
        if (ET_contrasena.length() < min_long) {
            c?.getString(R.string.error_longitud_contrasena, min_long)?.let { setError(ET_contrasena, it) }
        } else if (ET_contrasena.text.toString() != ET_confirmar_contrasena.text.toString()) {
            c?.getString(R.string.error_las_contraseñas_no_coinciden)?.let { setError(ET_confirmar_contrasena, it) }
        }

    }

    fun validateTelephone(editText: EditText, longitude: Int) {
        editText.error = null
        if (!(editText.text.toString().length == longitude)) {
            c?.getString(R.string.error_longitud_telefono)?.let { setError(editText, it) }
        } else if (!onlyNumbers(editText.text.toString())) {
            c?.getString(R.string.error_solo_numeros)?.let { setError(editText, it) }
        }

    }

    private fun onlyNumbers(string: String): Boolean {
        val pattern = Pattern.compile(ONLY_NUMBERS)
        val matcher = pattern.matcher(string)
        return matcher.matches()
    }

    private fun onlyLetters(string: String): Boolean {
        val pattern = Pattern.compile(LETTERS_SPACE)
        val matcher = pattern.matcher(string)
        return matcher.matches()
    }

    private fun validateEmail(email: String): Boolean {
        val pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

}