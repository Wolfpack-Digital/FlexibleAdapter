package eu.davidea.flexibleadapter.helpers;

import eu.davidea.flexibleadapter.R;

import static eu.davidea.flexibleadapter.FlexibleAdapter.DIRECTION_DOWN;
import static eu.davidea.flexibleadapter.FlexibleAdapter.DIRECTION_TOP;

/**
 * Created by Vlad on 17/06/2017.
 */

public class EndlessScrollState implements EndlessScrollStateInterface {
    boolean mIsTopEnabled;
    boolean mIsBottomEnabled;
    boolean mIsBidirectional;
    private boolean mTopLoading;
    private boolean mBottomLoading;

    public EndlessScrollState() {
    }

    public EndlessScrollState(boolean isBidirectional) {
        mIsBidirectional = isBidirectional;
    }

    public boolean isBidirectional() {
        return mIsBidirectional;
    }

    @Override
    public void setBidirectional(boolean isBidirectional) {
        mIsBidirectional = isBidirectional;
    }

    public void setTopLoading(boolean mTopLoading) {
        this.mTopLoading = mTopLoading;
    }

    public void setBottomLoading(boolean mBottomLoading) {
        this.mBottomLoading = mBottomLoading;
    }

    @Override
    public boolean isLoading() {
        return mTopLoading || mBottomLoading;
    }

    @Override
    public boolean isLoading(int direction) {
        if (direction == DIRECTION_TOP)
            return mTopLoading;

        return mBottomLoading;
    }

    @Override
    public void setLoading(boolean loading) {
        if (isBidirectional()) {
            throw new RuntimeException(Thread.currentThread().getStackTrace()[0].getMethodName() + " " + R.string.error_should_not_be_called_bidirectional);
        }

        mTopLoading = loading;
        mBottomLoading = loading;
    }

    @Override
    public void setLoading(boolean isLoading, int direction) {
        if (isBidirectional()) {
            if (direction == DIRECTION_TOP) {
                mTopLoading = isLoading;
            } else {
                mBottomLoading = isLoading;
            }
        } else {
            mTopLoading = isLoading;
            mBottomLoading = isLoading;
        }
    }

    @Override
    public boolean isTopEnabled() {
        return mIsTopEnabled;
    }

    @Override
    public boolean isBottomEnabled() {
        return mIsBottomEnabled;
    }

    @Override
    public boolean isEnabled() {
        return mIsTopEnabled || mIsBottomEnabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        mIsTopEnabled = enabled;
        mIsBottomEnabled = enabled;
    }

    @Override
    public void disableDirection(int direction) {
        switch (direction) {
            case DIRECTION_TOP:
                mIsTopEnabled = false;
                break;
            case DIRECTION_DOWN:
                mIsBottomEnabled = false;
                break;
        }
    }

    @Override
    public void disable() {
        mIsTopEnabled = mIsBottomEnabled = false;
    }
}
