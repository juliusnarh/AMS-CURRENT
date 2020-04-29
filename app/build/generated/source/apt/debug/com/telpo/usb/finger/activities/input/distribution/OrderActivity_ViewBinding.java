// Generated code from Butter Knife. Do not modify!
package com.telpo.usb.finger.activities.input.distribution;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.telpo.usb.finger.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OrderActivity_ViewBinding implements Unbinder {
  private OrderActivity target;

  @UiThread
  public OrderActivity_ViewBinding(OrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OrderActivity_ViewBinding(OrderActivity target, View source) {
    this.target = target;

    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'mToolbar'", Toolbar.class);
    target.no_order = Utils.findRequiredViewAsType(source, R.id.no_order_record, "field 'no_order'", TextView.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coord, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.orderRecycler = Utils.findRequiredViewAsType(source, R.id.order_recycler, "field 'orderRecycler'", RecyclerView.class);
    target.orderTotal = Utils.findRequiredViewAsType(source, R.id.total_Order, "field 'orderTotal'", TextView.class);
    target.checkoutBtn = Utils.findRequiredViewAsType(source, R.id.checkout_btn, "field 'checkoutBtn'", Button.class);
    target.fab = Utils.findRequiredViewAsType(source, R.id.bottomfab_order, "field 'fab'", FloatingActionButton.class);
    target.layoutBottomSheet = Utils.findRequiredViewAsType(source, R.id.bottom_sheet, "field 'layoutBottomSheet'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.no_order = null;
    target.coordinatorLayout = null;
    target.orderRecycler = null;
    target.orderTotal = null;
    target.checkoutBtn = null;
    target.fab = null;
    target.layoutBottomSheet = null;
  }
}
