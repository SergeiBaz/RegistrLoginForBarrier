package com.example.registrloginforbarrier

import Constance
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.registrloginforbarrier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding
    private var login = "empty"
    private var password = "empty"
    private var name = "empty"
    private var houseNumber = "empty"
    private var apartmentNumber = "empty"
    private var phone = "empty"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == Constance.REQUEST_SING_IN){

            val log = data?.getStringExtra(Constance.LOGIN)
            val pas = data?.getStringExtra(Constance.PASSWORD)

            if (login == log && pas == password){

                bindingClass.imageBarrier.setImageResource(R.drawable._81)
                bindingClass.textGreetings.text = (getString(R.string.welcome) + " $name")
                bindingClass.bOpen.visibility = View.VISIBLE
                bindingClass.bSingIn.text = getString(R.string.exit)
                bindingClass.bSingUp.visibility = View.GONE

            }else{

                bindingClass.imageBarrier.setImageResource(R.drawable.eror_sign_in_up)
                bindingClass.textGreetings.text = getString(R.string.you_entered_incorrect_data)

            }

        }else if (requestCode == Constance.REQUEST_SING_UP){

            login = data?.getStringExtra(Constance.LOGIN)!!
            password = data.getStringExtra(Constance.PASSWORD)!!
            name = data.getStringExtra(Constance.NAME)!!
            houseNumber = data.getStringExtra(Constance.HOUSE_NUMBER)!!
            apartmentNumber = data.getStringExtra(Constance.APARTMENT_NUMBER)!!
            phone = data.getStringExtra(Constance.PHONE)!!

            bindingClass.imageBarrier.setImageResource(R.drawable._81)
            bindingClass.textGreetings.text = (getString(R.string.welcome) + " $name")
            bindingClass.bOpen.visibility = View.VISIBLE
            bindingClass.bSingIn.text = getString(R.string.exit)
            bindingClass.bSingUp.visibility = View.GONE


        }
    }

    fun onClickGoToSingIn(view: View){
        runIntent(Constance.SIGN_IN)
    }

    fun onClickGoToSingUp(view: View){
        runIntent(Constance.SIGN_UP)
    }

    private fun runIntent(const: String){

        if (const == Constance.SIGN_IN) {
            val intent = Intent(this,SingInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_IN)
            startActivityForResult(intent, Constance.REQUEST_SING_IN)
        }

        if (const == Constance.SIGN_UP){
            val intent = Intent(this, SingInUpAct::class.java)
            intent.putExtra(Constance.SIGN_STATE, Constance.SIGN_UP)
            startActivityForResult(intent, Constance.REQUEST_SING_UP)
        }

    }

    fun onClickCall(view: View){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:89159505044")
        startActivity(intent)
    }

}