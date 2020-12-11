package org.raml.jaxrs.ramltojaxrs;

import org.raml.ramltopojo.RamlToPojo;
import org.raml.ramltopojo.RamlToPojoBuilder;
import org.raml.v2.api.RamlModelBuilder;
import org.raml.v2.api.RamlModelResult;
import org.raml.v2.api.model.common.ValidationResult;
import org.raml.v2.api.model.v10.api.Api;

import java.io.FileReader;

import static org.raml.ramltopojo.TypeFetchers.fromAnywhere;
import static org.raml.ramltopojo.TypeFinders.everyWhere;

public class AirMalta {
    public static void main(String[] args) throws Exception {

        Main.main(new String[]{
                "--directory",
                "G:\\jurn\\branchspace\\alloy-rest\\adapters\\kmapi\\jaxrs\\src\\main\\java\\",
                "--generate-types-with", // raml to pojo core.*
                "jackson,rename,renameImplementation",
                "--json-mapper",
                "jackson2",
                "--resource-package",
                "com.triplake.adapter.kmapi.jaxrs.api.resource",
                "--model-package",
                "com.triplake.adapter.kmapi.jaxrs.api.model",
//                "--support-package",
//                "com.triplake.adapter.kmapi.jaxrs.api.support",
                "G:\\jurn\\branchspace\\raml\\adapter-km-raml-codegen\\raml\\shop-and-book-api.raml"
        });
    }
}
