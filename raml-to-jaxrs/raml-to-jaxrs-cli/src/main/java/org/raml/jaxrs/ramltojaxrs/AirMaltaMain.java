package org.raml.jaxrs.ramltojaxrs;

public class AirMaltaMain {
    public static void main(String[] args) throws Exception{
        Main.main(new String[]{
                "--json-mapper", "jackson2",
                "--model-package", "com.triplake.adapter.kmapi.jaxrs.model",
                "--support-package", "com.triplake.adapter.kmapi.jaxrs.support",
                "--resource-package", "com.triplake.adapter.kmapi.jaxrs.resource",
                "--directory", "G:\\jurn\\branchspace\\alloy-rest\\adapters\\kmapi\\jaxrs\\target\\generated-sources\\raml\\",
                "G:\\jurn\\branchspace\\alloy-rest\\adapters\\kmapi\\jaxrs\\src\\main\\raml\\shop-and-book-api.raml"
        });
    }
}
