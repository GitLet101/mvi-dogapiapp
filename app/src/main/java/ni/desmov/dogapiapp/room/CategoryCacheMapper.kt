package ni.desmov.dogapiapp.room;

import ni.desmov.dogapiapp.utils.EntityMapper
import ni.desmov.dogapiapp.model.Categories
import javax.inject.Inject

class CategoryCacheMapper
@Inject constructor():
    EntityMapper<CategoryCacheEntity, Categories> {
    override fun mapFromEntity(entity: CategoryCacheEntity): Categories {
        return Categories(
            id = entity.id,
            name = entity.name
        )
    }

    override fun mapToEntity(domainModel: Categories): CategoryCacheEntity {
        return CategoryCacheEntity(
            id = domainModel.id,
            name = domainModel.name
        )
    }

    fun mapFromEntityList(entities: List<CategoryCacheEntity>): List<Categories>{
        return entities.map { mapFromEntity(it) }
    }
}
