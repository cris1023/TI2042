package api.respon

import com.google.gson.annotations.SerializedName

data class weaponResponse(
    @SerializedName("id_figura") var id:Int,
    @SerializedName("Nombre_animacion") var name:String,
    @SerializedName("nombre_personaje") var type:String,
)
