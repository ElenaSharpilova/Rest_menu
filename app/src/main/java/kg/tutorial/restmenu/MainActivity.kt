package kg.tutorial.restmenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kg.tutorial.restmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MyAdapter.OnMenuItemClickListener {
    lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val streets = resources.getStringArray(R.array.street_location)
        val toolbarAdapter = ArrayAdapter(this, R.layout.toolbar_location, streets)
        with(binding.autoCompleteTextView){
            setAdapter(toolbarAdapter)
        }
        setup()
    }

    private fun setup() {
        binding.rvMenu.layoutManager = LinearLayoutManager(this)
        myAdapter = MyAdapter(this)
        binding.rvMenu.adapter = myAdapter
        myAdapter.setItems(Data.getLongListOfItems())
    }

    override fun onItemClick(item: Item, position: Int) {
        //Toast.makeText(this, item.title, Toast.LENGTH_LONG).show()
        val intent = Intent(this, MenuDetailsActivity::class.java)
        intent.putExtra("MenuTitle", item.title)
        intent.putExtra("MenuNameCountry", item.nameCountry)
        intent.putExtra("MenuNameFood", item.nameFood)
        intent.putExtra("MenuImageId", item.imageId.toString())
        intent.putExtra("MenuDistanceDelivery", item.distanceDelivery)
        startActivity(intent)
    }

}