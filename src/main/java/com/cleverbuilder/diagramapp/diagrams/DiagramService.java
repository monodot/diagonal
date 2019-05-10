package com.cleverbuilder.diagramapp.diagrams;

import com.cleverbuilder.diagramapp.skins.SkinsRepository;
import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.core.DiagramDescription;
import net.sourceforge.plantuml.preproc.Defines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DiagramService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagramService.class);

    @Inject
//    @Named("simpleSkinsRepository")
    SkinsRepository skins;

    public ByteArrayOutputStream generate(String body, String skin) throws IOException {
        ByteArrayOutputStream png = new ByteArrayOutputStream();

        LOGGER.info("Input is: " + body);
        LOGGER.info("Using skin: " + skin);

//        List<String> config = new ArrayList<>();
//        config.add(skins.getSkin(skin));

        List<String> config = skins.getSkin(skin);
        LOGGER.info("Using config: " + config);

        SourceStringReader reader = new SourceStringReader(Defines.createEmpty(),
                body, config);

        // Write the first image to "png"
        // Returns a null string if no generation
        DiagramDescription desc = reader.outputImage(png);
        return png;
//        String desc = reader.outputImage(png).getDescription();
    }
}
