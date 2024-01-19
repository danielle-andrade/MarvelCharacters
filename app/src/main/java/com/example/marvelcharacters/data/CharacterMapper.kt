import com.example.marvelcharacters.data.CharacterResponse
import com.example.marvelcharacters.domain.Character

object CharacterMapper {

    fun toDomain(response: CharacterResponse) =
        with(response) {
            Character(
                id = id,
                name = name,
                description = description
            )
        }
}