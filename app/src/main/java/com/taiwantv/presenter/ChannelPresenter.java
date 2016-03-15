package com.taiwantv.presenter;

import android.graphics.drawable.Drawable;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.Presenter;
import android.view.ViewGroup;

import com.taiwantv.R;
import com.taiwantv.model.Channel;

/**
 * Created by WilsonHuang-PC on 2016/3/11.
 */
public class ChannelPresenter extends Presenter {
    private static int sSelectedBackgroundColor;//取得焦點的顏色
    private static int sDefaultBackgroundColor;//預設的顏色(未取得焦點)
    private static final int MAIN_IMAGE_WIDTH = 313;
    private static final int MAIN_IMAGE_HEIGHT = 176;
    private Drawable mDefaultCardImage;
    private Drawable mDefaultCardBage;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        sSelectedBackgroundColor = parent.getResources().getColor(R.color.selected_background);
        sDefaultBackgroundColor = parent.getResources().getColor(R.color.default_background);
        mDefaultCardImage = parent.getResources().getDrawable(R.drawable.default_card_image);
        mDefaultCardBage = parent.getResources().getDrawable(R.drawable.image_card_view_bage);
        ImageCardView imageCardView = new ImageCardView(parent.getContext()) {
            @Override
            public void setSelected(boolean selected) {
                updateCardBackgroundColor(this, selected);
                super.setSelected(selected);
            }
        };

        //開啟接收來自遙控器方向鍵(D-pad)的焦點控制
        imageCardView.setFocusable(true);
        imageCardView.setFocusableInTouchMode(true);

        //預設卡片的顏色為未取得焦點的顏色(未被選中)
        updateCardBackgroundColor(imageCardView, false);
        return new ViewHolder(imageCardView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        Channel channel = (Channel) item;
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        imageCardView.setTitleText(channel.getName());
        imageCardView.setMainImageDimensions(MAIN_IMAGE_WIDTH, MAIN_IMAGE_HEIGHT);
        imageCardView.setMainImage(mDefaultCardImage);
        imageCardView.setBadgeImage(mDefaultCardBage);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
        ImageCardView imageCardView = (ImageCardView) viewHolder.view;
        imageCardView.setMainImage(null);
        imageCardView.setBadgeImage(null);
    }

    /**
     * 更換背景顏色
     *
     * @param imageCardView 要被更換的imageCardView
     * @param selected      imageCardView是否取得焦點
     */
    private void updateCardBackgroundColor(ImageCardView imageCardView, boolean selected) {
        int color = selected ? sSelectedBackgroundColor : sDefaultBackgroundColor;
        imageCardView.setBackgroundColor(color);
        imageCardView.findViewById(R.id.info_field).setBackgroundColor(color);
    }
}
