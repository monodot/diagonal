package com.cleverbuilder.diagramapp.skins;

import java.util.List;
import java.util.Set;

/**
 * Interface for a service that returns skin (config) details.
 */
public interface SkinsRepository {

    List<String> getSkin(String key);

    Set<String> getSkinKeys();

}
