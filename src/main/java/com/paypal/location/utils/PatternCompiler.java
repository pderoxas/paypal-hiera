package com.paypal.location.utils;

import org.springframework.cache.annotation.Cacheable;

import java.util.regex.Pattern;

/**
 * User: pderoxas
 * Date: 10/15/13
 * Time: 1:02 PM
 * Compiles a given pattern string. Method is cached.
 */
public class PatternCompiler {
    @Cacheable(value = "regexPatternCache")
    public static Pattern getCompiledPattern(String pattern){
        return Pattern.compile(pattern);
    }
}
