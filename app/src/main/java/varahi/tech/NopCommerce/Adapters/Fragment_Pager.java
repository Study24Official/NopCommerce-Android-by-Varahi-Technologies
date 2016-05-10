package varahi.tech.NopCommerce.Adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

import varahi.tech.NopCommerce.HomeFragment;
import varahi.tech.NopCommerce.ImageFragment;

/**
 * Created by prati on 20-Apr-16.
 */
public class Fragment_Pager extends FragmentPagerAdapter {

    public static int PAGE_COUNT = 0;
    private ImageFragment fragmentField;
    private ArrayList<String> URLs;
    Bundle bundle;
    public Fragment_Pager(FragmentManager fm, ArrayList<String> URLs) {
        super(fm);
        // TODO Auto-generated constructor stub
        this.URLs = URLs;
        PAGE_COUNT = this.URLs.size();
    }

    @Override
    public Fragment getItem(int position) {
        /*switch (position) {
            case 0:
                fragmentField = new ImageFragment();
                bundle = new Bundle();
                bundle.putString("ImageURL", "http://demo.nopcommerce.com/content/images/thumbs/0000075_banner_1.jpg");
                fragmentField.setArguments(bundle);
                return fragmentField;
            case 1:
                fragmentField = new ImageFragment();
                bundle = new Bundle();
                bundle.putString("ImageURL", "http://demo.nopcommerce.com/content/images/thumbs/0000076_banner_2.jpg");
                fragmentField.setArguments(bundle);
                return fragmentField;
            case 2:
                fragmentField = new ImageFragment();
                bundle = new Bundle();
                bundle.putString("ImageURL", "http://demo.nopcommerce.com/content/images/thumbs/0000075_banner_1.jpg");
                fragmentField.setArguments(bundle);
                return fragmentField;
            case 3:
                fragmentField = new ImageFragment();
                bundle = new Bundle();
                bundle.putString("ImageURL", "http://demo.nopcommerce.com/content/images/thumbs/0000076_banner_2.jpg");
                fragmentField.setArguments(bundle);
                return fragmentField;
            default:
                return null;
        }*/
        fragmentField = new ImageFragment();
        bundle = new Bundle();
        bundle.putString("ImageURL", URLs.get(position));
        fragmentField.setArguments(bundle);
        return fragmentField;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return PAGE_COUNT;
    }
}