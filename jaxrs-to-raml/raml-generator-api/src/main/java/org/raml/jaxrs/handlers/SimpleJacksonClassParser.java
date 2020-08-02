/*
 * Copyright 2013-2018 (c) MuleSoft, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package org.raml.jaxrs.handlers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import org.raml.pojotoraml.ClassParser;
import org.raml.pojotoraml.Property;

import javax.annotation.Nullable;
import java.beans.Introspector;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Jean-Philippe Belanger on 3/26/17. Just potential zeroes and ones
 */
public class SimpleJacksonClassParser implements ClassParser {

  @Override
  public List<Property> properties(Type typeToParse) {

    if (!(typeToParse instanceof Class)) {

      return Collections.emptyList();
    }
    Class<?> classToParse = (Class<?>) typeToParse;


    Map<String, PojoToRamlProperty> properties = new TreeMap<>();
    forFields(classToParse, properties);
    forProperties(classToParse, properties);

    return FluentIterable.from(properties.entrySet()).transform(new Function<Map.Entry<String, PojoToRamlProperty>, Property>() {

      @Nullable
      @Override
      public Property apply(@Nullable Map.Entry<String, PojoToRamlProperty> entry) {
        return entry.getValue();
      }
    }).toList();
  }


  @Override
  public Collection<Type> parentClasses(Type classToParse) {
    return null;
  }


  private void forProperties(Class<?> classToParse, Map<String, PojoToRamlProperty> propertyMap) {
    for (final Method method : classToParse.getDeclaredMethods()) {

      if (!(method.getName().startsWith("get") || method.getName().startsWith("is"))) {

        continue;
      }

      if (Modifier.isStatic(method.getModifiers())) {

        continue;
      }

      JsonProperty elem = method.getAnnotation(JsonProperty.class);
      if (elem != null) {

        final String name = elem.value().equals("") ? buildName(method) : elem.value();
        propertyMap.put(name, new PojoToRamlProperty() {

          @Override
          public <T extends Annotation> Optional<T> getAnnotation(Class<T> annotationType) {
            return Optional.fromNullable(method.getAnnotation(annotationType));
          }

          @Override
          public String name() {
            return name;
          }

          @Override
          public Type type() {
            return method.getGenericReturnType();
          }
        });
      }
    }
  }

  private void forFields(Class<?> classToParse, Map<String, PojoToRamlProperty> propertyMap) {
    for (final Field field : classToParse.getDeclaredFields()) {

      JsonProperty elem = field.getAnnotation(JsonProperty.class);
      if (elem != null) {

        final String name = elem.value().equals("") ? field.getName() : elem.value();
        propertyMap.put(name, new PojoToRamlProperty() {

          @Override
          public <T extends Annotation> Optional<T> getAnnotation(Class<T> annotationType) {
            return Optional.fromNullable(field.getAnnotation(annotationType));
          }

          @Override
          public String name() {
            return name;
          }

          @Override
          public Type type() {
            return field.getGenericType();
          }
        });
      }
    }
  }

  private String buildName(Method method) {

    if (method.getName().startsWith("is")) {
      return Introspector.decapitalize(method.getName().substring(2));
    } else {

      return Introspector.decapitalize(method.getName().substring(3));
    }

  }
}
