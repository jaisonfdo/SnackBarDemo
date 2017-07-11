package com.droidmentor.snackbardemo;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jaison
 */

public class SnackBarUtil
{

    /**
     * Get the snackbar view
     *
     * @param snackbar
     * @return
     */
    private static View getSnackBarLayout(Snackbar snackbar) {
        if (snackbar != null) {
            return snackbar.getView();
        }
        return null;
    }

    /**
     *  Set snackbar Background color
     *
     * @param snackbar
     * @param background
     * @return
     */

    public static Snackbar getColorfulSnackBar(final Snackbar snackbar, String background) {
        return getColorfulSnackBar(snackbar,background,null,null);
    }

    /**
     * Set snackbar background using color resource
     *
     * @param snackbar
     * @param context
     * @param background
     * @return
     */
    public static Snackbar getColorfulSnackBar(final Snackbar snackbar,Context context, int background) {
        return getColorfulSnackBar(snackbar,context,background,0,0);
    }

    /**
     * Set snackbar background & textcolor using Hex color code
     *
     * @param snackbar
     * @param background
     * @param textColor
     * @return
     */
    public static Snackbar getColorfulSnackBar(final Snackbar snackbar, String background, String textColor) {
        return getColorfulSnackBar(snackbar,background,textColor,null);
    }

    /**
     * Set snackbar background & textcolor using color resource
     *
     * @param snackbar
     * @param context
     * @param background
     * @param textColor
     * @return
     */
    public static Snackbar getColorfulSnackBar(final Snackbar snackbar,Context context, int background,int textColor) {
        return getColorfulSnackBar(snackbar,context,background,textColor,0);
    }

    /**
     * Set snackbar background, textcolor & Action button color using Hex color code
     *
     * @param snackbar
     * @param background
     * @param textColor
     * @param actionColor
     * @return
     */
    public static Snackbar getColorfulSnackBar(final Snackbar snackbar, String background, String textColor,String actionColor) {

        View snackBarView = getSnackBarLayout(snackbar);
        if (snackBarView != null) {
            if (!TextUtils.isEmpty(background))
                snackBarView.setBackgroundColor(Color.parseColor(background));

            // Changing snackbar text color

            View snackView = snackbar.getView();
            TextView textView = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
            if (!TextUtils.isEmpty(textColor))
                textView.setTextColor(Color.parseColor(textColor));

            // Changing Action button text color

            Button snackViewButton = (Button) snackView.findViewById(android.support.design.R.id.snackbar_action);
            if (!TextUtils.isEmpty(actionColor))
                snackViewButton.setTextColor(Color.parseColor(actionColor));
        }
        return snackbar;
    }

    /**
     * Set snackbar background, textcolor & Action button color using color resource
     *
     * @param snackbar
     * @param context
     * @param background
     * @param textColor
     * @param actionColor
     * @return
     */
    public static Snackbar getColorfulSnackBar(final Snackbar snackbar, Context context, int background, int textColor, int actionColor) {

        View snackBarView = getSnackBarLayout(snackbar);
        if (snackBarView != null) {

            try
            {
                if (background!=0)
                    snackBarView.setBackgroundColor(ContextCompat.getColor(context, background));

                // Changing snackbar text color

                View snackView = snackbar.getView();
                TextView textView = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
                if (textColor!=0)
                    textView.setTextColor(ContextCompat.getColor(context, textColor));

                // Changing Action button text color

                Button snackViewButton = (Button) snackView.findViewById(android.support.design.R.id.snackbar_action);
                if (textColor>0)
                    snackViewButton.setTextColor(ContextCompat.getColor(context, actionColor));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }
        return snackbar;
    }
}
