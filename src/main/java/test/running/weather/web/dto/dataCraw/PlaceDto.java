package test.running.weather.web.dto.dataCraw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlaceDto {
    private String tm;
    private String thema;
    private String courseId;
    private String courseAreaId;
    private String courseAreaName;
    private String courseName;
    private int spotAreaId;
    private String spotAreaName;
    private String spotName;
    private int th3;
    private int wd;
    private int ws;
    private int sky;
    private int rhm;
    private int pop;
}
