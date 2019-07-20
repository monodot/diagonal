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

package xyz.tomd.diagonal.resource;

import xyz.tomd.diagonal.model.Diagram;
import xyz.tomd.diagonal.service.DiagramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;

@Path("/diagrams")
public class DiagramResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagramResource.class);

    @Inject
    DiagramService diagramService;

    /**
     * Resource to generate a standard diagram
     * @param input the unmarshalled Diagram request object
     * @return the diagram as a PNG
     * @throws Exception
     */
    @POST
    @Path("/standard")
    @Produces("image/png")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response standard(Diagram input) throws Exception {
        LOGGER.info("Received request: skin=" + input.getSkin());

        ByteArrayOutputStream png = diagramService.generate(
                input.getSource(),
                input.getSkin());

        if (png == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        try {
            byte[] imageData = png.toByteArray();
            LOGGER.debug("Returning image, " + imageData.length);
            return Response.ok(imageData).build();
        } catch (RuntimeException e) {
            String message = e.getClass().getSimpleName() + ": "+ e.getMessage();
            LOGGER.error("Failure generating diagram");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(message).build();
        }
    }

}