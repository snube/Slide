package me.ccrama.redditslide.Activities;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.TextView;

import me.ccrama.redditslide.R;
import me.ccrama.redditslide.SettingValues;


/**
 * Created by l3d00m on 11/13/2015.
 */
public class SettingsHandling extends BaseActivityAnim implements
        CompoundButton.OnCheckedChangeListener {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyColorTheme();
        setContentView(R.layout.activity_settings_handling);
        setupAppBar(R.id.toolbar, R.string.settings_link_handling, true, true);

        TextView web = (TextView) findViewById(R.id.browser);

        //todo web stuff
        SwitchCompat image = (SwitchCompat) findViewById(R.id.image);
        SwitchCompat gif = (SwitchCompat) findViewById(R.id.gif);
        SwitchCompat album = (SwitchCompat) findViewById(R.id.album);
        SwitchCompat video = (SwitchCompat) findViewById(R.id.video);


        image.setChecked(SettingValues.image);
        gif.setChecked(SettingValues.gif);
        album.setChecked(SettingValues.album);
        video.setChecked(SettingValues.video);

        image.setOnCheckedChangeListener(this);
        gif.setOnCheckedChangeListener(this);
        album.setOnCheckedChangeListener(this);
        video.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.web:
                SettingValues.web = isChecked;
                (((SwitchCompat) findViewById(R.id.chrome))).setEnabled(isChecked);
                SettingValues.prefs.edit().putBoolean(SettingValues.PREFS_WEB, isChecked).apply();
                break;
            case R.id.image:
                SettingValues.image = isChecked;
                SettingValues.prefs.edit().putBoolean(SettingValues.PREF_IMAGE, isChecked).apply();
                break;
            case R.id.gif:
                SettingValues.gif = isChecked;
                SettingValues.prefs.edit().putBoolean(SettingValues.PREF_GIF, isChecked).apply();
                break;
            case R.id.album:
                SettingValues.album = isChecked;
                SettingValues.prefs.edit().putBoolean(SettingValues.PREF_ALBUM, isChecked).apply();
                break;
            case R.id.video:
                SettingValues.video = isChecked;
                SettingValues.prefs.edit().putBoolean(SettingValues.PREF_VIDEO, isChecked).apply();
                break;
        }

    }

}