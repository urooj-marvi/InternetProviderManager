package com.urooj.internetprovidermanager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new AllFragment();
            case 1:
                return new PendingFragment();
            case 2:
                return new PaidFragment();
            default:
                return new AllFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3; // Total number of fragments
    }
}
