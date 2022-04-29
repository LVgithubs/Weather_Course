package test.running.weather.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import test.running.weather.domain.WeatherData;
import test.running.weather.domain.WeatherDataRepository;
import test.running.weather.service.WeatherPlaceService;
import test.running.weather.web.dto.dataCraw.PlaceDto;
import test.running.weather.web.dto.dataCraw.ResponseDto;

@RequiredArgsConstructor
@Controller
public class WeatherController {
    private final WeatherDataRepository weatherDataRepository;
    private final WeatherPlaceService weatherPlaceService;

    @GetMapping("/")
    public String listPlace(@RequestParam(defaultValue = "0") Integer page, Model model) {
        List<WeatherData> totalList = weatherDataRepository.findAll();
        model.addAttribute("total", totalList);
        return "page/main";
    }

    @RequestMapping(value = "/weather/{courseId}", method = RequestMethod.GET, produces = "application/json; charset=UTF8")
    public @ResponseBody String jsonList(@PathVariable String courseId, Model model) {
        return weatherPlaceService.rowNumDown(courseId);
    }

}
