package org.raml.jaxrs.ramltojaxrs;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.file.Files;

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
        FileUtils.copyFile(new File("G:\\jurn\\branchspace\\raml\\raml-for-jax-rs\\raml-to-jaxrs\\raml-to-jaxrs-cli\\src\\main\\java\\org\\raml\\jaxrs\\ramltojaxrs\\fix.sh"),
                new File("G:\\jurn\\branchspace\\alloy-rest\\adapters\\kmapi\\jaxrs\\src\\main\\fix.sh"));
    }
}
