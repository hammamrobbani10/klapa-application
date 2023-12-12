package com.example.klapa.view.signup

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.example.klapa.R
import com.example.klapa.databinding.ActivityLoginBinding
import com.example.klapa.databinding.ActivitySignUpBinding
import com.example.klapa.view.login.LoginActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
        playAnimation()

    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAGS_CHANGED,
                WindowManager.LayoutParams.FLAGS_CHANGED
            )
        }
        supportActionBar?.hide()

        binding.signupButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupAction() {
        binding.signupButton.setOnClickListener {
            val email = binding.email.text.toString()

            AlertDialog.Builder(this).apply {
                setTitle("Selamat!!!")
                setMessage("Akun $email Sudah Jadi , Anda Sekarang Sudah Bisa Login")
                setPositiveButton("Lanjut") { _, _ ->
                    finish()
                }
                create()
                show()
            }
        }
    }

    private fun playAnimation() {

        val title = ObjectAnimator.ofFloat(binding.loginText, View.ALPHA, 1f).setDuration(100)

        val nameEditTextLayout =
            ObjectAnimator.ofFloat(binding.username, View.ALPHA, 1f).setDuration(100)

        val emailEditTextLayout =
            ObjectAnimator.ofFloat(binding.email, View.ALPHA, 1f).setDuration(100)

        val passwordEditTextLayout =
            ObjectAnimator.ofFloat(binding.password, View.ALPHA, 1f).setDuration(100)
        val signup = ObjectAnimator.ofFloat(binding.signupButton, View.ALPHA, 1f).setDuration(100)


        AnimatorSet().apply {
            playSequentially(
                title,
                nameEditTextLayout,
                emailEditTextLayout,
                passwordEditTextLayout,
                signup
            )
            startDelay = 100
        }.start()
    }


}