package test.running.weather.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import test.running.weather.domain.WeatherDataRepository;
import test.running.weather.service.WeatherPlaceService;
import test.running.weather.web.dto.dataCraw.PlaceDto;
import test.running.weather.web.dto.dataCraw.RootDto;

@RequiredArgsConstructor
@Controller
public class WeatherController {
    private final WeatherDataRepository weatherDataRepository;
    private final WeatherPlaceService weatherPlaceService;

    @GetMapping("/")
    public String listPlace(@RequestParam(defaultValue = "0") Integer page, Model model) {
        return "page/main";
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET, produces = "application/json; charset=UTF8")
    public String jsonList(@PathVariable String courseId, Model model) {
        model.addAttribute("Item", weatherPlaceService.placeList(courseId));
        return "page/find";
    }

}
