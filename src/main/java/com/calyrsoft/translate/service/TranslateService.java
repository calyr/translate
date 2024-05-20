package com.calyrsoft.translate.service;

import com.calyrsoft.translate.dto.TranslateResponseDto;
import com.calyrsoft.translate.exception.TooManyRequestException;
import com.calyrsoft.translate.model.LanguageEnum;
import com.calyrsoft.translate.repository.ITranslateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService {


    private ITranslateRepository iTranslateRepository;

    @Autowired
    public TranslateService(ITranslateRepository iTranslateRepository) {
        this.iTranslateRepository = iTranslateRepository;
    }

    public TranslateResponseDto translate(String text, LanguageEnum source, LanguageEnum target) throws TooManyRequestException {
        return this.iTranslateRepository.translate(text, source, target);
    }
}
