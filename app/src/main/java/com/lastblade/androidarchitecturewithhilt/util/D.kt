package com.lastblade.androidarchitecturewithhilt.util


import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.lastblade.androidarchitecturewithhilt.R
import kotlinx.android.synthetic.main.dialog_progress.view.*

object D {



    fun showProgressDialog(
        context: Context,
        msg: String = context.getString(R.string.please_wait),
        isCancelable: Boolean = false
    ): Dialog {

        val v = View.inflate(context, R.layout.dialog_progress, null)

        val d = Dialog(context, R.style.Theme_AppCompat_Dialog_Alert)
        d.setContentView(v)
        d.setCancelable(isCancelable)

        v.tvMsg.text = msg

        return d
    }

    fun simplePositiveNegativeActionDialog(
        context: Context,
        msg: String,
        isCancelable: Boolean = true,
        positiveHandler: ((dialog: DialogInterface) -> Unit)? = null,
        negativeHandler: ((dialog: DialogInterface) -> Unit)? = null
    ) {
        AlertDialog.Builder(context)
            .setMessage(msg)
            .setCancelable(isCancelable)
            .setPositiveButton(
                context.getString(R.string.ok)
            ) { dialog, which ->
                positiveHandler?.let { it(dialog) }
            }
            .setNegativeButton(context.getString(R.string.cancel)) { dialog, which ->
                negativeHandler?.let { it(dialog) }
            }
            .create()
            .show()
    }

    fun showSnackLongMsg(activity: Activity, message: String) {
        try {
            Snackbar.make(
                activity.findViewById(android.R.id.content), message,
                Snackbar.LENGTH_LONG
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    fun showSnackInfiniteMsg(activity: Activity, message: String) {
        try {
            Snackbar.make(
                activity.findViewById(android.R.id.content), message,
                Snackbar.LENGTH_INDEFINITE
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

