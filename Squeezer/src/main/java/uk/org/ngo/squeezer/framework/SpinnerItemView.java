/*
 * Copyright (c) 2015 Google Inc.  All Rights Reserved.
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

package uk.org.ngo.squeezer.framework;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import uk.org.ngo.squeezer.Util;

/**
 * Base class for item views that can be shown in a spinner.
 *
 * @param <T> The type of the item to show.
 */
public abstract class SpinnerItemView<T extends Item> extends BaseItemView<T> {

    public SpinnerItemView(@NonNull ItemListActivity activity) {
        super(activity);
    }

    public View getDropDownAdapterView(View convertView, ViewGroup parent, int position, @NonNull T item) {
        return Util.getSpinnerDropDownView(getActivity(), convertView, parent, item.getName());
    }

    public View getDropDownAdapterView(View convertView, ViewGroup parent, String text) {
        return Util.getSpinnerDropDownView(getActivity(), convertView, parent, text);
    }
}
