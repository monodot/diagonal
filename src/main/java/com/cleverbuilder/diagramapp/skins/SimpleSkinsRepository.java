package com.cleverbuilder.diagramapp.skins;

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
