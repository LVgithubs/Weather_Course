package test.running.weather.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Builder
public class WeatherData {

    @Column
    private String tm; // 시간대

    @Column
    private String thema; // 테마

    @Column
    private String courseId; // 코스 id

    @Column
    private String courseAreaId; // 소속 지역 ID

    @Column
    private String courseAreaName; // 소속 지역
    @Column
    private String courseName; // 코스 이름
    @Id
    @Column
    private int spotAreaId; // 장소별 ID

    @Column
    private String spotAreaName; // 장소 마을 이름

    @Column
    private String spotName; // 장소 상세 이름

    @Column
    private int th3; // 기온
    @Column
    private int wd; // 풍향
    @Column
    private int ws; // 풍속
    @Column
    private int sky; // 하늘 상태
    @Column
    private int rhm; // 습도
    @Column
    private int pop; // 강수확률
}
