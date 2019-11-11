package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdopter extends FragmentPagerAdapter {
    public TabAdopter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int tabposition) {
        switch (tabposition){
            case 0:
                Profile_Tab profile_tab = new Profile_Tab();
                return profile_tab;

            case 1:
                User_Tab user_tab = new User_Tab();
                return user_tab;

            case 2:
                Share_Tab share_tab=new Share_Tab();
                return share_tab;

        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Profile";
            case 1: return "User";
            case 2: return "Shared";

        }


    }
}
