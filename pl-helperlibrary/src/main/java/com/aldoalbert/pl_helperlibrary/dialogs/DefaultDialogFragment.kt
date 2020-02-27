package com.aldoalbert.pl_helperlibrary.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.airbnb.lottie.LottieAnimationView
import com.aldoalbert.pl_helperlibrary.R

/**
 * Created by Mobidroidtech on 3/14/2018.
 */
class DefaultDialogFragment : DialogFragment() {

    private val title: String by lazy { arguments!!.getString(ARG_TITLE, "") }
    private val message: String by lazy { arguments!!.getString(ARG_MESSAGE, "") }
    private val type : Int by lazy { arguments!!.getInt(ARG_TYPE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val style = STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style, theme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(type, container, false)

        val _tv_title = view.findViewById<TextView>(R.id.tv_title)
        _tv_title.text = title

        val _tv_message = view.findViewById<TextView>(R.id.tv_message)
        _tv_message.text = message

        when (type) {
            SUCCESS_TYPE -> {
                val btnAccept = view.findViewById<Button>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            ERROR_TYPE -> {
                val btnAccept = view.findViewById<Button>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            ERROR_NETWORK_TYPE -> {
                val btnAccept = view.findViewById<Button>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            WARNING_TYPE -> {
                val btnAccept = view.findViewById<Button>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
                val btnCancel = view.findViewById<Button>(R.id.buttonCancel)
                btnCancel.setOnClickListener {
                    dismiss()
                }
            }
            LOADING_TYPE -> {

            }
            else -> { }
        }

        return view
    }

    companion object {

        val SUCCESS_TYPE = R.layout.layout_success_dialog
        val ERROR_TYPE = R.layout.layout_error_dialog
        val ERROR_NETWORK_TYPE = R.layout.layout_error_network_dialog
        val WARNING_TYPE = R.layout.layout_warning_dialog
        val LOADING_TYPE = R.layout.layout_loading_dialog

        const val ARG_TITLE = "title"
        const val ARG_MESSAGE= "message"
        const val ARG_TYPE = "type"

        /**
         * Create a new instance of CustomDialogFragment.
         */
        fun newInstance(title: String, message: String, type: Int): DefaultDialogFragment {
            val f = DefaultDialogFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString(ARG_TITLE, title)
            args.putString(ARG_MESSAGE, message)
            args.putInt(ARG_TYPE, type)
            f.arguments = args

            return f
        }
    }

}