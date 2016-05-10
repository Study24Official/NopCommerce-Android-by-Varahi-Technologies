package varahi.tech.NopCommerce;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.PageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import varahi.tech.NopCommerce.Adapters.Fragment_Pager;
import varahi.tech.NopCommerce.Adapters.RecyclerViewDataAdapter;
import varahi.tech.NopCommerce.Models.MultipleProductsModel;
import varahi.tech.NopCommerce.Models.SingleProductShortModel;

public class HomeFragment extends Fragment{

    PageIndicator mIndicator;
    Timer swipeTimer;
    int currentPage = 0;
    ArrayList<String> URLs;
    ArrayList<MultipleProductsModel> allSampleData;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View homeView = inflater.inflate(R.layout.fragment_home, container, false);

        URLs = new ArrayList<>();
        URLs.add("http://demo.nopcommerce.com/content/images/thumbs/0000075_banner_1.jpg");
        URLs.add("http://demo.nopcommerce.com/content/images/thumbs/0000076_banner_2.jpg");
        URLs.add("http://demo.nopcommerce.com/content/images/thumbs/0000075_banner_1.jpg");
        URLs.add("http://demo.nopcommerce.com/content/images/thumbs/0000076_banner_2.jpg");

        /** Getting a reference to the ViewPager defined the layout file */
        final ViewPager pager = (ViewPager) homeView.findViewById(R.id.childFragmentContainer);

        /** Getting fragment manager */
        FragmentManager fm = getChildFragmentManager();

        /** Instantiating FragmentPagerAdapter */
        Fragment_Pager pagerAdapter = new Fragment_Pager(fm, URLs);

        /** Setting the pagerAdapter to the pager object */
        pager.setAdapter(pagerAdapter);

        mIndicator = (CirclePageIndicator) homeView.findViewById(R.id.indicator);
        mIndicator.setViewPager(pager);

        swipeTimer = new Timer();
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == Fragment_Pager.PAGE_COUNT) {
                    currentPage = 0;
                }
                pager.setCurrentItem(currentPage++, true);
            }
        };

        swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 500, 3000);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        allSampleData = new ArrayList<>();
        createDummydata();
        RecyclerViewHeader header = (RecyclerViewHeader) homeView.findViewById(R.id.header);

        RecyclerView my_recycler_view = (RecyclerView) homeView.findViewById(R.id.my_recycler_view);

        my_recycler_view.setHasFixedSize(false);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(getActivity(), allSampleData);

        my_recycler_view.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));

        my_recycler_view.setAdapter(adapter);

        header.attachTo(my_recycler_view);
        return homeView;
    }

    private void createDummydata() {
        MultipleProductsModel multipleProducts;
        SingleProductShortModel singleItemModel;
        ArrayList<SingleProductShortModel> singleItemList;

        singleItemList = new ArrayList<>();
        multipleProducts = new MultipleProductsModel();

        multipleProducts.setProductCatagory("Electronics");

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg");
        singleItemModel.setProductName("Apple MacBook Pro");
        singleItemModel.setProductPrice(1800.00);
        singleItemModel.setProductRating(4.30);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000020_build-your-own-computer_415.jpeg");
        singleItemModel.setProductName("Virtuel Gift Card");
        singleItemModel.setProductPrice(1200.00);
        singleItemModel.setProductRating(3.20);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000026_asus-n551jk-xo076h-laptop_415.jpeg");
        singleItemModel.setProductName("Asus N551JK-XO076H Laptop");
        singleItemModel.setProductPrice(255.00);
        singleItemModel.setProductRating(2.90);
        singleItemList.add(singleItemModel);

        multipleProducts.setAllProductsInCatagory(singleItemList);
        allSampleData.add(multipleProducts);

        singleItemList = new ArrayList<>();
        multipleProducts = new MultipleProductsModel();

        multipleProducts.setProductCatagory("Computers");

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000022_digital-storm-vanquish-3-custom-performance-pc_415.jpeg");
        singleItemModel.setProductName("Digital Storm VANQUISH 3 Custom Performance PC");
        singleItemModel.setProductPrice(27.56);
        singleItemModel.setProductRating(1.80);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000030_hp-envy-6-1180ca-156-inch-sleekbook_415.jpeg");
        singleItemModel.setProductName("HP Envy 6-1180ca 15.6-Inch Sleekbook\n");
        singleItemModel.setProductPrice(15.00);
        singleItemModel.setProductRating(2.76);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000024_apple-macbook-pro-13-inch_415.jpeg");
        singleItemModel.setProductName("Levi's 511 Jeans");
        singleItemModel.setProductPrice(35.00);
        singleItemModel.setProductRating(1.60);
        singleItemList.add(singleItemModel);

        multipleProducts.setAllProductsInCatagory(singleItemList);
        allSampleData.add(multipleProducts);


        singleItemList = new ArrayList<>();
        multipleProducts = new MultipleProductsModel();

        multipleProducts.setProductCatagory("Apperal");

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000051_adidas-consortium-campus-80s-running-shoes_415.jpg");
        singleItemModel.setProductName("adidas Consortium Campus 80s Running Shoes");
        singleItemModel.setProductPrice(27.56);
        singleItemModel.setProductRating(3.80);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000057_custom-t-shirt_415.jpeg");
        singleItemModel.setProductName("Custom T-Shirt");
        singleItemModel.setProductPrice(15.00);
        singleItemModel.setProductRating(2.75);
        singleItemList.add(singleItemModel);

        singleItemModel = new SingleProductShortModel();
        singleItemModel.setProductImageURL("http://demo.nopcommerce.com/content/images/thumbs/0000058_levis-511-jeans_415.jpg");
        singleItemModel.setProductName("Levi's 511 Jeans");
        singleItemModel.setProductPrice(35.00);
        singleItemModel.setProductRating(3.60);
        singleItemList.add(singleItemModel);

        multipleProducts.setAllProductsInCatagory(singleItemList);
        allSampleData.add(multipleProducts);
    }

}
