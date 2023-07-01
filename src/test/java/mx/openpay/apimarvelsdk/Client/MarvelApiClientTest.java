package mx.openpay.apimarvelsdk.Client;

import mx.openpay.apimarvelsdk.model.CharacterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarvelApiClientTest {

    private MarvelApiClient mc;

    @Value("${marvel.public_key}")
    private String PUBLIC_KEY;

    @Value("${marvel.private_key}")
    private String PRIVATE_KEY;

    @Value("${marvel.base_url}")
    private String BASE_URL;

    @BeforeEach
    void setUp(){
        mc = new MarvelApiClient(PUBLIC_KEY, PRIVATE_KEY, BASE_URL);
    }

    @Test
    void listCharacters() {
        CharacterResponse response = mc.listCharacters();
        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals(200, response.getCode());
        assertTrue(response.getData().getResults().size() > 0);

    }

    @Test
    void getCharacterById() {
        CharacterResponse response = mc.getCharacterById(1010699);
        assertNotNull(response);
        assertNotNull(response.getData());
        assertEquals(200, response.getCode());
        assertEquals(1, response.getData().getResults().size());
    }
}