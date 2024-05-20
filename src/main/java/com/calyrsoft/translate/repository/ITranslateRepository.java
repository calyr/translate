package com.calyrsoft.translate.repository;

import com.calyrsoft.translate.dto.TranslateResponseDto;
import com.calyrsoft.translate.exception.TooManyRequestException;
import com.calyrsoft.translate.model.LanguageEnum;

public interface ITranslateRepository {
    TranslateResponseDto translate(String text, LanguageEnum source, LanguageEnum target) throws TooManyRequestException;
}
