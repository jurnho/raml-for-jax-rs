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
package org.raml.jaxrs.generator.extension.resources;

import amf.client.model.domain.*;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import org.raml.jaxrs.generator.extension.resources.api.GlobalResourceExtension;
import org.raml.jaxrs.generator.extension.resources.api.ResourceContext;
import org.raml.jaxrs.generator.ramltypes.GMethod;
import org.raml.jaxrs.generator.ramltypes.GRequest;
import org.raml.jaxrs.generator.ramltypes.GResource;
import org.raml.jaxrs.generator.ramltypes.GResponse;

/**
 * Created. There, you have it.
 */
public class JavadocResourceExtension implements GlobalResourceExtension {

  @Override
  public TypeSpec.Builder onResource(ResourceContext context, EndPoint resource, TypeSpec.Builder typeSpec) {
    if (! resource.description().isNullOrEmpty()) {
      typeSpec.addJavadoc("$L\n", resource.description().value());
    }

    return typeSpec;
  }

  @Override
  public MethodSpec.Builder onMethod(ResourceContext context, Operation method, Request gRequest, Payload payload, MethodSpec.Builder methodSpec) {

    if (! method.description().isNullOrEmpty()) {
      methodSpec.addJavadoc("$L\n", method.description().value());
    }

    return methodSpec;
  }

  @Override
  public TypeSpec.Builder onResponseClass(ResourceContext context, Operation method, TypeSpec.Builder typeSpec) {
    return typeSpec;
  }

  @Override
  public MethodSpec.Builder onMethod(ResourceContext context, Response responseMethod, MethodSpec.Builder methodSpec) {
    if (! responseMethod.description().isNullOrEmpty()) {
      methodSpec.addJavadoc("$L\n", responseMethod.description().value());
    }

    return methodSpec;
  }
}
