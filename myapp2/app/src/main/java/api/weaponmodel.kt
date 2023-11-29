package api

import com.google.gson.annotations.SerializedName

data class WeaponModel(
    @SerializedName("id_figura") var id:Int,
    @SerializedName("Nombre_animacion") var name:String,
    @SerializedName("nombre_personaje") var type:String,
)