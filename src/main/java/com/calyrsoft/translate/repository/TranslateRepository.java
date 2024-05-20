package com.calyrsoft.translate.repository;

import com.calyrsoft.translate.dto.TranslateResponseDto;
import com.calyrsoft.translate.exception.TooManyRequestException;
import com.calyrsoft.translate.model.LanguageEnum;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class TranslateRepository implements ITranslateRepository{
    @Override
    public TranslateResponseDto translate(String text, LanguageEnum source, LanguageEnum target) throws TooManyRequestException {
//        throw new TooManyRequestException(
//                "mensaje",
//                "detallie",
//                List.of("as", "bs")
//        )
//        ;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        TranslateResponseDto result = new TranslateResponseDto();
        result.text = text;
        result.source = source;
        result.target = target;
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        result.timestamp = timestamp.getTime();
        result.translate = "Esta traducción aun esta en fase de dasarollo";
        return result;
    }
}
