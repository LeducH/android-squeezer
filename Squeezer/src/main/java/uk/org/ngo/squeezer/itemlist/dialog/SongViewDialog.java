package uk.org.ngo.squeezer.itemlist.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import uk.org.ngo.squeezer.R;
import uk.org.ngo.squeezer.framework.EnumWithTextAndIcon;
import uk.org.ngo.squeezer.framework.VersionedEnumWithText;
import uk.org.ngo.squeezer.model.Song;
import uk.org.ngo.squeezer.service.ServerString;

public class SongViewDialog extends BaseViewDialog<Song, SongViewDialog.SongListLayout, SongViewDialog.SongsSortOrder> {
    private static final String TAG = SongViewDialog.class.getSimpleName();

    @Override
    protected String getTitle() {
        return getString(R.string.song_display_options);
    }

    /**
     * Supported song list layouts.
     */
    public enum SongListLayout implements EnumWithTextAndIcon {
        grid(R.attr.ic_action_view_as_grid, ServerString.SWITCH_TO_GALLERY),
        list(R.attr.ic_action_view_as_list, ServerString.SWITCH_TO_EXTENDED_LIST);

        /**
         * The icon to use for this layout
         */
        private final int iconAttribute;

        @Override
        public int getIconAttribute() {
            return iconAttribute;
        }

        /**
         * The text to use for this layout
         */
        private final ServerString serverString;

        @Override
        public String getText(Context context) {
            return serverString.getLocalizedString();
        }

        SongListLayout(int iconAttribute, ServerString serverString) {
            this.serverString = serverString;
            this.iconAttribute = iconAttribute;
        }

    }

    /**
     * Sort order strings supported by the server.
     * <p>
     * Values must correspond with the string expected by the server. Any '__' in the strings will
     * be removed.
     */
    public enum SongsSortOrder implements VersionedEnumWithText {
        title(R.string.songs_sort_order_title, ""),
        tracknum(R.string.songs_sort_order_tracknum, ""),
        albumtrack(R.string.songs_sort_order_albumtrack, "7.6");

        /** The text to use for this ordering */
        private final int stringResource;

        /** Supported since (server version) */
        private final String since;

        @Override
        public boolean can(String version) {
            return (version.compareTo(since) >= 0);
        }

        @Override
        public String getText(Context context) {
            return context.getText(stringResource).toString();
        }

        SongsSortOrder(int stringResource, String since) {
            this.stringResource = stringResource;
            this.since = since;
        }
    }

    public static SongViewDialog showDialog(FragmentManager fragmentManager, String serverVersion) {
        SongViewDialog dialog = new SongViewDialog();
        Bundle args = new Bundle();
        args.putString("version", serverVersion);
        dialog.setArguments(args);
        dialog.show(fragmentManager, TAG);
        return dialog;
    }
}
