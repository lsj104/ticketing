package com.ticketing.performance.presentation.dto.hall;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HallSearchRequestDto {

    @Min(value = 1, message = "Page 번호는 1 이상이어야 합니다.")
    private int page = 1;

    @Pattern(regexp = "10|30|50", message = "Size는 10, 30, 50 중 하나여야 합니다.")
    private String size = "10";


    private String sort = "createdAt";
    private Sort.Direction direction = Sort.Direction.DESC;


    public Pageable toPageable() {
        return PageRequest.of(page-1, Integer.parseInt(size), Sort.by(direction, sort));
    }

}
