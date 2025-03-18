package com.codewati.customedittext

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.codewati.abhiedittext.CodewatiET

class MainActivity : AppCompatActivity() {


    private lateinit var emailEditText: CodewatiET
    private lateinit var phoneEditText: CodewatiET
    private lateinit var panEditText: CodewatiET
    private lateinit var aadhaarEditText: CodewatiET
    private lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.emailEditText)
        phoneEditText = findViewById(R.id.phoneEditText)
        panEditText = findViewById(R.id.panEditText)
        aadhaarEditText = findViewById(R.id.aadhaarEditText)
        validateButton = findViewById(R.id.validateButton)

        // Use setMaxLength() for limiting the input length
        emailEditText.setMaxLength(50)
        phoneEditText.setMaxLength(10)
        panEditText.setMaxLength(10)
        aadhaarEditText.setMaxLength(12);

        // Use Enable Password Toggle for hiding the password
        panEditText.enablePasswordToggle()

        validateButton.setOnClickListener {
            if (emailEditText.isValidEmail() &&     // Use isValidEmail() for email validation
                phoneEditText.isValidPhone() &&     // Use isValidPhone() for phone number validation
                panEditText.isValidPan() &&         // Use isValidPan() for PAN validation
                aadhaarEditText.isValidAadhaar()) {     // Use isValidAadhaar() for Aadhaar validation

                Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()

            }
        }

    }
}