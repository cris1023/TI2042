package api

import api.WeaponModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class firebaseApiAdapter {
    class MyFirebaseApiAdapter {
        var URL_BASE = "https://app-base-de-datos-89c59-default-rtdb.firebaseio.com/myapp"
        var firebaseApi = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getWeapons(): ArrayList<WeaponModel>? {
            var call =
                firebaseApi.create(api::class.java).getWeapons().execute()
            val data = arrayListOf<WeaponModel>();
            println(call.body().toString())
            return data
        }

        fun getWeapon(id: Int): WeaponModel? {
            var call =
                firebaseApi.create(api::class.java).getWeapon(id).execute()
            return call.body()
        }

        fun postWeapon(weapon: WeaponModel): Boolean {
            var call =
                firebaseApi.create(api::class.java).postWeapon(weapon).execute()
            return call.body() != null
        }
    }
}