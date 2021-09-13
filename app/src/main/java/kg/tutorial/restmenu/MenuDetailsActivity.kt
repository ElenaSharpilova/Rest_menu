package kg.tutorial.restmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kg.tutorial.restmenu.databinding.ActivityMainBinding
import kg.tutorial.restmenu.databinding.ActivityMenuDetailsBinding

class MenuDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityMenuDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvItem.text = intent.getStringExtra("MenuTitle")
        binding.tvNameCountry.text = intent.getStringExtra("MenuNameCountry")
        binding.tvNameFood.text = intent.getStringExtra("MenuNameFood")
        binding.distanceDelivery.text = intent.getStringExtra("MenuDistanceDelivery")
        binding.imageView.setImageResource(intent.getStringExtra("MenuImageId")!!.toInt())

        val category = resources.getStringArray(R.array.category_dropmenu)
        val toolbarAdapter = ArrayAdapter(this, R.layout.dropdown_item_menu, category)
        with(binding.autoCompleteTextView){
            setAdapter(toolbarAdapter)
        }

        val mainMenu = resources.getStringArray(R.array.main_menu)
        val toolbarAdapter2 = ArrayAdapter(this, R.layout.dropdown_item_menu2, mainMenu)
        with(binding.autoCompleteTextView){
            setAdapter(toolbarAdapter2)
        }
    }
}