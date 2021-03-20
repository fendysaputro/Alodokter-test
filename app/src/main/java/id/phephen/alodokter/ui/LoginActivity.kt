package id.phephen.alodokter.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.phephen.alodokter.R
import id.phephen.alodokter.databinding.ActivityLoginBinding
import id.phephen.alodokter.viewmodel.UserViewModel


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var viewModel: UserViewModel
    lateinit var strEmail: String
    lateinit var strPassword: String

    val CUSTOM_PREF_NAME = "User_data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
        checkStatusLogin()
        initView()
        onBtnLoginClicked()
    }

    private fun initialize () {
        supportActionBar!!.hide()
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
    }

    private fun initView() {
        etEmail = binding.etEmail
        etPassword = binding.etPassword
        btnLogin = binding.btnLogin
    }

    private fun onBtnLoginClicked () {
        btnLogin.setOnClickListener {
            strEmail = etEmail.text.toString().trim()
            strPassword = etPassword.text.toString().trim()
            if (strEmail.isEmpty() || strPassword.isEmpty()) {
                Toast.makeText(this, getString(R.string.txt_error_empty), Toast.LENGTH_SHORT).show()
            } else {
                viewModel.insertData(this, name = "fendy", strEmail, strPassword, phone = "085649774328")
                val sharedPreference =  getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()
                editor.putBoolean("isLogin", true)
                editor.putString("name", "fendy")
                editor.putString("email", strEmail)
                editor.putString("password", strPassword)
                editor.putString("phone", "085649774328")
                editor.apply()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun checkStatusLogin () {
        val loginPreferences = getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE)
        if (loginPreferences.contains("email")) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT))
        }
    }
}