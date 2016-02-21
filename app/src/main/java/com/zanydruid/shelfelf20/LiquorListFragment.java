package com.zanydruid.shelfelf20;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yizhu on 2/8/16.
 */
public class LiquorListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private LiquorAdapter mLiquorAdapter;
    private Callbacks mCallbacks;

    /**
     *
     * required interface for hosting activities.
     */
    public interface Callbacks{
        void onLiquorSelected(Liquor liquor);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mCallbacks = (Callbacks) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mCallbacks=null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Configure fragment layout
         */
        View view = inflater.inflate(R.layout.fragment_liquor_list,container,false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.liquor_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }

    public void updateUI(){
        LiquorBox liquorBox = LiquorBox.get(getActivity());
        List<Liquor> liquors = liquorBox.getLiquors();
        if(mLiquorAdapter==null){
            mLiquorAdapter = new LiquorAdapter(liquors);
            mRecyclerView.setAdapter(mLiquorAdapter);
        }else{
            mLiquorAdapter.notifyDataSetChanged();
        }
    }

    /**
     * ViewHolder class
     *
     * Configure the widgets in the a single ViewHolder
     *
     */
    private class LiquorHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nameTextView;
        private TextView priceTextView;
        private ImageView pictureImageView;
        private Liquor liquor;

        /**
         * Holder's constructor
         *
         * Attach widgets to a view, construct a viewHolder with this view
         *
         * @param itemView
         */
        public LiquorHolder(View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.list_item_name);
            priceTextView = (TextView) itemView.findViewById(R.id.list_item_price);
            pictureImageView = (ImageView) itemView.findViewById(R.id.list_item_image);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mCallbacks.onLiquorSelected(liquor);
        }

        /**
         * Parse a liquor's information to widgets
         *
         * @param liquorForBind
         */
        public void bindLiquor(Liquor liquorForBind){
            liquor = liquorForBind;
            nameTextView.setText(liquor.getName());
            double[] prices = liquor.getPrice();
            priceTextView.setText("$"+ prices[0]);
            pictureImageView.setImageResource(liquor.getImageRes());
        }
    }

    /**
     * Adapter class
     *
     * Attach instance of ViewHolders to RecyclerView
     *
     */
    private class LiquorAdapter extends RecyclerView.Adapter<LiquorHolder>{
        private List<Liquor> liquors;

        public LiquorAdapter(List<Liquor> mLiquors){
            liquors = mLiquors;
        }

        /**
         *Set up a layout for a viewHolder
         *
         * @param parent
         * @param viewType
         * @return  return this configured viewHolder
         */
        @Override
        public LiquorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.liquor_list_item,parent,false);
            return new LiquorHolder(view);
        }

        /**
         * Bind each liquors from liquors to viewHolders
         *
         * @param holder
         * @param position
         */
        @Override
        public void onBindViewHolder(LiquorHolder holder, int position) {
            Liquor liquor = liquors.get(position);
            holder.bindLiquor(liquor);
        }

        /**
         * Get the quantity of viewHolders need to create according to the size of liquors
         *
         * @return
         */
        @Override
        public int getItemCount() {
            return liquors.size();
        }
    }
}
