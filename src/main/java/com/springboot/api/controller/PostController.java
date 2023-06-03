package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import java.util.Map;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

// 컨트롤러 클래스에서 공통 URL 설정
@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    // @RequestMapping 사용
    @RequestMapping(value = "/domain", method = RequestMethod.POST)
    public String postExample(){
        return "Hello Post API";
    }

    // @RequestBody와 Map을 활용한 Post API 구현
    // http://localhost:9090/api/v1/post-api/member
    @PostMapping(value = "/member")
    public String postMember(@RequestBody Map<String, Object> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }


    /*
    param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));
    */

    // DTO 객체를 활용한 POST API 구현
    // http://localhost:9090/api/v1/post-api/member2
    @PostMapping(value = "/member2")
    public String postMemberDto(@RequestBody MemberDto memberDTO) {

        return memberDTO.toString();
    }

}
