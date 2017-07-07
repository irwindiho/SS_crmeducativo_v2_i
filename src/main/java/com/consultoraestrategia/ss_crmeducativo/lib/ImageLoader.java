package com.consultoraestrategia.ss_crmeducativo.lib;

import android.widget.ImageView;

/**
 * Created by kelvi on 22/02/2017.
 */

public interface ImageLoader {
  void load(ImageView imageView, String URL);
  void loadWithCircular(ImageView imageView, String URL);

}
