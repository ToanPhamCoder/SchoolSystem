package com.example.crud_basic.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class GroupRequest {

    private Long courseId;

    private LocalDate startDate;

    private LocalDate endDate;
}
