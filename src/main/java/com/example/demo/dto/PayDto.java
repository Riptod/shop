package com.example.demo.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PayDto {
    private String username;
    private List<Long> itemsId;
}
