package com.nikita.productservice.client.authanticationclient.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidatetokenResponseDto {
    private UserDto userDto;
    private SessionStatus sessionStatus;
}