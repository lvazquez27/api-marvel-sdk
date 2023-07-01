package mx.openpay.apimarvelsdk.Client;

import mx.openpay.apimarvelsdk.model.CharacterResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Component
public class MarvelApiClient {


    private final String PUBLIC_KEY;

    private final String PRIVATE_KEY;

    private final String BASE_URL;

    private final RestTemplate restTemplate = new RestTemplate();

    public MarvelApiClient(@Value("${marvel.public_key}") String public_key,
                           @Value("${marvel.private_key}") String private_key,
                           @Value("${marvel.base_url}") String base_url){
        this.PUBLIC_KEY = public_key;
        this.PRIVATE_KEY = private_key;
        this.BASE_URL = base_url;
    }

    public CharacterResponse listCharacters(){
        String endPoint = this.buildUrl("/characters");
        return restTemplate.getForObject(endPoint,CharacterResponse.class);
    }

    public CharacterResponse getCharacterById(Integer characterId){
        String endPoint = this.buildUrl("/characters/" + characterId);
        return restTemplate.getForObject(endPoint,CharacterResponse.class);
    }

    private String buildUrl(String path){
        Long ts = new Date().getTime();
        String hash = this.generateHash(ts);
        String queryParams = "?apikey=" + PUBLIC_KEY + "&ts="+ ts + "&hash=" + hash;
        return BASE_URL + path + queryParams;
    }

    private String generateHash(Long ts){
        String textHash = ts + PRIVATE_KEY + PUBLIC_KEY;
        return DigestUtils.md5DigestAsHex(textHash.getBytes());
    }

}
