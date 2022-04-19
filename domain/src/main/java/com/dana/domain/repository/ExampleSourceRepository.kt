
import com.dana.domain.datasource.ExampleDataSource
import id.co.binar.data.base.BaseRepository

class ExampleSourceRepository(private val factory: ExampleDataSource.Factory): BaseRepository {
//    override suspend fun getExample(exampleId: String): BaseData = factory.network.getExample(exampleId)
}