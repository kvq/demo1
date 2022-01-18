package com.example.demo.service;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserLocalRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class InfoServiceTest {
    @Autowired
    UserLocalRepository userLocalRepository;
    @Autowired
    InfoService infoService;

    @BeforeEach
    void populateWithData() {
        Random random = new Random();
        for (int indexUserId = 1; indexUserId < 30; indexUserId++) {
            for (int indexLevelId = 0; indexLevelId < 25; indexLevelId++) {
                int result = random.nextInt();
                userLocalRepository.setResult(
                        UserInfo.builder()
                                .userId(Long.valueOf(indexUserId))
                                .levelId(Long.valueOf(indexLevelId))
                                .result(result)
                                .build());
            }
        }
    }

    @Test
    void getTopUserResults() {
        Long testUserId = 1L;
        List<UserInfo> userInfoList = infoService.getTopUserResults(testUserId);
        Assertions.assertEquals(userInfoList.size(), 20);
    }

    @Test
    void getTopLevelResults() {
        Long testLevelId = 1L;
        List<UserInfo> userInfoList = infoService.getTopLevelResults(testLevelId);
        Assertions.assertEquals(userInfoList.size(), 20);
    }

    @Test
    void setResult() {
        Long testUserId = 50L;
        Long testLevelId = 100L;

        infoService.setResult(UserInfo.builder()
                .userId(testUserId)
                .levelId(testLevelId)
                .result(1)
                .build());

        infoService.setResult(UserInfo.builder()
                .userId(testUserId)
                .levelId(testLevelId)
                .result(2)
                .build());

        List<UserInfo> userInfoList = infoService.getTopUserResults(testUserId);
        Assertions.assertEquals(userInfoList.size(), 1);
    }
}