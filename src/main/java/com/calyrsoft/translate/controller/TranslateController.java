package com.calyrsoft.translate.controller;

import com.calyrsoft.translate.documentationapi.ITranslateApi;
import com.calyrsoft.translate.dto.TranslateRequestDto;
import com.calyrsoft.translate.dto.TranslateResponseDto;
import com.calyrsoft.translate.exception.TooManyRequestException;
import com.calyrsoft.translate.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TranslateController implements ITranslateApi {

    @Autowired
    private TranslateService translateService;

    @Override
    @PostMapping("/translate")
    public ResponseEntity<?> translate(@RequestBody TranslateRequestDto request) {

        try {
            TranslateResponseDto result = this.translateService.translate(request.text, request.source, request.target);
            return ResponseEntity.ok(result);
        } catch (TooManyRequestException e) {
            return ResponseEntity.status(e.body.getStatus()).body(e.body);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

    }
}
