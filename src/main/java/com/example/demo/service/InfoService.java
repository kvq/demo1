package com.example.demo.service;

import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoService {
    private final UserLocalRepository localRepository;

    public List<UserInfo> getTopUserResults(Long id){
        if (id == null) {
            throw new IllegalArgumentException("No user id provided");
        }
        return localRepository.getTop20ResultsForUser(id);
    }

}
