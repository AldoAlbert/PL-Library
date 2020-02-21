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
class CustomDialogFragment : DialogFragment() {

    private var title: String? = null
    private var message: String? = null

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

        val btnCancel = view.findViewById<View>(R.id.buttonCancel)
        val btnAccept = view.findViewById<View>(R.id.buttonAccept)

        val _tv_title = view.findViewById<View>(R.id.tv_title) as TextView
        _tv_title.text = title

        val _tv_message = view.findViewById<View>(R.id.tv_message) as TextView
        _tv_message.text = message

        val lottieAnimation = view.findViewById<View>(R.id.animation_view) as LottieAnimationView
        lottieAnimation.setAnimation(R.raw.check_animation)


        btnCancel.setOnClickListener {
            Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnAccept.setOnClickListener {
            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return view
    }

    companion object {


        /**
         * Create a new instance of CustomDialogFragment.
         */
        fun newInstance(title: String, message: String): CustomDialogFragment {
            val f = CustomDialogFragment()

            // Supply num input as an argument.
            val args = Bundle()
            args.putString("title", title)
            args.putString("message", message)
            f.arguments = args

            return f
        }
    }

}