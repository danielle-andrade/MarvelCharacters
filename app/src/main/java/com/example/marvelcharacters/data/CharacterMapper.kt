import com.example.marvelcharacters.data.CharResponse
import com.example.marvelcharacters.data.CharacterData
import com.example.marvelcharacters.data.CharacterResponse
import com.example.marvelcharacters.domain.Character

object CharacterMapper {

//    fun toDomainChar() =
//        Character(
//            id = response.id,
//            name = response.name,
//            description = response.description,
//        )

    fun toDomainData(response: CharacterResponse) =
        CharacterData(
            results = response.data.results
        )
}
