package wang.ismy.pms.web.controller.convert;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDateTime;

/**
 * @author MY
 * @date 2019/8/27 8:54
 */
public class LocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        return LocalDateTime.parse(source);
    }
}
