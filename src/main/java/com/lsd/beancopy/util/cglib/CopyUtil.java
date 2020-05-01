package com.lsd.beancopy.util.cglib;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.TypeUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: lsd
 * @Description:
 * @Date:Create：
 * @Modified By：
 */
@Slf4j
public class CopyUtil {
    private static Map map = new HashMap();

    /**
     * 集合属性的赋值
     * @param sourceList 实体类集合
     * @param clazz dto类
     * @param <S> 实体类泛型
     * @param <T> dto泛型
     * @return dto的集合
     * @throws Exception
     */
    public static<S,T> List<T> toList(List<S> sourceList, Class<T> clazz) {
        List<T> targetList=new ArrayList<>();
        for (S sourceTemp : sourceList) {
            T result= to(sourceTemp, clazz);
            targetList.add(result);
        }
        return targetList;
    }

    public static<S,T> Set<T> toSet(Set<S> sourceSet, Class<T> clazz) {
        Set<T> targetSet =new HashSet<>();
        for (S sourceTemp : sourceSet) {
            T result= to(sourceTemp, clazz);
            targetSet.add(result);
        }
        return targetSet;
    }

    /**
     * 单个实体类的赋值
     * @param source 实体类
     * @param targetClass dto类
     * @param <S> 实体类的泛型
     * @param <T> dto的泛型
     * @return dto
     * @throws Exception
     */
    public static <S,T> T to(S source, Class<T> targetClass) {

        try {

            BeanCopier copier = (BeanCopier)map.get(source.getClass().toString() + targetClass.toString());

            if(copier == null){
                copier = BeanCopier.create(source.getClass(), targetClass, false);
                map.put(source.getClass().toString() + targetClass.toString(), copier);
            }

            T target =  targetClass.newInstance();
            copier.copy(source, target, null);

            Class sourceClass = source.getClass();

            Field[] sFields = sourceClass.getDeclaredFields();

            List<String> aimFieldNames = Arrays.stream(targetClass.getClass().getDeclaredFields()).map(Field::getName).collect(Collectors.toList());

            List<Field> fieldList = Arrays.stream(sFields).filter(f -> Collection.class.isAssignableFrom(f.getType()) && aimFieldNames.contains(f.getName())).collect(Collectors.toList());

            List<Field> diffList = Arrays.stream(sFields).filter(f -> {
                try {
                    return targetClass.getDeclaredField(f.getName()).getType() != f.getType();
                } catch (Exception e) {
                    return false;
                }
            }).collect(Collectors.toList());

            //处理类型不一致，但是属性名一致的
            for(Field field: diffList) {
                field.setAccessible(true);
                Field tField = targetClass.getDeclaredField(field.getName());
                tField.setAccessible(true);

                Method method = null;

                String methodName = "set" + tField.getType().getSimpleName();

                try {
                    //取set方法
                    method = targetClass.getMethod(methodName, tField.getType());

                } catch (NoSuchMethodException e){
                    log.debug(String.format("%s.%s不存在", targetClass.getName(), methodName));
                }
                if(method != null){
                    method.invoke(target, to(field.get(source), tField.getType()));

                } else {

                    Object res = to(field.get(source), tField.getType());
                    if(res != null){
                        tField.set(target, res);
                    }


                }
            }

            //处理类型是List和Set
            for(Field field: fieldList) {
                field.setAccessible(true);
                Field tField = targetClass.getClass().getDeclaredField(field.getName());
                tField.setAccessible(true);

                Type paramType = ((ParameterizedType)tField.getGenericType()).getActualTypeArguments()[0];
                Class paramTypeClass = TypeUtils.getRawType(paramType, null);

                if(List.class.isAssignableFrom(tField.getType())) {

                    if(paramTypeClass.equals(Integer.class)
                            || paramTypeClass.equals(String.class)
                            || paramTypeClass.equals(Long.class)
                            || paramTypeClass.equals(BigDecimal.class)){

                        tField.set(target, field.get(source));

                    } else {
                        tField.set(target, toList((List)field.get(source), paramTypeClass));

                    }
                } else if(Set.class.isAssignableFrom(tField.getType())){
                    tField.set(target, toSet((Set)field.get(source), paramTypeClass));
                }
            }




            return target;
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
