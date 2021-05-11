package ni.desmov.dogapiapp.retrofit

import ni.desmov.dogapiapp.model.Dog
import ni.desmov.dogapiapp.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<DogNetworkEntity, Dog> {
    override fun mapFromEntity(entity: DogNetworkEntity): Dog {
        return Dog(
            id = entity.id,
            url = entity.url,
            height = entity.height,
            width = entity.width
        )
    }

    override fun mapToEntity(domainModel: Dog): DogNetworkEntity {
        return DogNetworkEntity(
            id = domainModel.id,
            url = domainModel.url,
            height = domainModel.height,
            width = domainModel.width
        )
    }

    fun mapFromEntityList(entities: List<DogNetworkEntity>): List<Dog>{
        return entities.map { mapFromEntity(it) }
    }
}