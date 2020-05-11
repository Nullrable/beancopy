package com.lsd.mapping;

import com.google.auto.service.AutoService;
import com.lsd.mapping.annotation.LsdMapper;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: nhsoft.lsd
 * @Description:
 * @Date:Create：in 2020-05-10 14:57
 * @Modified By：
 */
@AutoService(Processor.class)
public class MappingProcessor extends AbstractProcessor {



    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;// TODO (lusudong, 2020-05-10)
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {

        Set<String> set = new HashSet<>();

        set.add(LsdMapper.class.getCanonicalName());

        return set;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
