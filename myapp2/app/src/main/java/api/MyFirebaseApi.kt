package api

import APPbasededatos.firebase.model.WeaponModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.Objects

interface MyFirebaseApi {
    @GET("app")
    fun getWeapons(): Call<Objects>

    @GET("app/{id}.json")
    fun getWeapon(@Path("id") id: Int): Call<WeaponModel>

    @POST("app.json")
    fun postWeapon(@Body weapon: WeaponModel?): Call<WeaponModel>
}