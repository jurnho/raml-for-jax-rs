package org.raml.jaxrs.ramltojaxrs;

import com.google.common.collect.ImmutableList;
import org.raml.ramltopojo.RamlToPojo;
import org.raml.ramltopojo.RamlToPojoBuilder;
import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.model.common.ValidationResult;
import org.raml.v2.api.model.v10.api.Api;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

import static org.raml.ramltopojo.TypeFetchers.fromAnywhere;
import static org.raml.ramltopojo.TypeFinders.everyWhere;

public class RamlMain {
    public static void main(String[] args) throws Exception{
        File ramlFile =new File( "G:\\jurn\\branchspace\\raml\\adapter-km-raml-codegen\\raml\\shop-and-book-api.raml");
        RamlModelResult ramlModelResult =
                new RamlModelBuilder().buildApi(
                        new FileReader(ramlFile),
                        ramlFile.getAbsolutePath());
        if (ramlModelResult.hasErrors()) {
            for (ValidationResult validationResult : ramlModelResult.getValidationResults()) {
                final String path = validationResult.getPath();
                System.out.println("raml error:" + validationResult.getMessage() + ":" + path);
            }
        }

        final Api api = ramlModelResult.getApiV10();
        RamlToPojo ramlToPojo = RamlToPojoBuilder.builder(api)
                .inPackage("com.triplake.direct")
                .fetchTypes(fromAnywhere())
                .findTypes(everyWhere())
                .build(ImmutableList.<String>of());

        ramlToPojo.buildPojos().createAllTypes(new File("G:\\jurn\\branchspace\\alloy-rest\\adapters\\kmapi\\jaxrs\\src\\main\\java\\").getAbsolutePath());

    }
}
