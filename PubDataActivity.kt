package com.example.pubhub.activities

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.pubhub.R
import com.example.pubhub.database.PubHubDatabase
import com.example.pubhub.database.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PubDataActivity : AppCompatActivity() {
    private lateinit var profileImageView: ImageView
    private lateinit var usernameEditText: EditText
    private lateinit var dobEditText: EditText
    private lateinit var descriptionEditText: EditText
    private var selectedImageUri: Uri? = null

    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pub_data_activity)

        profileImageView = findViewById(R.id.profileImage)
        usernameEditText = findViewById(R.id.usernameEditText)
        dobEditText = findViewById(R.id.dobEditText)
        descriptionEditText = findViewById(R.id.descriptionEditText)
        val selectImageButton: Button = findViewById(R.id.selectImageButton)
        val submitButton: Button = findViewById(R.id.submitButton)

        selectImageButton.setOnClickListener {
            openImagePicker()
        }

        submitButton.setOnClickListener {
            saveUserData()
        }
    }

    private fun openImagePicker() {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            type = "image/*"
            addCategory(Intent.CATEGORY_OPENABLE)
        }
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            data?.data?.let { uri ->
                selectedImageUri = uri
                contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION
                )

                // Display the image using Glide
                Glide.with(this)
                    .load(uri)
                    .into(profileImageView)
            }
        }
    }

    private fun saveUserData() {
        val username = usernameEditText.text.toString().trim()
        val dob = dobEditText.text.toString().trim()
        val description = descriptionEditText.text.toString().trim()

        if (username.isNotEmpty() && dob.isNotEmpty() && description.isNotEmpty() && selectedImageUri != null) {
            val user = User(
                id = 0,
                username = username,
                dob = dob,
                description = description,
                profileImageUri = selectedImageUri.toString() // Save URI as a string
            )

            // Insert the user data into the database
            lifecycleScope.launch(Dispatchers.IO) {
                PubHubDatabase.getDatabase(this@PubDataActivity).userDao().insertUser(user)
                runOnUiThread {
                    Toast.makeText(this@PubDataActivity, "User saved successfully", Toast.LENGTH_SHORT).show()
                    finish() // Close the activity after saving
                }
            }
        } else {
            Toast.makeText(this, "Please fill in all fields and select an image", Toast.LENGTH_SHORT).show()
        }
    }
}


