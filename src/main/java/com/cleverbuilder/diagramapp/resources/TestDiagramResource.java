package com.cleverbuilder.diagramapp.resources;

import net.sourceforge.plantuml.SourceStringReader;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Generates a diagram from a basic sample (basic.puml)
 */
@Path("/test")
public class TestDiagramResource {

    @GET
    @Produces("image/png")
    public Response hello() throws Exception {
        ByteArrayOutputStream png = new ByteArrayOutputStream();

        String source = "@startuml\n";
        source += "Bob -> Alice : hello\n";
        source += "@enduml\n";

        List<String> config = new ArrayList<>();
        config.add("skinparam dpi 300");

        SourceStringReader reader = new SourceStringReader(source);

        // Write the first image to "png"
        String desc = reader.outputImage(png).getDescription();
        // Return a null string if no generation

        byte[] imageData = png.toByteArray();

        return Response.ok(imageData).build();
    }

}