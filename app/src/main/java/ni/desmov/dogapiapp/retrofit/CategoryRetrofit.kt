package ni.desmov.dogapiapp.retrofit

import retrofit2.http.GET

interface CategoryRetrofit {
    @GET("search")
    suspend fun get(): List<CategoryNetworkEntity>
}