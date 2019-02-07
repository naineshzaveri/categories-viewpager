package com.example.cleartripassg.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cleartripassg.R;
import com.example.cleartripassg.model.YouCategory;
import com.example.cleartripassg.utils.ViewType;

import java.util.ArrayList;

/**
 * Created by Nainesh Zaveri on 04/02/19.
 */
public class YouAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Object> values;
    private Context mContext;


    public class MiscHolder extends RecyclerView.ViewHolder {

        private TextView label;
        private ImageView imageView;

        public MiscHolder(View v) {
            super(v);
            label = (TextView) v.findViewById(R.id.txt_name_mis);
            imageView = (ImageView) v.findViewById(R.id.iv_misc);
        }

        public ImageView getImageView() {
            return imageView;
        }

        public void setImageView(ImageView imageView) {
            this.imageView = imageView;
        }

        public TextView getLabel() {
            return label;
        }

        public void setLabel(TextView label) {
            this.label = label;
        }
    }

    public class ViewHolderLabel extends RecyclerView.ViewHolder {

        private TextView label;

        public ViewHolderLabel(View v) {
            super(v);
            label = (TextView) v.findViewById(R.id.txt_label);
        }

        public TextView getLabel() {
            return label;
        }

        public void setLabel(TextView label) {
            this.label = label;
        }
    }

    public class ViewHolderSignIn extends RecyclerView.ViewHolder {


        public ViewHolderSignIn(View v) {
            super(v);

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public YouAdapter(ArrayList<Object> myDataset, Context context) {
        values = myDataset;
        mContext = context;
    }


    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return this.values.size();
    }

    @Override
    public int getItemViewType(int position) {
        YouCategory youCategory = (YouCategory) values.get(position);
        if (youCategory.getType() == ViewType.SIGN_CREATE) {
            return ViewType.SIGN_CREATE;
        } else if (youCategory.getType() == ViewType.MISC) {
            return ViewType.MISC;
        } else if (youCategory.getType() == ViewType.LABEL) {
            return ViewType.LABEL;
        } else if (youCategory.getType() == ViewType.YOUR_ORDERs) {
            return ViewType.YOUR_ORDERs;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case ViewType.SIGN_CREATE:
                View v1 = inflater.inflate(R.layout.row_signin, viewGroup, false);
                viewHolder = new ViewHolderLabel(v1);
                break;
            case ViewType.MISC:
                View v2 = inflater.inflate(R.layout.row_misc, viewGroup, false);
                viewHolder = new MiscHolder(v2);
                break;
            case ViewType.YOUR_ORDERs:
                View v3 = inflater.inflate(R.layout.row_misc, viewGroup, false);
                viewHolder = new MiscHolder(v3);
                break;
            case ViewType.LABEL:
                View v4 = inflater.inflate(R.layout.row_label, viewGroup, false);
                viewHolder = new ViewHolderLabel(v4);
                break;
            default:
                View v5 = inflater.inflate(R.layout.row_label, viewGroup, false);
                viewHolder = new ViewHolderLabel(v5);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case ViewType.SIGN_CREATE:
                break;
            case ViewType.MISC:
                setMiscHolder((MiscHolder) viewHolder, position);
                break;
            case ViewType.YOUR_ORDERs:
                setOrderHolder((MiscHolder) viewHolder, position);
                break;
            case ViewType.LABEL:
                setLabelHolder((ViewHolderLabel) viewHolder, position);
                break;
            default:
                setLabelHolder((ViewHolderLabel) viewHolder, position);
                break;
        }
    }

    private void setLabelHolder(ViewHolderLabel viewHolderLabel, int position) {
        YouCategory youCategory = (YouCategory) values.get(position);
        viewHolderLabel.getLabel().setText(youCategory.getText());
    }

    private void setMiscHolder(MiscHolder viMiscHolder, int position) {
        YouCategory youCategory = (YouCategory) values.get(position);
        viMiscHolder.getLabel().setText(youCategory.getText());
        viMiscHolder.getImageView().setImageDrawable(youCategory.getImage());

    }

    private void setOrderHolder(MiscHolder vMiscHolder, int position) {
        YouCategory youCategory = (YouCategory) values.get(position);
        vMiscHolder.getLabel().setText(Html.fromHtml(youCategory.getText()));
        vMiscHolder.getImageView().setImageDrawable(youCategory.getImage());
    }
}