package eu.davidea.flexibleadapter.helpers;

/**
 * Created by Vlad on 17/06/2017.
 */

public interface EndlessScrollStateInterface {
    boolean isLoading();

    void setLoading(boolean loading);

    void setLoading(boolean loading, int direction);

    boolean isLoading(int direction);

    boolean isTopEnabled();

    boolean isBottomEnabled();

    boolean isEnabled();

    void setEnabled(boolean enabled);

    void disableDirection(int direction);

    void disable();

    public boolean isBidirectional();

    void setBidirectional(boolean enabled);

}
