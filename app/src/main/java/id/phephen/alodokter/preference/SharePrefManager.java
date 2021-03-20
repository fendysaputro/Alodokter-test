package id.phephen.alodokter.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by phephen on 20,March,2021
 * https://github.com/fendysaputro
 */
public class SharePrefManager {

    public static final String CUSTOM_PREF_NAME = "User_data";

    public static String email = "email";

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public void SharedPrefManager(Context context){
        sharedPreferences = context.getSharedPreferences(CUSTOM_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveSPString(String keySP, String value){
        editor.putString(keySP, value);
        editor.commit();
    }

    public String getSPEmail(){
        return sharedPreferences.getString(email, "");
    }
}
