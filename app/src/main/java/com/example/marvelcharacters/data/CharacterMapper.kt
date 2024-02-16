import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse

object CharacterMapper {

    fun toDomainData(response: CharacterResponse) =
        CharacterData(
            results = response.data.results
        )
}
