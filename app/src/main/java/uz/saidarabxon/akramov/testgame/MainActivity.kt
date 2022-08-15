package uz.saidarabxon.akramov.testgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var javob = 0

    var random1 = 0
    var random2 = 0
    var random3 = 0

    var inputJavob = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        random()

        btn_1.setOnClickListener {inputJavob = btn_1.text.toString().toInt() }
        btn_2.setOnClickListener {inputJavob = btn_2.text.toString().toInt() }
        btn_3.setOnClickListener {inputJavob = btn_3.text.toString().toInt() }
        btn_4.setOnClickListener {inputJavob = btn_4.text.toString().toInt() }

        btn_next.setOnClickListener {

            if (inputJavob == javob)
                Toast.makeText(this, "to'gri", Toast.LENGTH_SHORT).show()
            else Toast.makeText(this, "noto'gri", Toast.LENGTH_SHORT).show()

            random()

        }




    }

    private fun random() {

        var level = 30
        var number1 = Random().nextInt(level)
        var number2 = Random().nextInt(level)

        var amal = Random().nextInt(4)

        when (amal) {
            0 -> {
                tv_misol.text = "$number1 + $number2="
                javob = number1 + number2
            }
            1 -> {

                tv_misol.text = "$number1 - $number2="
                javob = number1 - number2
            }
            2 -> {
                tv_misol.text = "$number1 * $number2="
                javob = number1 * number2
            }
            3 -> {
                try {
                    if (number1 % number2 != 0) throw Exception()

                    tv_misol.text = "$number1 / $number2="
                    javob = number1 / number2
                } catch (e: Exception) {
                    random()
                }

            }
        }
        radEkranYoz()

    }

    fun randomSonAniqla() {
        random1 = Random().nextInt(20)
        random2 = Random().nextInt(20)
        random3 = Random().nextInt(20)

        if (random1 == random2 || random2 == random3 || random3 == random1) {
            randomSonAniqla()

        }

    }

    fun radEkranYoz() {
        var tj = Random().nextInt(4)
        randomSonAniqla()

        when (tj) {
            0 -> {
                btn_1.text = javob.toString()
                btn_2.text = random1.toString()
                btn_3.text = random2.toString()
                btn_4.text = random3.toString()
            }
            1 -> {
                btn_1.text = random1.toString()
                btn_2.text = javob.toString()
                btn_3.text = random2.toString()
                btn_4.text = random3.toString()
            }
            2 -> {
                btn_1.text = random1.toString()
                btn_2.text = random2.toString()
                btn_3.text = javob.toString()
                btn_4.text = random3.toString()
            }
            3 -> {
                btn_1.text = random1.toString()
                btn_2.text = random2.toString()
                btn_3.text = random3.toString()
                btn_4.text = javob.toString()
            }
        }

    }
}