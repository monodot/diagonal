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

import java.util.List;
import java.util.Set;

/**
 * Interface for a service that returns skin (config) details.
 */
public interface SkinsRepository {

    List<String> getSkin(String key);

    Set<String> getSkinKeys();

}
