package com.taqaddus.secure;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabsAccessorAdapter extends FragmentPagerAdapter {

    public TabsAccessorAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                single_page single_page=new single_page();
                return single_page;
            case 1:
                dual_page dual_page=new dual_page();
                return dual_page;
            case 2:
                multi_page multiwebpage=new multi_page();
                return multiwebpage;

                default:
                    return null;

        }


    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Single Page";
            case 1:
                return "Dual Page";
            case 2:
                return "MultiPage";
                default:
                    return null;
        }
    }
}
