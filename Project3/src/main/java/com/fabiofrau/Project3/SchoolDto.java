package com.fabiofrau.Project3;

import lombok.Builder;

@Builder
public record SchoolDto(
        String name
) {

    public School toEntity() {
        return School.builder()
                .name(this.name)
                .build();
    }
}
