package varahi.tech.NopCommerce.Adapters;

/**
 * Created by pratap.kesaboyina on 24-12-2014.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import varahi.tech.NopCommerce.Models.SingleProductShortModel;
import varahi.tech.NopCommerce.R;

public class SectionListDataAdapter extends RecyclerView.Adapter<SectionListDataAdapter.SingleItemRowHolder> {

    private ArrayList<SingleProductShortModel> itemsList;
    private Context mContext;

    public SectionListDataAdapter(Context context, ArrayList<SingleProductShortModel> itemsList) {
        this.itemsList = itemsList;
        this.mContext = context;
    }

    @Override
    public SingleItemRowHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_single_product_short_model, null);
        SingleItemRowHolder mh = new SingleItemRowHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(SingleItemRowHolder holder, int i) {

        SingleProductShortModel singleItem = itemsList.get(i);

        holder.tvTitle.setText(singleItem.getProductName());
        Picasso.with(mContext).load(singleItem.getProductImageURL()).placeholder(R.drawable.nop_logo)
                .error(R.drawable.ic_menu_slideshow).into(holder.imageView_productImage);
        holder.textView_Price_single_Item.setText(singleItem.getProductPrice()+"");
        //holder.ratingBar_singleProduct.setProgress((int)singleItem.getProductRating());
        holder.ratingBar_singleProduct.setRating((float) singleItem.getProductRating());
       /* Glide.with(mContext)
                .load(feedItem.getImageURL())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .error(R.drawable.bg)
                .into(feedListRowHolder.thumbView);*/
    }

    @Override
    public int getItemCount() {
        return (null != itemsList ? itemsList.size() : 0);
    }

    public class SingleItemRowHolder extends RecyclerView.ViewHolder {

        protected TextView tvTitle, textView_Price_single_Item;
        protected ImageView imageView_productImage;
        protected RatingBar ratingBar_singleProduct;

        public SingleItemRowHolder(View view) {
            super(view);

            this.tvTitle = (TextView) view.findViewById(R.id.textView_productNameShort);
            this.imageView_productImage = (ImageView) view.findViewById(R.id.imageView_productImage);
            this.textView_Price_single_Item = (TextView) view.findViewById(R.id.textView_Price_single_Item);
            this.ratingBar_singleProduct = (RatingBar) view.findViewById(R.id.ratingBar_singleProduct);

            /*view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), tvTitle.getText(), Toast.LENGTH_SHORT).show();

                }
            });*/

        }
    }
}