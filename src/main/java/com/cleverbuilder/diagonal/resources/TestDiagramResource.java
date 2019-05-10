/*
 * Diagonal, a program for generating diagrams
 * Copyright (C) 2019  Tom Donohue
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.cleverbuilder.diagonal.resources;

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