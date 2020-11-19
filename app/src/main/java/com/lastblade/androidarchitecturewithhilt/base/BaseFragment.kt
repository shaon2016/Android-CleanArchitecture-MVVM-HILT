package com.ujala.dukaan.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lastblade.androidarchitecturewithhilt.base.Task
import com.lastblade.androidarchitecturewithhilt.util.D
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
abstract class BaseFragment : Fragment(), Task {
    private val pbDialog by lazy {
        D.showProgressDialog(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewRelatedTask()
    }

    fun showProgressing(cancelable: Boolean = false) {
        pbDialog.setCancelable(cancelable)
        pbDialog.show()
    }

    fun hideProgressing() {
        if (pbDialog.isShowing) pbDialog.dismiss()
    }
}