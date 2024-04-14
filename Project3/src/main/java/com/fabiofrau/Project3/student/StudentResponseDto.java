package com.fabiofrau.Project3.student;

import lombok.Builder;

@Builder
public record StudentResponseDto(
        String firstName,
        String lastName,
        String email

) {
}
