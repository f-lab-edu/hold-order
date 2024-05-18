package com.holdOrder.HoldOrder.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Tag(name = "메인 페이지 컨트롤러", description = "메인 페이지로 이동시켜주는 컨트롤러")
@RestController
public class MainPageController {

    @Operation(summary = "메인페이지로 이동", description = "메인페이지로 이동시켜주는 메소드")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "요청 성공")})
    @GetMapping("/home")
    public ModelAndView homepage() {
        return new ModelAndView("home");
    }
}
