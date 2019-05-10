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

package com.cleverbuilder.diagonal.skins;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.*;

/**
 * A basic in-memory (simple) repository of skins (plantuml config) for diagrams.
 */
@ApplicationScoped
@Named("simpleSkinsRepository")
public class SimpleSkinsRepository implements SkinsRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSkinsRepository.class);

    private Map<String, List<String>> skins = new HashMap<>();

    public SimpleSkinsRepository() {
        skins.put("modern", Arrays.asList(
                "skinparam dpi 400",
                "skinparam DefaultFontName Carlito",
                "skinparam Shadowing false",
                "skinparam Padding 3",
                "skinparam BackgroundColor Gold",
                "skinparam ParticipantFontStyle bold"));

        skins.put("bradford", Arrays.asList(
                "skinparam dpi 400",
                "skinparam DefaultFontName Overpass",
                "skinparam Shadowing false",
                "skinparam Padding 3",
                "skinparam ParticipantFontStyle bold"));
    }

    public void setSkins(Map<String, List<String>> skins) {
        this.skins = skins;
    }

    public List<String> getSkin(String key) {
        return skins.get(key);
    }

    public Set<String> getSkinKeys() { return skins.keySet(); }

}
