package ulas.eurekaclinetconsumer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulas.eurekaclinetconsumer.controller.model.MeetingInfo;
import ulas.eurekaclinetconsumer.serice.MeetingInfoService;

import java.util.List;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class MeetingController {

    private final MeetingInfoService meetingInfoService;

    @GetMapping("/meeting")
    public ResponseEntity<List<MeetingInfo>> getMeetings() {
        return ResponseEntity.ok(meetingInfoService.getMeetingInfo());
    }


}
