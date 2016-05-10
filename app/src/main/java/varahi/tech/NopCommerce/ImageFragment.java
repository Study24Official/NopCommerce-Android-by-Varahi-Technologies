package varahi.tech.NopCommerce;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View imageView = inflater.inflate(R.layout.fragment_image, container, false);

        String URL = getArguments().getString("ImageURL");

        ImageView imageViewHeader = (ImageView) imageView.findViewById(R.id.imageView_childFragmentImage);

        Picasso.with(getActivity()).load(URL).placeholder(R.drawable.nop_logo)
                .error(R.drawable.ic_menu_slideshow).into(imageViewHeader);

        return imageView;
    }
}
