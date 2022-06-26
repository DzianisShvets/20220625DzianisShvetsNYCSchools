package com.example.nycschools.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.nycschools.R
import com.example.nycschools.home.viewmodel.SchoolInfoViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_school_info.*

class SchoolInfoActivity : AppCompatActivity() {

    private lateinit var vm: SchoolInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_school_info)

        val intent = intent
        val dbn = intent.getStringExtra("dbn")

        vm = ViewModelProvider(this)[SchoolInfoViewModel::class.java]

        vm.fetchSchoolInfo(dbn.toString())

        vm.schoolInfoModelLiveData?.observe(this, Observer {
            if (it!=null){
//                rv_home.visibility = View.VISIBLE
//                adapter.setData(it as SchoolInfoViewModel)
                if(!it?.isEmpty() == true){
                    school_name_TV.setText("" + it[0].school_name)
                    reading_avg_score_TV.setText("" + it[0].sat_critical_reading_avg_score)
                }else{
                    showToast("No data for this school")
                }
            }else{
                showToast("Something went wrong")
            }
            progress_school_info.visibility = View.GONE
        })

    }

    private fun showToast(msg:String){
        Toast.makeText(this,msg, Toast.LENGTH_SHORT).show()
    }

}