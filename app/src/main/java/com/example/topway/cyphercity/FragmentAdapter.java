package com.example.topway.cyphercity;

import android.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {
   // private int[] images={R.drawable.img_dash_board,R.drawable.my_uploads,R.drawable.my_account};
    private String[] str={"Dash_Board","My_Uploads","My_Profile"};
    private int totalFragments=3;

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
         Fragment fragment;
        switch (position){
            case 0:
                fragment=FragmentDashBoard.getInstance();
              break;
            case 1:
                fragment=FragmentMyUploads.getInstance();
                break;
            case 2:
                fragment=FragmentMyProfile.getInstance();
                break;
                default:
                    fragment=null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return totalFragments;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
