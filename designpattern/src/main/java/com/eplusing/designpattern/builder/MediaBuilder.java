package com.eplusing.designpattern.builder;

import com.eplusing.designpattern.builder.product.Media;
import com.eplusing.designpattern.builder.product.MediaItem;

public abstract class MediaBuilder {
	public void buildBase() {}
	public void addMediaItem(MediaItem item) {}
	public Media getFinishedMedia() { return null; }
}
