package com.aldoalbert.pl_helperlibrary.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.airbnb.lottie.LottieAnimationView
import com.aldoalbert.pl_helperlibrary.R

/**
 * Created by Mobidroidtech on 3/14/2018.
 */
class DefaultDialogFragment : DialogFragment() {



    private var title: String? = null
    private var message: String? = null
    private var type : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString("title")
        message = arguments?.getString("message")

        val style = STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style, theme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_dialog, container, false)

        val _tv_title = view.findViewById<View>(R.id.tv_title) as TextView
        _tv_title.text = title

        val _tv_message = view.findViewById<View>(R.id.tv_message) as TextView
        _tv_message.text = message

        when (type) {
            SUCCESS_TYPE -> {
                val btnAccept = view.findViewById<View>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            ERROR_TYPE -> {
                val btnAccept = view.findViewById<View>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            ERROR_NETWORK_TYPE -> {
                val btnAccept = view.findViewById<View>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
            }
            WARNING_TYPE -> {
                val btnAccept = view.findViewById<View>(R.id.buttonAccept)
                btnAccept.setOnClickListener {
                    dismiss()
                }
                val btnCancel = view.findViewById<View>(R.id.buttonCancel)
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

        public val SUCCESS_TYPE = 1
        public val ERROR_TYPE = 2
        public val ERROR_NETWORK_TYPE = 3
        public val WARNING_TYPE = 4
        public val LOADING_TYPE = 5

        /**
         * Create a new instance of CustomDialogFragment.
         */
        fun newInstance(title: String, message: String, type: Int): DefaultDialogFragment {
            val f = DefaultDialogFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("title", title)
            args.putString("message", message)
            args.putInt("type", type)
            f.arguments = args

            return f
        }
    }

}