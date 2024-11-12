package ro.pub.cs.systems.eim.practicaltest01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PracticalTest01SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_secondary)

        val displaySum = findViewById<TextView>(R.id.button_presses)
        val input1 = intent.getStringExtra(Constants.INPUT_1)
        val input2 = intent.getStringExtra(Constants.INPUT_2)

        val suma = Integer.valueOf(input1) + Integer.valueOf(input2)
        displaySum.setText(suma.toString())

        val okButton = findViewById<Button>(R.id.OK_btn)
        okButton.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }

        val cancelButton = findViewById<Button>(R.id.CANCEL_btn)
        cancelButton.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }



    }
}