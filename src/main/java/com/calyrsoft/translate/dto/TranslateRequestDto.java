package com.calyrsoft.translate.dto;

import com.calyrsoft.translate.model.LanguageEnum;

public class TranslateRequestDto {
    public String text;
    public LanguageEnum source;
    public LanguageEnum target;
}
