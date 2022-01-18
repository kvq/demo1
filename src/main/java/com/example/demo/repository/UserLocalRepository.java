package com.example.demo.repository;

import com.example.demo.model.UserInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserLocalRepository {

    private List<UserInfo> data = new ArrayList<>();

    public List<UserInfo> getTop20ResultsForUser(Long id) {
        return data.stream().filter(userInfo -> userInfo.getUserId().equals(id))
                .sorted(Comparator.comparingInt(UserInfo::getResult).reversed())
                .limit(20).collect(Collectors.toList());
    }

    public List<UserInfo> getTop20ResultsForLevel(Long id) {
        return data.stream().filter(userInfo -> userInfo.getLevelId().equals(id))
                .sorted(Comparator.comparingInt(UserInfo::getResult).reversed())
                .limit(20).collect(Collectors.toList());
    }

    public UserInfo setResult(UserInfo userInfo) {
        UserInfo oldInfo = data.stream()
                .filter(storedInfo -> storedInfo.getUserId().equals(userInfo.getUserId())
                        && storedInfo.getLevelId().equals(userInfo.getLevelId()))
                .findAny().orElse(null);
        if (oldInfo != null){
            data.remove(oldInfo);
        }
        data.add(userInfo);
        return userInfo;
    }

}
