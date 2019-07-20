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

import xyz.tomd.diagonal.model.Skin;
import xyz.tomd.diagonal.repository.SkinsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayOutputStream;
import java.util.Set;

@Path("/repository")
public class SkinResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(SkinResource.class);

    @Inject
    SkinsRepository skinsRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<String> list() {
        return skinsRepository.getSkinKeys();
    }

}