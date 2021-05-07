package ulas.eurekaclinetconsumer.serice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ulas.eurekaclinetconsumer.controller.model.Meeting;
import ulas.eurekaclinetconsumer.controller.model.MeetingInfo;
import ulas.eurekaclinetconsumer.controller.model.WeatherInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MeetingInfoService {

    private final RestTemplate restTemplate;

    private final List<Meeting> meetingList = Arrays.asList(new Meeting("Ankara Meetup", "Ankara"), new Meeting("İstanbul Meetup", "İstanbul"), new Meeting("İzmir Meetup", "İzmir"));

    public List<MeetingInfo> getMeetingInfo() {
        return meetingList.stream().map(m -> new MeetingInfo(m, restTemplate.getForObject("http://eureka-client-producer-servis/weather/" + m.getCityName(), WeatherInfo.class))).collect(Collectors.toList());
    }
}
