package test.running.weather.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import test.running.weather.domain.WeatherDataRepository;
import test.running.weather.web.dto.dataCraw.PlaceDto;
import test.running.weather.web.dto.dataCraw.RootDto;

@RequiredArgsConstructor
@Service
@Component
public class WeatherPlaceService {
    private final WeatherDataRepository weatherDataRepository;

    public List<PlaceDto> placeList(String courseId) {
        StringBuilder sb = new StringBuilder();
        Gson gson = new Gson();
        try {
            String uri = "http://apis.data.go.kr/1360000/TourStnInfoService/getTourStnVilageFcst?serviceKey=406lrJVRiqLfSp8HVHaLUY%2Bo3a%2F1DtuHUz%2Fs9waJGTnvPuodbdMnS9eCCmMQFvRJUakGRGcnSaYJtm27C8IcjQ%3D%3D&pageNo=1&numOfRows=10&dataType=JSON&CURRENT_DATE=2019122010&HOUR=24&COURSE_ID="
                    + courseId;
            URL url = new URL(uri);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));

            String returnLine;

            while ((returnLine = br.readLine()) != null) {
                sb.append(returnLine);
            }
            RootDto dto = gson.fromJson(sb.toString(), RootDto.class);

            List<PlaceDto> rList = dto.getResponse().getBody().getItems().getItem();

            // System.out.println(sb.toString());
            return rList;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
