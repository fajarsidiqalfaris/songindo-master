/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package androidx.leanback.leanbackshowcase.app.grid;

import android.os.Bundle;
import android.os.Handler;
import androidx.leanback.app.VerticalGridFragment;
import androidx.leanback.leanbackshowcase.R;
import androidx.leanback.leanbackshowcase.utils.Utils;
import androidx.leanback.leanbackshowcase.app.wizard.models.CardRow;
import androidx.leanback.leanbackshowcase.cards.presenters.CardPresenterSelector;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.FocusHighlight;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.VerticalGridPresenter;

import com.google.gson.Gson;

/**
 * An example how to use leanback's {@link VerticalGridFragment}.
 */
public class GridExampleFragment extends VerticalGridFragment {

    private static final int COLUMNS = 4;
    private static final int ZOOM_FACTOR = FocusHighlight.ZOOM_FACTOR_MEDIUM;

    private ArrayObjectAdapter mAdapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.grid_example_title));
        setupRowAdapter();
    }

    private void setupRowAdapter() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter(ZOOM_FACTOR);
        gridPresenter.setNumberOfColumns(COLUMNS);
        setGridPresenter(gridPresenter);

        PresenterSelector cardPresenterSelector = new CardPresenterSelector(getActivity());
        mAdapter = new ArrayObjectAdapter(cardPresenterSelector);
        setAdapter(mAdapter);

        prepareEntranceTransition();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                createRows();
                startEntranceTransition();
            }
        }, 1000);
    }

    private void createRows() {
        String json = Utils.inputStreamToString(getResources()
                .openRawResource(R.raw.grid_example));
        CardRow row = new Gson().fromJson(json, CardRow.class);
        mAdapter.addAll(0, row.getCards());
    }
}
