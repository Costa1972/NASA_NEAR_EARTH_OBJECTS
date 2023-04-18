package ru.costa.nasa_near_earth_objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.costa.nasa_near_earth_objects.service.UrlService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Util {
    private static final String URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=K4WzXwpgu7KcXA8MNsq2q35K2KODztG4J73ZZkNR";
    private static final String FILE_PATH = "C:\\Users\\costa\\Desktop\\NASA\\CURIOSITY\\";
    private static final ObjectMapper MAPPER = new ObjectMapper();
    public UrlService urlService;

    @Autowired
    public Util(UrlService urlService) {
        this.urlService = urlService;
    }


    private CloseableHttpClient httpClient() {
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();
    }

    @Bean
    private CloseableHttpResponse httpResponse() throws IOException {
        return httpClient().execute(new HttpGet(URL));
    }


    public PhotoObject jsonToObject() throws IOException {
        return MAPPER.readValue(httpResponse().getEntity().getContent(), PhotoObject.class);
    }


    @Bean
    private List<String> photosUrl() throws IOException {
        List<String> urls = new ArrayList<>();
        jsonToObject().photos.forEach(photo -> urls.add(photo.getImg_src()));
        return urls;
    }


    public List<String> getFileName() {
        List<String> urls = urlService.getAll().stream().map(value -> value.getPhotosUrl()).collect(Collectors.toList());
        return urls.stream().map(value -> value.split("/")).map(arr -> arr[arr.length -1]).collect(Collectors.toList());
//        Url[] urls = urlService.getAll().toArray(Url[]::new);
//        for (Url u : urls) {
//            String fileName = Arrays.stream(u.getPhotosUrl().split("/")).reduce((a, b) -> b).orElse(null);
//            System.out.println(fileName);
//        }
    }

    @Bean
    private void pasteUrlToBD() throws IOException {
        for (String s : photosUrl()) {
            if (!urlService.existsByUrl(s)) {
                Url url = Url.builder()
                        .photosUrl(s)
                        .build();
                urlService.add(url);
            }
        }
    }




    @Bean
    private void printInfo() throws IOException {
        for (String s : getFileName()) {
            System.out.println(s);
        }
    }
}
