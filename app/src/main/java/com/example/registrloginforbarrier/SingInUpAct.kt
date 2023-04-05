package com.example.registrloginforbarrier

import Constance
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.registrloginforbarrier.databinding.ActivitySingInUpBinding

class SingInUpAct : AppCompatActivity() {
    private lateinit var bindingClass: ActivitySingInUpBinding
    private  var singState = "empty"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySingInUpBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
        singState = intent.getStringExtra(Constance.SIGN_STATE)!!
        goTO()
    }

    fun onClickEntry(view: View){

        if (bindingClass.edLogin.text.toString() != "" && bindingClass.edPassword.text.toString() != ""){
            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }

    fun onClickRegistration(view: View){

        if(bindingClass.edLogin.text.toString() != ""
            && bindingClass.edPassword.text.toString() != ""
            && bindingClass.edName.text.toString() != ""
            && bindingClass.edPhone.text.toString() != ""
            && bindingClass.edApartNum.text.toString() != ""
            && bindingClass.edHouseNum.text.toString() != "")
        {

            val intent = Intent()
            intent.putExtra(Constance.LOGIN, bindingClass.edLogin.text.toString())
            intent.putExtra(Constance.PASSWORD, bindingClass.edPassword.text.toString())
            intent.putExtra(Constance.NAME, bindingClass.edName.text.toString())
            intent.putExtra(Constance.PHONE, bindingClass.edPhone.text.toString())
            intent.putExtra(Constance.HOUSE_NUMBER, bindingClass.edHouseNum.text.toString())
            intent.putExtra(Constance.APARTMENT_NUMBER, bindingClass.edApartNum.text.toString())
            setResult(RESULT_OK, intent)
            finish()

        }
    }

    private fun goTO(){
        if (singState == Constance.SIGN_IN){

            bindingClass.edApartNum.visibility = View.GONE
            bindingClass.edHouseNum.visibility = View.GONE
            bindingClass.edApartNum.visibility = View.GONE
            bindingClass.edPhone.visibility = View.GONE
            bindingClass.bRegistr.visibility = View.GONE
            bindingClass.edName.visibility = View.GONE
            bindingClass.imageRegistr.visibility = View.GONE

        }

        if (singState == Constance.SIGN_UP){

            bindingClass.imageEmtry.visibility = View.GONE
            bindingClass.bEntry.visibility = View.GONE

        }
    }
}