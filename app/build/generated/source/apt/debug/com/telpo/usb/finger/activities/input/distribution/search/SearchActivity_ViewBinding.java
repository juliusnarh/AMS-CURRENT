// Generated code from Butter Knife. Do not modify!
package com.telpo.usb.finger.activities.input.distribution.search;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.telpo.usb.finger.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchActivity_ViewBinding implements Unbinder {
  private SearchActivity target;

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchActivity_ViewBinding(SearchActivity target, View source) {
    this.target = target;

    target.itemsRecycler = Utils.findRequiredViewAsType(source, R.id.items_recycler, "field 'itemsRecycler'", RecyclerView.class);
    target.no_item = Utils.findRequiredViewAsType(source, R.id.no_item, "field 'no_item'", TextView.class);
    target.serviceRecycler = Utils.findRequiredViewAsType(source, R.id.service_recycler, "field 'serviceRecycler'", RecyclerView.class);
    target.noServiceRecord = Utils.findRequiredViewAsType(source, R.id.no_service, "field 'noServiceRecord'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    SearchActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.itemsRecycler = null;
    target.no_item = null;
    target.serviceRecycler = null;
    target.noServiceRecord = null;
  }
}
