package com.example.demo.controller;

import com.example.demo.dto.UserInfoDto;
import com.example.demo.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Slf4j
@RequestMapping("/api/v1/user")
@RestController
public class UserInfoRestController {

    private UserInfoService userInfoService;

    public UserInfoRestController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    /**
     * 사번 리턴
     *
     * @param none
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getDefaultID() {
        return ResponseEntity.ok("82265683");
    }

    /**
     * UserInfo 상세 조회
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserID(@PathVariable("id") Long id) {
        return ResponseEntity.ok(userInfoService.getSearchUserID(id));
    }

    /**
     * UserInfo 추가
     *
     * @param userInfoDto
     * @param bindingResult
     * @return
     */
    @PostMapping
    public ResponseEntity<?> addUserInfo(@Valid @RequestBody UserInfoDto userInfoDto, BindingResult bindingResult) {

        // validation 체크
        if (bindingResult.hasErrors()) {
            String errorMessage = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
        }

        try {
            userInfoService.addUserInfo(userInfoDto);
            return new ResponseEntity<>("추가 되었습니다.", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
