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
package org.raml.jaxrs.generator.ramltypes;

import amf.client.model.domain.AnyShape;
import com.squareup.javapoet.TypeName;
import org.raml.jaxrs.generator.CurrentBuild;
import org.raml.jaxrs.generator.GAbstraction;
import org.raml.jaxrs.generator.GObjectType;

import java.util.function.Consumer;

/**
 * Created by Jean-Philippe Belanger on 12/10/16. Just potential zeroes and ones
 */
public interface GType extends GAbstraction<AnyShape> {

  String type();

  String name();

  TypeName defaultJavaTypeName(String pack);

  boolean isJson();

  boolean isXml();

  String schema();

  void construct(CurrentBuild currentBuild, Consumer<GObjectType.GObjectTypeDispatcher> objectType);

  void setJavaType(TypeName generatedJavaType);
}
