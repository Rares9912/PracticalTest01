package ro.pub.cs.systems.eim.practicaltest01

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ro.pub.cs.systems.eim.practicaltest01.Constants.INPUT_2
import ro.pub.cs.systems.eim.practicaltest01.Constants.INPUT_1

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_main)

        val input1 = findViewById<EditText>(R.id.input1)
        val input2 = findViewById<EditText>(R.id.input2)
        input1.setText("0")
        input2.setText("0")
        val button = findViewById<Button>(R.id.press_me_btn)
        button.setOnClickListener{
            val sum = input1.text.toString().toInt() + 1;
            input1.setText(sum.toString())

        }

        val button2 = findViewById<Button>(R.id.press_me_too_btn)
        button2.setOnClickListener{
            val sum = input2.text.toString().toInt() + 1;
            input2.setText(sum.toString())
        }

        val activityResultsLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Result OK GG", Toast.LENGTH_LONG).show()

            } else if (result.resultCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "Result BAD", Toast.LENGTH_LONG).show()
            }
        }

        val navigateToSecondaryActivityButton = findViewById<Button>(R.id.navigate_btn)
        navigateToSecondaryActivityButton.setOnClickListener{
            val intent = Intent(this, PracticalTest01SecondaryActivity::class.java)
            intent.putExtra(INPUT_1, input1.text.toString())
            intent.putExtra(INPUT_2, input2.text.toString())
            activityResultsLauncher.launch(intent)
        }



    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putString(INPUT_1, findViewById<EditText>(R.id.input1).text.toString())
        outState.putString(INPUT_2, findViewById<EditText>(R.id.input2).text.toString())


    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        if (savedInstanceState.containsKey(INPUT_1) && savedInstanceState.containsKey(INPUT_2)) {
            findViewById<EditText>(R.id.input1).setText(savedInstanceState.getString(INPUT_1))
            findViewById<EditText>(R.id.input2).setText(savedInstanceState.getString(INPUT_2))
        }

    }
}