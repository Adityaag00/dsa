import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;

public class SaavanLoginTest {
    public static void main(String[] args) {
        for (int i = 1; i <=3; i++) {
            RestTemplate restTemplate = new RestTemplate();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
            restTemplate.getMessageConverters().add(0, converter);
            String url1="https://gimmeproxy.com/api/getProxy";
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            ResponseEntity<Root> rootResponseEntity = restTemplate.getForEntity(url1,Root.class);
            System.out.println(rootResponseEntity.getBody());
//            String url = "https://www.jiosaavn.com/api.php?__call=user.login&api_version=4&_format=json&_marker=0&ctx=web6dot0";
//
//            MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//            map.add("username", "kemlucemla@biyac.com");
//            map.add("password","$fv6ZDtfm2Lct$B");
//
//            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, httpHeaders);
//
//            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,request,String.class);
//            HttpHeaders headers = responseEntity.getHeaders();
//            System.out.println(i);
//            System.out.println(responseEntity.toString());
        }
    }
}
