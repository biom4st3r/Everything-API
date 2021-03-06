/*
 *     Copyright (C) 2020 Fabric Community
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.fabriccommunity.everything.api.event.v4;

import com.mojang.datafixers.util.Unit;
import io.github.fabriccommunity.everything.api.functional.IO;

/**
 * A simple implementation of {@link VetoableEvent}.
 */
public abstract class AbstractVetoableEvent implements VetoableEvent {
    private boolean vetoed = false;

    @Override
    public IO<Boolean> isVetoed() {
        return () -> vetoed;
    }

    @Override
    public IO<Unit> veto() {
        return () -> {
            vetoed = true;
            return Unit.INSTANCE;
        };
    }
}
