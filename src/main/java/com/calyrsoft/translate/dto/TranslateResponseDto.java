package com.calyrsoft.translate.dto;

import com.calyrsoft.translate.model.LanguageEnum;

public class TranslateResponseDto {
    public String text;
    public LanguageEnum source;
    public LanguageEnum target;
    public String translate;
    public Long timestamp;
}
