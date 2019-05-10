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

package com.cleverbuilder.diagonal.diagrams;

import com.cleverbuilder.diagonal.skins.SkinsRepository;
import net.sourceforge.plantuml.SourceStringReader;
import net.sourceforge.plantuml.core.DiagramDescription;
import net.sourceforge.plantuml.preproc.Defines;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class DiagramService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagramService.class);

    @Inject
    SkinsRepository skins;

    public ByteArrayOutputStream generate(String body, String skin) throws IOException {
        ByteArrayOutputStream png = new ByteArrayOutputStream();

        LOGGER.debug("Input is: " + body);
        LOGGER.debug("Using skin: " + skin);

        List<String> config = skins.getSkin(skin);
        LOGGER.debug("Using config: " + config);

        SourceStringReader reader = new SourceStringReader(Defines.createEmpty(),
                body, config);

        // Write the first image to "png"
        // Returns a null string if no generation
        DiagramDescription desc = reader.outputImage(png);
        return png;
    }
}
