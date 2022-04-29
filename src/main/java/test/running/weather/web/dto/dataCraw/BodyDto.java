package test.running.weather.web.dto.dataCraw;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BodyDto {
    private String dataType;
    private ItemDto items;
    private int totalCount;
}
