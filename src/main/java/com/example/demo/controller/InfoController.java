package com.example.demo.controller;

import com.example.demo.model.UserInfo;
import com.example.demo.service.InfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class InfoController {
    private final InfoService infoService;

    @GetMapping("/userinfo/{id}")
    public List<UserInfo> userInfo(@PathVariable(name = "id", required = true) Long id){
        return infoService.getTopUserResults(id);
    }

    @GetMapping("/levelinfo/{level}")
    public List<UserInfo> levelInfo(@PathVariable(name = "level", required = true) Long level){
        return infoService.getTopLevelResults(level);
    }

    @PostMapping("/setInfo/")
    public UserInfo levelInfo(@RequestBody UserInfo userInfo){
        return infoService.setResult(userInfo);
    }

}
