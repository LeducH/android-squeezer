package uk.org.ngo.squeezer.menu;

import uk.org.ngo.squeezer.R;
import uk.org.ngo.squeezer.SettingsActivity;
import uk.org.ngo.squeezer.NowPlayingActivity;
import uk.org.ngo.squeezer.SqueezerHomeActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


public class SqueezerMenuFragment extends MenuFragment {

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.itemlistmenu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            NowPlayingActivity.show(getActivity());
            return true;
        case R.id.menu_item_home:
            SqueezerHomeActivity.show(getActivity());
            return true;
        case R.id.menu_item_settings:
            SettingsActivity.show(getActivity());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
