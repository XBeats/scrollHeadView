package com.aitangba.testproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.aitangba.testproject.baseui.test.LoadingTestActivity;
import com.aitangba.testproject.cornerrectangle.CornerRectangleActivity;
import com.aitangba.testproject.customswipe.CustomSwipeActivity;
import com.aitangba.testproject.edgeeffect.EffectActivity;
import com.aitangba.testproject.horizonscroll.HorizonScrollActivity;
import com.aitangba.testproject.horizonscroll.HorizonScrollTestActivity;
import com.aitangba.testproject.irregularview.IrregularViewActivity;
import com.aitangba.testproject.lightadapter.viewmodel.LightAdapterActivity;
import com.aitangba.testproject.loadingview.LoadViewActivity;
import com.aitangba.testproject.multiadapter.ui.MultiAdapterActivity;
import com.aitangba.testproject.numberpicker.NumberPickerActivity;
import com.aitangba.testproject.paging.PagingListViewActivity;
import com.aitangba.testproject.path.PathActivity;
import com.aitangba.testproject.progressbar.ProgressbarActivity;
import com.aitangba.testproject.removeitem.RemoveItemActivity;
import com.aitangba.testproject.slideback.slidingmenu.SlidingMenuActivity;
import com.aitangba.testproject.ubb.UbbActivity;
import com.aitangba.testproject.verticalnestedscroll.listview.ListViewActivity;
import com.aitangba.testproject.verticalnestedscroll.nestedscrollview.NestedScrollActivity;
import com.aitangba.testproject.viewpager.ViewPageActivity;
import com.aitangba.testproject.wheelview.WheelViewActivity;
import com.aitangba.testproject.youtube.YoutubeActivity;

/**
 * Created by fhf11991 on 2016/6/22.
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_number_picker_activity:
                startActivity(NumberPickerActivity.class);
                break;
            case R.id.bt_horizon_scroll:
                startActivity(HorizonScrollActivity.class);
                break;
            case R.id.bt_vertical_scroll:
                startActivity(ListViewActivity.class);
                break;
            case R.id.bt_custom_swipe:
                startActivity(CustomSwipeActivity.class);
                break;
            case R.id.bt_horizon_scroll_test:
                startActivity(HorizonScrollTestActivity.class);
                break;
            case R.id.bt_multi_adapter:
                startActivity(MultiAdapterActivity.class);
                break;
            case R.id.bt_view_page:
                startActivity(ViewPageActivity.class);
                break;
            case R.id.bt_corner_text:
                startActivity(CornerRectangleActivity.class);
                break;
            case R.id.bt_scroll_activity:
                startActivity(SlidingMenuActivity.class);
                break;
            case R.id.bt_horizon_scroll_activity:
                startActivity(com.aitangba.testproject.horizonscrollview.HorizonScrollActivity.class);
                break;
            case R.id.bt_youtube_activity:
                startActivity(YoutubeActivity.class);
                break;
            case R.id.bt_effect_activity:
                startActivity(EffectActivity.class);
                break;
            case R.id.bt_progressbar_activity:
                startActivity(ProgressbarActivity.class);
                break;
            case R.id.bt_path_activity:
                startActivity(PathActivity.class);
                break;
            case R.id.bt_wheel_view:
                startActivity(WheelViewActivity.class);
                break;
            case R.id.bt_nested_scroll:
                startActivity(NestedScrollActivity.class);
                break;
            case R.id.bt_light_adapter:
                startActivity(LightAdapterActivity.class);
                break;
            case R.id.bt_loading_view_activity:
                startActivity(LoadViewActivity.class);
                break;
            case R.id.bt_ubb_activity:
                startActivity(UbbActivity.class);
                break;
            case R.id.bt_login_activity:
                startActivity(com.aitangba.testproject.login.MainActivity.class);
                break;
            case R.id.bt_remove_item_activity:
                startActivity(RemoveItemActivity.class);
                break;
            case R.id.bt_irregular_view_activity:
                startActivity(IrregularViewActivity.class);
                break;
            case R.id.bt_loading_activity:
//                startActivity(LoadingTestActivity.class);
                startActivity(PagingListViewActivity.class);
                break;
            default:break;
        }
    }

    private void startActivity(Class<?> activityClass) {
        if(activityClass != null) {
            startActivity(new Intent(this, activityClass));
        }
    }
}
