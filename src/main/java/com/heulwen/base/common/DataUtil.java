package com.heulwen.base.common;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Slf4j
public class DataUtil {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static <T> boolean isNullOrEmpty(T obj) {
        return obj == null || (obj instanceof String && ((String) obj).trim().isEmpty())
                || (obj instanceof Iterable && !((Iterable<?>) obj).iterator().hasNext())
                || (obj instanceof Object[] && ((Object[]) obj).length == 0);
    }

    public static <T> String trimLeft(T obj) {
        if (!isNullOrEmpty(obj) && (obj instanceof String)) {
            return ((String) obj).stripLeading();
        }
        return null;
    }

    @SneakyThrows
    public static <T> String trimRight(T obj) {
        if (!isNullOrEmpty(obj) && (obj instanceof String)) {
            return ((String) obj).stripTrailing();
        }
        return null;
    }

    @SneakyThrows
    public static <T> String trimLeftRight(T obj) {
        if (!isNullOrEmpty(obj) && (obj instanceof String)) {
            return ((String) obj).trim();
        }
        return null;
    }

    public static <T> String upperCase(T obj) {
        if (!isNullOrEmpty(obj) && (obj instanceof String)) {
            return ((String) obj).toUpperCase(Locale.ROOT);
        }
        return null;
    }

    public static <T> String lowerCase(T obj) {
        if (!isNullOrEmpty(obj) && (obj instanceof String)) {
            return ((String) obj).toLowerCase(Locale.ROOT);
        }
        return null;
    }

    public static <T, V> String dateToString(T obj, V format) {
        if (!isNullOrEmpty(obj) && !isNullOrEmpty(format) && (obj instanceof Date) && (format instanceof String)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String) format);
            return simpleDateFormat.format((Date) obj);
        }
        return null;
    }

    public static <S, D> D convertObject(S source, Class<D> dest) {
        if (!isNullOrEmpty(source) && !isNullOrEmpty(dest)) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STANDARD);
            return modelMapper.map(source, dest);
        }
        return null;
    }

    public static <S, D> List<D> convertObjects(List<S> sources, Class<D> dest) {
        if (!isNullOrEmpty(sources) && !isNullOrEmpty(dest)) {
            List<D> rs = new ArrayList<>();
            for (S source : sources) {
                rs.add(convertObject(source, dest));
            }
            return rs;
        }
        return null;
    }
}
