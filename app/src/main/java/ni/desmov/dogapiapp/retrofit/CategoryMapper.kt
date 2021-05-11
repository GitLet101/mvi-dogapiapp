package ni.desmov.dogapiapp.retrofit
import ni.desmov.dogapiapp.model.Categories
import ni.desmov.dogapiapp.model.Dog
import ni.desmov.dogapiapp.utils.EntityMapper
import javax.inject.Inject

class CategoryMapper
    @Inject constructor(): EntityMapper <CategoryNetworkEntity, Categories>{
        override fun mapFromEntity(entity: CategoryNetworkEntity): Categories {
            return Categories(
                id = entity.id,
                name = entity.name
            )
        }

    override fun mapToEntity(domainModel: Categories): CategoryNetworkEntity {
        return CategoryNetworkEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<CategoryNetworkEntity>): List<Categories>{
        return entities.map { mapFromEntity(it) }
    }
}