package ni.desmov.dogapiapp.retrofit
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CategoryNetworkEntity(
    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("name")
    @Expose
    var name: String
)