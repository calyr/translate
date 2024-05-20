package com.calyrsoft.translate.documentationapi;

import com.calyrsoft.translate.dto.TranslateRequestDto;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

public interface ITranslateApi {

    ResponseEntity<?> translate(TranslateRequestDto request);
}
