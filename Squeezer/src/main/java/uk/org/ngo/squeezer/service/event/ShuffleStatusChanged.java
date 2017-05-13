/*
 * Copyright (c) 2014 Google Inc.  All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.org.ngo.squeezer.service.event;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;

import uk.org.ngo.squeezer.model.Player;
import uk.org.ngo.squeezer.model.PlayerState;

/** Event sent when the shuffle status of the player has changed. */
@AutoValue
public abstract class ShuffleStatusChanged {
    /** The player with changed state. */
    @NonNull public abstract Player player();

    /** True if the previous shuffle status was unknown. */
    public abstract boolean initial();

    /** The new shuffle status. */
    @NonNull
    public abstract PlayerState.ShuffleStatus shuffleStatus();

    public static ShuffleStatusChanged create(@NonNull Player player, boolean initial, @NonNull PlayerState.ShuffleStatus shuffleStatus) {
        return new AutoValue_ShuffleStatusChanged(player, initial, shuffleStatus);
    }
}
