package com.lastblade.androidarchitecturewithhilt.base

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.lastblade.androidarchitecturewithhilt.R
import com.lastblade.androidarchitecturewithhilt.util.MyProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity(), Task {

    private val progressDialog by lazy { MyProgressDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewRelatedTask()
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        this.overridePendingTransition(R.anim.activity_in, R.anim.activity_out)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.overridePendingTransition(R.anim.activity_in_back, R.anim.activity_out_back)
    }

    fun showToast(context: Context, message: String) {
        val toast = Toast(context)
        toast.duration = Toast.LENGTH_LONG

        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.custom_toast_layout, null)

        val toastText = view.findViewById<TextView>(R.id.toastText)
        toastText.text = message

        toast.view = view
        toast.show()
    }

    fun snacksbarView(context: Context, view: View, message: String, flag: Boolean) {
        if (flag) {
            val snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_INDEFINITE)
            snackbar.show()
        } else if (!flag) {
            val snackbar = Snackbar
                .make(view, message, Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }

    fun showProgressing(cancelable: Boolean) {
        progressDialog.setCancelable(cancelable)
        progressDialog.show()
    }

    fun hideProgressing() {
        if (progressDialog.isShowing) progressDialog.dismiss()
    }
}

interface Task {
    fun viewRelatedTask()
}