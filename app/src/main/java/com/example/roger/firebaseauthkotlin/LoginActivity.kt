package com.example.roger.firebaseauthkotlin

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var loginButton: Button
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var registerButtton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        email = findViewById(R.id.email) as EditText
        password = findViewById(R.id.password) as EditText
        loginButton = findViewById(R.id.loginButton) as Button
        registerButtton = findViewById(R.id.registerButton) as Button

        registerButtton.setOnClickListener{
            val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
            startActivity(intent)
        }

        loginButton.setOnClickListener{
            auth = FirebaseAuth.getInstance()
            auth.signInWithEmailAndPassword(email.text.toString(), password.text.toString()).
            addOnCompleteListener { task: Task<AuthResult> ->
                val intentToMain = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intentToMain)
            }

        }
    }
}