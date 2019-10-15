package com.ppkwu.ppkwu.endpoints;

import com.ppkwu.ppkwu.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class SampleEndpoint {

    private SampleService sampleService;

    @Autowired
    public SampleEndpoint(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("reverse/{characters}")
    public String getReversedString(@PathVariable String characters) {
        return sampleService.reverse(characters);
    }

    @GetMapping("recognize/{characters}")
    public String getRecognizedString(@PathVariable String characters) {
        return sampleService.recognizeCharacter(characters).toString();
    }
}
