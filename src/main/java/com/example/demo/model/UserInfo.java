package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserInfo {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("level_id")
    private Long levelId;
    private int result;

}
