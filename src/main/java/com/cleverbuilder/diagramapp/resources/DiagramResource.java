package com.cleverbuilder.diagramapp.resources;

import com.cleverbuilder.diagramapp.diagrams.DiagramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;

@Path("/diagram")
public class DiagramResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagramResource.class);

    @Inject
    DiagramService diagramService;

    /**
     * Resource to generate a standard diagram
     * @param body the Plantuml syntax to generate from
     * @param skin the name of the skin to use
     * @return the diagram as a PNG
     * @throws Exception
     */
    @POST
    @Path("/standard")
    @Produces("image/png")
    @Consumes(MediaType.TEXT_PLAIN)
    public Response standard(String body,
                             @HeaderParam("skin") String skin) throws Exception {
        ByteArrayOutputStream png = diagramService.generate(body, skin);

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