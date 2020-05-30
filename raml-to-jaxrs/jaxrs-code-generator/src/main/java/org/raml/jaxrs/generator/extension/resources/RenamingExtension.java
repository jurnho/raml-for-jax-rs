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

import amf.client.model.domain.EndPoint;
import org.raml.jaxrs.generator.extension.resources.api.GlobalResourceExtension;
import org.raml.jaxrs.generator.extension.resources.api.ResourceContext;

import java.util.List;

/**
 * Created. There, you have it.
 */
public class RenamingExtension extends GlobalResourceExtension.Helper {

  private final List<String> args;

  public RenamingExtension(List<String> args) {
    this.args = args;
  }

  @Override
  public String resourceClassName(ResourceContext context, EndPoint resource, String originalName) {
    return args.get(0);
  }
}
