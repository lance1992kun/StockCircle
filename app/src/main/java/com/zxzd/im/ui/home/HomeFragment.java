package com.zxzd.im.ui.home;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.github.clans.fab.FloatingActionMenu;
import com.zxzd.im.R;
import com.zxzd.im.data.adapter.HomeHeadLineAdapter;
import com.zxzd.im.data.entity.HeadLineBannerBean;
import com.zxzd.im.data.entity.HeadLineBean;
import com.zxzd.im.data.entity.HeadLineLimitBean;
import com.zxzd.im.data.entity.HeadLineNewsBean;
import com.zxzd.im.data.entity.HeadLineNoticeBean;
import com.zxzd.im.data.entity.HeadLineWeekNewsBean;
import com.zxzd.im.util.DialogUtil;
import com.zxzd.im.util.ImageUtil;
import com.zxzd.im.widgets.FullyLinearLayoutManager;
import com.zxzd.im.widgets.MyScrollView;
import com.syk.lib.base.BaseFragment;

import net.cpacm.library.SimpleSliderLayout;
import net.cpacm.library.indicator.ViewpagerIndicator.UnderlinePageIndicator;
import net.cpacm.library.slider.BaseSliderView;
import net.cpacm.library.slider.ImageSliderView;
import net.cpacm.library.slider.OnSliderClickListener;
import net.cpacm.library.transformers.FadeTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

import static com.zxzd.im.R.id.mQuickNewsLay;

/**
 * <pre>
 *     author : syk
 *     e-mail : shenyukun1024@gmail.com
 *     time   : 2017/11/09
 *     desc   : 首页界面
 *     version: 1.0
 * </pre>
 */

public class HomeFragment extends BaseFragment implements RadioGroup.OnCheckedChangeListener, HomeView {
    /**
     * 轮播图
     */
    private SimpleSliderLayout mBanner = null;
    /**
     * 导航栏
     */
    private RelativeLayout mTopNavigationBar = null;
    /**
     * 下划线指示器
     */
    private UnderlinePageIndicator mBannerPointer = null;
    /**
     * 头条层
     */
    private RelativeLayout mHeadLineLay = null;
    /**
     * 直播层
     */
    private RelativeLayout mLiveLay = null;
    /**
     * 今日最新轮播
     */
    private TextSwitcher mTodayNewsSwitcher = null;
    /**
     * 7*24快讯
     */
    private TextView mQuickNews = null;
    /**
     * 头条列表
     */
    private RecyclerView mHeadLineListView = null;
    /**
     * 头条数据适配器
     */
    private HomeHeadLineAdapter mHomeHeadLineAdapter = null;
    /**
     * 头条官方数据数据列表
     */
    private List<HeadLineNewsBean> mHomeHeadLineList = new ArrayList<>();
    /**
     * 首页底部展开菜单
     */
    private FloatingActionMenu mHomeMenuBtnLay = null;
    /**
     * 今日最新数据列表
     */
    private List<HeadLineNoticeBean> mHeadLineNoticeBeans = new ArrayList<>();
    /**
     * 7*24快讯
     */
    private HeadLineWeekNewsBean mWeekNewsBean = null;
    /**
     * 轮播下标
     */
    private int currentIndex = 0;
    /**
     * 是否有下一页
     */
    private boolean isHasNext = false;
    /**
     * 当先分页
     */
    private int currentPage = 0;
    /**
     * 首页内容呈现者
     */
    private HomePresenterImpl mHomePresenter = null;
    /**
     * 用来判断控件是否在布局内
     */
    private Rect rect = new Rect(0, 0, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());

    /**
     * 获取首页实例
     *
     * @return 首页实例
     */
    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 预处理数据
     *
     * @param bundle 传递过来的bundle
     */
    @Override
    public void initData(Bundle bundle) {
        // 初始化内容呈现者
        mHomePresenter = new HomePresenterImpl(this);
    }

    /**
     * 初始化布局文件
     *
     * @return 布局文件
     */
    @Override
    public int bindLayout() {
        return R.layout.fragment_home;
    }

    /**
     * 初始化控件
     *
     * @param savedInstanceState 保存的状态
     * @param view               控件
     */
    @Override
    public void initView(Bundle savedInstanceState, View view) {
        // 轮播图
        mBanner = (SimpleSliderLayout) view.findViewById(R.id.mBanner);
        // 导航栏
        mTopNavigationBar = (RelativeLayout) view.findViewById(R.id.mTopNavigationBar);
        // 轮播图指示器
        mBannerPointer = (UnderlinePageIndicator) view.findViewById(R.id.mBannerPointer);
        // 今日最新
        mTodayNewsSwitcher = (TextSwitcher) view.findViewById(R.id.mTodayNewsSwitcher);
        // 7*24快讯
        mQuickNews = (TextView) view.findViewById(R.id.mQuickNews);
        // 头条列表
        mHeadLineListView = (RecyclerView) view.findViewById(R.id.mHeadLineList);
        mHeadLineListView.setLayoutManager(new FullyLinearLayoutManager(mActivity));
        // 头条层
        mHeadLineLay = (RelativeLayout) view.findViewById(R.id.mHeadLineLay);
        // 直播层
        mLiveLay = (RelativeLayout) view.findViewById(R.id.mLiveLay);
        // 首页底部展开菜单
        mHomeMenuBtnLay = (FloatingActionMenu) view.findViewById(R.id.mHomeMenuBtnLay);
        // 设置底部展开菜单点击外部消失
        mHomeMenuBtnLay.setClosedOnTouchOutside(true);
        // 点击事件
        ((RadioGroup) view.findViewById(R.id.mHomeNavigationGroup)).setOnCheckedChangeListener(this);
        (view.findViewById(R.id.mTodayNewsLay)).setOnClickListener(this);
        (view.findViewById(R.id.mQuickNewsLay)).setOnClickListener(this);
        (view.findViewById(R.id.mHomeTextBtn)).setOnClickListener(this);
        (view.findViewById(R.id.mHomePhoneBtn)).setOnClickListener(this);
        (view.findViewById(R.id.mHomeLiveBtn)).setOnClickListener(this);
        (view.findViewById(R.id.mHomeVideoBtn)).setOnClickListener(this);
        // 滑动监听
        ((MyScrollView) view.findViewById(R.id.mHeadLineScrollView)).setScrollChangeCallBack(new MyScrollView.ScrollChangedCallBack() {
            @Override
            public void onScrollChanged() {
                if (isViewInScreen(mBanner)) {
                    mTopNavigationBar.setBackgroundResource(android.R.color.transparent);
                } else {
                    mTopNavigationBar.getBackground().setAlpha(150);
                    mTopNavigationBar.setBackgroundResource(R.color.half_transparent);
                }
            }
        });
        // 滑动到底部监听
        ((MyScrollView) view.findViewById(R.id.mHeadLineScrollView)).setScrollBottomCallBack(new MyScrollView.ScrollBottomCallBack() {
            @Override
            public void onScrollBottom() {
                if (isHasNext) {
                    mHomePresenter.getHeadLineLimitData(10, currentPage);
                }
            }
        });
    }

    /**
     * 逻辑处理
     *
     * @param context 上下文
     */
    @Override
    public void doBusiness(Context context) {
        // 获取网络数据
        mHomePresenter.getHeadLineData();
    }

    /**
     * 处理点击事件
     *
     * @param view 视图
     */
    @Override
    public void onWidgetClick(View view) {
        switch (view.getId()) {
            // 今日最新点击层
            case R.id.mTodayNewsLay:
                // 跳转
                redirect(true);
                break;
            // 7*24快讯点击层
            case mQuickNewsLay:
                // 跳转
                redirect(false);
                break;
            // 展开菜单>>>文字
            case R.id.mHomeTextBtn:
                ToastUtils.showShort("文字");
                mHomeMenuBtnLay.close(true);
                break;
            // 展开菜单>>>图片
            case R.id.mHomePhoneBtn:
                ToastUtils.showShort("图片");
                mHomeMenuBtnLay.close(true);
                break;
            // 展开菜单>>>视频
            case R.id.mHomeVideoBtn:
                ToastUtils.showShort("视频");
                mHomeMenuBtnLay.close(true);
                break;
            // 展开菜单>>>直播
            case R.id.mHomeLiveBtn:
                ToastUtils.showShort("直播");
                mHomeMenuBtnLay.close(true);
                break;
            default:
                break;
        }
    }

    /**
     * 导航栏点击事件
     *
     * @param group     哪个组
     * @param checkedId 选中的ID
     */
    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            // 头条
            case R.id.mHomeNewsRb:
                mHeadLineLay.setVisibility(View.VISIBLE);
                mLiveLay.setVisibility(View.GONE);
                break;
            // 直播
            case R.id.mHomeLiveRb:
                mHeadLineLay.setVisibility(View.GONE);
                mLiveLay.setVisibility(View.VISIBLE);
                break;
            // 热门
            case R.id.mHomeHotRb:
                mHeadLineLay.setVisibility(View.GONE);
                mLiveLay.setVisibility(View.GONE);
                break;
            // 股趣儿
            case R.id.mHomeFunnyRb:
                mHeadLineLay.setVisibility(View.GONE);
                mLiveLay.setVisibility(View.GONE);
                break;
            default:
                break;
        }
    }

    /**
     * 设置轮播资源
     *
     * @param banners 广告图列表
     */
    private void setBanner(List<HeadLineBannerBean> banners) {
        for (final HeadLineBannerBean bean : banners) {
            ImageSliderView sliderView = new ImageSliderView(mActivity);
            ImageUtil.displayImage(this, bean.getImgUrl(), sliderView.getImageView());
            sliderView.setOnSliderClickListener(new OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    ToastUtils.showShort("跳转链接>>>" + bean.getReturnUrl());
                }
            });
            mBanner.addSlider(sliderView);
        }
        // 翻页动画
        mBanner.setPageTransformer(new FadeTransformer());
        mBanner.setSliderTransformDuration(2000);
        mBanner.setViewPagerIndicator(mBannerPointer);
    }

    /**
     * 设置文字轮播
     *
     * @param noticeList   公告列表
     * @param weekNewsBean 7*24快讯
     */
    private void setTextSwitcher(List<HeadLineNoticeBean> noticeList, HeadLineWeekNewsBean weekNewsBean) {
        // 设置公告数据列表
        mHeadLineNoticeBeans.clear();
        mHeadLineNoticeBeans.addAll(noticeList);
        // 设置7*24资讯
        this.mWeekNewsBean = weekNewsBean;
        // 今日最新资讯
        mTodayNewsSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView mTextView = new TextView(mActivity);
                mTextView.setEllipsize(TextUtils.TruncateAt.END);
                mTextView.setMaxLines(1);
                mTextView.setMaxEms(14);
                return mTextView;
            }
        });
        mTodayNewsSwitcher.setInAnimation(mActivity, R.anim.animation_text_in);
        mTodayNewsSwitcher.setOutAnimation(mActivity, R.anim.animation_text_out);
        // 7*24快讯
        mQuickNews.setText(weekNewsBean.getContent());
        // 开启定时器
        Observable.interval(0, 2500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (currentIndex == mHeadLineNoticeBeans.size()) {
                            currentIndex = 0;
                        }
                        mTodayNewsSwitcher.setText(mHeadLineNoticeBeans.get(currentIndex).getTitle().trim());
                        currentIndex++;
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    /**
     * 跳转界面
     *
     * @param isNotice 是否为今日最新
     */
    private void redirect(boolean isNotice) {
        if (isNotice) {
            if (!mHeadLineNoticeBeans.isEmpty()) {
                int temp = currentIndex - 1;
                if (temp < 0) {
                    temp = 0;
                }
                ToastUtils.showShort(mHeadLineNoticeBeans.get(temp).getContent() + mHeadLineNoticeBeans.get(temp).getUrl());
            }
        } else {
            if (mWeekNewsBean != null) {
                ToastUtils.showShort(mWeekNewsBean.getContent());
            }
        }
    }

    /**
     * 初始化头条数据适配器
     *
     * @param homeHeadLineList 官方公告数据列表
     */
    private void initHeadLineAdapter(List<HeadLineNewsBean> homeHeadLineList) {
        // 数据更新
        mHomeHeadLineList.clear();
        mHomeHeadLineList.addAll(homeHeadLineList);
        // 头条列表适配器
        mHomeHeadLineAdapter = new HomeHeadLineAdapter(mHomeHeadLineList);
        // 设置数据适配器
        mHeadLineListView.setAdapter(mHomeHeadLineAdapter);
    }

    /**
     * 初始化直播数据适配器
     */
    private void initLiveAdapter() {

    }

    /**
     * 获取头条数据更新UI
     *
     * @param resultMsg 数据模型
     */
    @Override
    public void updateHeadLineView(HeadLineBean resultMsg) {
        // 是否有下一页
        isHasNext = resultMsg.isHasNext();
        // 设置轮播文字
        setTextSwitcher(resultMsg.getNotices(), resultMsg.getWeekNews());
        // 设置轮播资源
        setBanner(resultMsg.getBanners());
        // 设置官方公告数据源
        initHeadLineAdapter(resultMsg.getNewsList());
    }

    /**
     * 获取头条更多数据更新UI
     *
     * @param limitBean 数据模型
     */
    @Override
    public void updateHeadLineLimitView(HeadLineLimitBean limitBean) {
        if (limitBean.getNews_list() != null) {
            currentPage++;
            // 是否有下一页
            isHasNext = limitBean.isHasNext();
            // 刷新列表数据
            mHomeHeadLineList.addAll(limitBean.getNews_list());
            mHomeHeadLineAdapter.setNewData(mHomeHeadLineList);
            // 刷新完成
            mHomeHeadLineAdapter.loadMoreComplete();
        } else {
            ToastUtils.showShort("没有更多数据啦");
        }
    }

    /**
     * 联网失败
     *
     * @param errorMsg 错误信息
     */
    @Override
    public void showFailed(String errorMsg) {
        LogUtils.e(errorMsg);
        if (mHomeHeadLineAdapter != null) {
            // 加载更多失败
            mHomeHeadLineAdapter.loadMoreEnd();
        }
    }

    /**
     * 显示联网对话框
     *
     * @param isShow 是否显示联网对话框
     */
    @Override
    public void showDialog(boolean isShow) {
        if (isShow) {
            DialogUtil.getInstance().showNetDialog(mActivity, "正在获取联网数据……");
        } else {
            DialogUtil.getInstance().hideNetDialog();
        }
    }

    /**
     * 判断控件是否在屏幕中
     *
     * @param view 要判断的View
     * @return 是或者不是
     */
    private boolean isViewInScreen(View view) {
        return view.getLocalVisibleRect(rect);
    }
}
