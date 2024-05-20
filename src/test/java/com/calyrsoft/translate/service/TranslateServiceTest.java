package com.calyrsoft.translate.service;

import com.calyrsoft.translate.dto.TranslateResponseDto;
import com.calyrsoft.translate.exception.TooManyRequestException;
import com.calyrsoft.translate.model.LanguageEnum;
import com.calyrsoft.translate.repository.ITranslateRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TranslateServiceTest {

    @Mock
    private ITranslateRepository iTranslateRepository;

    @InjectMocks
    private TranslateService translateService;

    @Test
    @DisplayName("Given a corrent text should be return a correct translate")
    void translate() throws TooManyRequestException {
        TranslateResponseDto dtoResponse = new TranslateResponseDto();
        dtoResponse.text = "Aun en desarollo";
        dtoResponse.translate = "Still in development";
        dtoResponse.timestamp = 124141234L;
        dtoResponse.source = LanguageEnum.ES;
        dtoResponse.target = LanguageEnum.EN;
        when(iTranslateRepository.translate(anyString(), any(), any())).thenReturn(dtoResponse);
        String textExpented = "Still in develpment";

        String textResult = translateService.translate("Aun en desarollo", LanguageEnum.EN, LanguageEnum.ES).translate;
        assertEquals(textExpented, textResult);
    }

    @Test
    @DisplayName("Given too many request should be return a Exception")
    void translateEmptyText() throws TooManyRequestException {


        when(iTranslateRepository.translate(anyString(), any(), any())).thenThrow(new TooManyRequestException(
                anyString(),
                anyString(),
                anyList()
        ));
        assertThrows(TooManyRequestException.class, () -> translateService.translate("Hi", LanguageEnum.EN, LanguageEnum.ES));
    }
}