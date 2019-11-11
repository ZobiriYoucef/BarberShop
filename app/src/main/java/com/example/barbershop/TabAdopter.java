package com.example.barbershop;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAdopter extends FragmentPagerAdapter {
    public TabAdopter( FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int tabposition) {
        switch (tabposition){
            case 0:
                Profile_Tab profile_tab = new Profile_Tab();
                return profile_tab;

            case 1:
                return new User_Tab();

            case 2:
                Share_Tab share_tab=new Share_Tab();
                return share_tab;
            default: return null;

        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return "Profile";
            case 1: return "User";
            case 2: return "Shared";
            default: return null;

        }


    }
}
