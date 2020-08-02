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
package org.raml.emitter;

import com.github.jsonldjava.shaded.com.google.common.base.Suppliers;
import org.raml.api.RamlApi;
import org.raml.pojotoraml.AdjusterFactory;
import org.raml.pojotoraml.PojoToRamlBuilder;
import org.raml.pojotoraml.plugins.PojoToRamlClassParserFactory;
import org.raml.pojotoraml.plugins.PojoToRamlExtensionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.lang.String.format;

public class FileEmitter implements Emitter {

  private static final Logger logger = LoggerFactory.getLogger(FileEmitter.class);

  private final Path filePath;

  private FileEmitter(Path filePath) {
    this.filePath = filePath;
  }

  public static FileEmitter forFile(Path pathToFile) {
    checkNotNull(pathToFile);

    return new FileEmitter(pathToFile);
  }

  @Override
  public void emit(RamlApi api) throws RamlEmissionException {
    if (Files.isRegularFile(filePath)) {
      logger.warn("output file {} already exists, will be overwritten", filePath);
    }

    try (PrintWriter writer = printWriterOf(filePath)) {

      Emitter innerEmitter =
          new ModelEmitter(writer, Suppliers.memoize(() -> {
            AdjusterFactory factory =
                clazz -> new PojoToRamlExtensionFactory(Package.getPackage(api.getTopPackage())).createAdjusters(clazz);
            return PojoToRamlBuilder.create(new PojoToRamlClassParserFactory(Package.getPackage(api.getTopPackage())), factory);
          }));
      innerEmitter.emit(api);
    } catch (IOException | RamlEmissionException e) {
      throw new RamlEmissionException(format("unable to successfully output raml to %s", filePath),
                                      e);
    }
  }

  private static PrintWriter printWriterOf(Path path) throws IOException {
    return new PrintWriter(Files.newBufferedWriter(path, StandardCharsets.UTF_8));
  }
}
