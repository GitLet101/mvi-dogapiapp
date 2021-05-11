package ni.desmov.dogapiapp.retrofit

import retrofit2.http.GET

interface DogRetrofit {
     @GET("search")
     suspend fun get(): List<DogNetworkEntity>

     @GET("categories")
     suspend fun get_categories(): List<CategoryNetworkEntity>
}