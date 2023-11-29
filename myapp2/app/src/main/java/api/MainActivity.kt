package api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    private var myFirebaseApi = firebaseApiAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        runBlocking {
            var weapons = retrieveWeapons()
            println("${weapons?.size} weapons are stored!")

            var weapon = retrieveWeapon()
            println("Weapon found: ${weapon}")

            var newWeapon = WeaponModel()
            var result = saveWeapon(newWeapon)
            println("New weapon saved!")
        }
    }

    private suspend fun retrieveWeapons(): ArrayList<WeaponModel>? {
        println("Calling Service")
        val callingResponse = GlobalScope.async(Dispatchers.IO) {
            MyFirebaseApi()
        }
        println("Waiting Response")
        val weapons = callingResponse.await()
        println("Done!")
        return weapons
    }

    private suspend fun retrieveWeapon(id: Int): WeaponModel? {
        println("Calling Service")
        val callingResponse = GlobalScope.async(Dispatchers.IO) {
            MyFirebaseApi(id)
        }
        println("Waiting Response")
        val weapon = callingResponse.await()
        println("Done!")
    }

    private suspend fun saveWeapon(weapon: WeaponModel) {
        println("Calling Service")
        val callingResponse = GlobalScope.async(Dispatchers.IO) {
            MyFirebaseApi = (weapon)
        }
        println("Waiting Response")
        val id = callingResponse.await()
        println("Done!")
    }
}