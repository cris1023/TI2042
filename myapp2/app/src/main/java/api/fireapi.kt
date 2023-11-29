package api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.Obje

import cl.inacap.apps.APPbasededatos.firebase.model.WeaponModel

interface fireapi {

    interface MyFirebaseApi {
        @GET("myapp.json")
        fun getWeapons(): Call<Objects>

        @GET("myapp/{id}.json")
        fun getWeapon(@Path("id") id: Int): Call<WeaponModel>

        @POST("myapp.json")
        fun postWeapon(@Body weapon: WeaponModel?): Call<WeaponModel>
    }



}